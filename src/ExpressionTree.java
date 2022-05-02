public class ExpressionTree {
	public static ExpressionTree parse(LittleParser.ExprContext ctx) {
		BinaryNode lChild = parse(ctx.expr_prefix());
		ExpressionTree rChild = parse(ctx.factor());
		if (lChild == null) {
			return rChild;
		}
		lChild.rChild = rChild;
		return lChild;
	}
	
	private static BinaryNode parse(LittleParser.Expr_prefixContext ctx) {
		/**
		 * Returns Binary Node with missing Right Child or null if undefined
		 */
		if (ctx.addop() == null) {
			return null;
		}
		BinaryNode lChild = parse(ctx.expr_prefix());
		ExpressionTree factor = parse(ctx.factor());
		String operator = ctx.addop().getText();
		if (lChild == null) {
			return new BinaryNode(factor, operator);
		}
		//otherwise factor is the right child of lChild
		
		lChild.rChild = factor;
		return new BinaryNode(lChild, operator);
	}
	
	private static ExpressionTree parse(LittleParser.FactorContext ctx) {
		BinaryNode lChild = parse(ctx.factor_prefix());
		ExpressionTree rChild = parse(ctx.postfix_expr());
		if (lChild == null) {
			return rChild;
		}
		lChild.rChild = rChild;
		return lChild;
	}
	
	private static BinaryNode parse(LittleParser.Factor_prefixContext ctx) {
		/**
		 * Returns Binary Node with missing Right Child or null if undefined
		 */
		if (ctx.mulop() == null) {
			return null;
		}
		BinaryNode lChild = parse(ctx.factor_prefix());
		ExpressionTree postfix = parse(ctx.postfix_expr());
		String operator = ctx.mulop().getText();
		if (lChild == null) {
			return new BinaryNode(postfix, operator);
		}
		//otherwise postfix is the right child of lChild
		
		lChild.rChild = postfix;
		return new BinaryNode(lChild, operator);
	}
	
	private static ExpressionTree parse(LittleParser.Postfix_exprContext ctx) {
		if (ctx.call_expr() != null) {
			throw new UnsupportedOperationException("Functions other than main are not implemented");
		}
		return parse(ctx.primary());
	}

	private static ExpressionTree parse(LittleParser.PrimaryContext ctx) {
		if (ctx.expr() != null) {
			return parse(ctx.expr());
		}
		if (ctx.id() != null) {
			return new IdLeaf(ctx.id().getText());
		}
		if (ctx.INTLITERAL() != null) {
			return new IntLeaf(Integer.parseInt(ctx.INTLITERAL().getText()));
		}
		// ctx.FLOATLITERAL() != null
		return new FloatLeaf(Double.parseDouble(ctx.FLOATLITERAL().getText()));
	}
	
	public AssemblyReturnPair getAssembly(SymbolTables symTabs, boolean intMode) {
		throw new IllegalStateException("getAssembly should not be called on blank ExpressionTree");
	}
}

class BinaryNode extends ExpressionTree {
	ExpressionTree lChild;
	ExpressionTree rChild;
	String operator;
	
	public BinaryNode(ExpressionTree lChild, ExpressionTree rChild, String operator) {
		this.lChild = lChild;
		this.rChild = rChild;
		this.operator = operator;
	}
	
	public BinaryNode(ExpressionTree lChild, String operator) {
		this.lChild = lChild;
		this.operator = operator;
	}
	
	public AssemblyReturnPair getAssembly(SymbolTables symTabs, boolean intMode) {
		AssemblyReturnPair lResult = lChild.getAssembly(symTabs, intMode);
		AssemblyReturnPair rResult = rChild.getAssembly(symTabs, intMode);
		switch (operator) {
		case "+":
			return intMode ? integerAddAssembly(lResult, rResult) : floatAddAssembly(lResult, rResult);
		case "-":
			return intMode ? integerSubtractAssembly(lResult, rResult) : floatSubtractAssembly(lResult, rResult);
		case "*":
			return intMode ? integerMultAssembly(lResult, rResult) : floatMultAssembly(lResult, rResult);
		case "/":
			return intMode ? integerDivAssembly(lResult, rResult) : floatDivAssembly(lResult, rResult);
		}
		throw new IllegalStateException("Unknown Operator " + operator);
	}
	
	private AssemblyReturnPair integerAddAssembly(AssemblyReturnPair lResult, AssemblyReturnPair rResult) {
		String register = RegisterCounter.getNext();
		String code = lResult.getCode() + rResult.getCode();
		code += String.format("move %s %s\n", lResult.getId(), register);
		code += String.format("addi %s %s\n", rResult.getId(), register);
		return new AssemblyReturnPair(code, register);
	}
	
	private AssemblyReturnPair floatAddAssembly(AssemblyReturnPair lResult, AssemblyReturnPair rResult) {
		String register = RegisterCounter.getNext();
		String code = lResult.getCode() + rResult.getCode();
		code += String.format("move %s %s\n", lResult.getId(), register);
		code += String.format("addi %s %s\n", rResult.getId(), register);
		return new AssemblyReturnPair(code, register);
	}
	
