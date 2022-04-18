
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
	
	public static BinaryNode parse(LittleParser.Expr_prefixContext ctx) {
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
	
	public static ExpressionTree parse(LittleParser.FactorContext ctx) {
		BinaryNode lChild = parse(ctx.factor_prefix());
		ExpressionTree rChild = parse(ctx.postfix_expr());
		if (lChild == null) {
			return rChild;
		}
		lChild.rChild = rChild;
		return lChild;
	}
	
	public static BinaryNode parse(LittleParser.Factor_prefixContext ctx) {
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
	
	public static ExpressionTree parse(LittleParser.Postfix_exprContext ctx) {
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
			return new LeafNode(ctx.id().getText());
		}
		if (ctx.INTLITERAL() != null) {
			return new LeafNode(Integer.parseInt(ctx.INTLITERAL().getText()));
		}
		// ctx.FLOATLITERAL() != null
		return new LeafNode(Double.parseDouble(ctx.FLOATLITERAL().getText()));
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
}

class LeafNode extends ExpressionTree {
	String type;
	String id;
	Double floatValue;
	Integer intValue;
	
	//should these be split into subclasses?
	public LeafNode(String id) {
		this.type = "id";
		this.id = id;
	}
	
	public LeafNode(Double val) {
		this.type = "FLOAT";
		this.floatValue = val;
	}
	
	public LeafNode(Integer val) {
		this.type = "INT";
		this.intValue = val;
	}
}