	private AssemblyReturnPair integerSubtractAssembly(AssemblyReturnPair lResult, AssemblyReturnPair rResult) {
		String register = RegisterCounter.getNext();
		String code = lResult.getCode() + rResult.getCode();
		code += String.format("move %s %s\n", lResult.getId(), register);
		code += String.format("subi %s %s\n", rResult.getId(), register);
		return new AssemblyReturnPair(code, register);
	}
	
	private AssemblyReturnPair floatSubtractAssembly(AssemblyReturnPair lResult, AssemblyReturnPair rResult) {
		String register = RegisterCounter.getNext();
		String code = lResult.getCode() + rResult.getCode();
		code += String.format("move %s %s\n", lResult.getId(), register);
		code += String.format("subr %s %s\n", rResult.getId(), register);
		return new AssemblyReturnPair(code, register);
	}
	
	private AssemblyReturnPair integerMultAssembly(AssemblyReturnPair lResult, AssemblyReturnPair rResult) {
		String register = RegisterCounter.getNext();
		String code = lResult.getCode() + rResult.getCode();
		code += String.format("move %s %s\n", lResult.getId(), register);
		code += String.format("muli %s %s\n", rResult.getId(), register);
		return new AssemblyReturnPair(code, register);
	}
	
	private AssemblyReturnPair floatMultAssembly(AssemblyReturnPair lResult, AssemblyReturnPair rResult) {
		String register = RegisterCounter.getNext();
		String code = lResult.getCode() + rResult.getCode();
		code += String.format("move %s %s\n", lResult.getId(), register);
		code += String.format("mulr %s %s\n", rResult.getId(), register);
		return new AssemblyReturnPair(code, register);
	}
	
	private AssemblyReturnPair integerDivAssembly(AssemblyReturnPair lResult, AssemblyReturnPair rResult) {
		String register = RegisterCounter.getNext();
		String code = lResult.getCode() + rResult.getCode();
		code += String.format("move %s %s\n", lResult.getId(), register);
		code += String.format("divi %s %s\n", rResult.getId(), register);
		return new AssemblyReturnPair(code, register);
	}
	
	private AssemblyReturnPair floatDivAssembly(AssemblyReturnPair lResult, AssemblyReturnPair rResult) {
		String register = RegisterCounter.getNext();
		String code = lResult.getCode() + rResult.getCode();
		code += String.format("move %s %s\n", lResult.getId(), register);
		code += String.format("divr %s %s\n", rResult.getId(), register);
		return new AssemblyReturnPair(code, register);
	}
}


class IdLeaf extends ExpressionTree {
	String id;
	public IdLeaf(String id) {
		this.id = id;
	}
	
	public AssemblyReturnPair getAssembly(SymbolTables symTabs, boolean intMode) {
		SymbolAttribute attr = symTabs.getAttribute(id);
		return intMode ? getAssemblyInt((IntAttribute) attr) : getAssemblyFloat((FloatAttribute) attr);
	}
	
	private AssemblyReturnPair getAssemblyInt(IntAttribute attr) {
		AssemblyReturnPair result = new AssemblyReturnPair("");
		if (attr.valueIsStored()) {
			result.setValue(attr.getStoredValue().toString());
		}
		else if (attr.valueIsRegister()) {
			result.setValue(attr.getRegister());
		}
		else {
			result.setValue(id);
		}
		return result;
	}
	
	private AssemblyReturnPair getAssemblyFloat(FloatAttribute attr) {
		AssemblyReturnPair result = new AssemblyReturnPair("");
		if (attr.valueIsStored()) {
			result.setValue(attr.getStoredValue().toString());
		}
		else if (attr.valueIsRegister()) {
			result.setValue(attr.getRegister());
		}
		else {
			result.setValue(id);
		}
		return result;
	}
	
}

class FloatLeaf extends ExpressionTree {
	Double floatValue;
	public FloatLeaf(Double val) {
		this.floatValue = val;
	}
	
	public AssemblyReturnPair getAssembly(SymbolTables symTabs, boolean intMode) {
		if (intMode) {
			throw new IllegalStateException("Cannot mix types. There is a float in an int expression.");
		}
		return new AssemblyReturnPair("", floatValue.toString());
	}
}

class IntLeaf extends ExpressionTree {
	Integer intValue;
	public IntLeaf(Integer val) {
		this.intValue = val;
	}
	
	public AssemblyReturnPair getAssembly(SymbolTables symTabs, boolean intMode) {
		return new AssemblyReturnPair("", intValue.toString());
	}
}

class AssemblyReturnPair {
	private String code;
	private String id;
	
	public AssemblyReturnPair() {}
	public AssemblyReturnPair(String code) {
		this.code = code;
	}
	public AssemblyReturnPair(String code, String id) {
		this.code = code;
		this.id = id;
	}
	
	public String getCode() {
		if (code == null) {
			return "";
		}
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getId() {
		return id;
	}
	public void setValue(String id) {
		this.id = id;
	}	
}

class RegisterCounter {
	private static int registerNumber = 0;
	public static void set(int newNum) {
		registerNumber = newNum;
	}
	public static String getNext() {
		return "r" + registerNumber++;
	}
}
