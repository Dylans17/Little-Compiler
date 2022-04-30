import java.util.ArrayList;

public class InstructionExtractor extends LittleBaseListener {
	private ArrayList<InstructionNode> instructionList;
	private InstructionNode currentInstruction;
	
	public InstructionExtractor() {
		this.instructionList = new ArrayList<InstructionNode>();
	}
	
	public void simplePrint() {
		//temporary output for testing, will be removed!
		System.out.printf("There are %d read/write/assign statements!\n", instructionList.size());
	}
	
	public ArrayList<InstructionNode> getInstructions() {
		return instructionList;
		
	}
	
	//statement types
	@Override 
	public void enterAssign_stmt(LittleParser.Assign_stmtContext ctx) {
		AssignNode currentInstruction = new AssignNode(ctx.assign_expr().id().getText(), ctx.assign_expr().expr());
		instructionList.add(currentInstruction);
	}
	
	@Override 
	public void enterRead_stmt(LittleParser.Read_stmtContext ctx) {
		currentInstruction = new ReadNode();
		instructionList.add(currentInstruction);
	}
	
	@Override 
	public void enterWrite_stmt(LittleParser.Write_stmtContext ctx) {
		currentInstruction = new WriteNode();
		instructionList.add(currentInstruction);
	}
	
	
	@Override public void enterReturn_stmt(LittleParser.Return_stmtContext ctx) { 
		//current implementation does not use returns
		//since we only have void main with no control statements
		throw new UnsupportedOperationException();
	}
	
	@Override public void enterIf_stmt(LittleParser.If_stmtContext ctx) {
		//control statements not used
		throw new UnsupportedOperationException();
	}
	
	@Override public void enterWhile_stmt(LittleParser.While_stmtContext ctx) {
		//control statements not used
		throw new UnsupportedOperationException();
	}
	
	@Override public void exitBase_stmt(LittleParser.Base_stmtContext ctx) {
		currentInstruction = null;
	}
	
	//building the base InstructionNodes
	
	@Override
	public void enterId_list(LittleParser.Id_listContext ctx) {
		if (currentInstruction != null)
			currentInstruction.addId(ctx.id().getText());
	}

	@Override
	public void enterId_tail(LittleParser.Id_tailContext ctx) {
		if (ctx.id() != null && currentInstruction != null)
			currentInstruction.addId(ctx.id().getText());
	}
}


interface InstructionNode {
	void addId(String id);
	String getAssembly(SymbolTables symTabs);
}

class AssignNode implements InstructionNode {
	String id;
	ExpressionTree valueRoot;

	public AssignNode(String id, LittleParser.ExprContext ctx) {
		this.id = id;
		this.valueRoot = ExpressionTree.parse(ctx);
	}
	
	public void addId(String id) {
		throw new IllegalStateException("Should not addId to AssignNode");
	}
	
	public String getAssembly(SymbolTables symTabs) {
		//TODO: actually put instructions here lmao
		System.out.print(id + " = ");
		valueRoot.print();
		return "";
	}
}

abstract class BuiltinFunc implements InstructionNode {
	//built-in functions read and write are different from
	//normal function calls since they only accept a list of identifiers
	//and NOT a list of expressions
	protected ArrayList<String> idList;
	
	public BuiltinFunc() {
		this.idList = new ArrayList<String>();
	}
	
	//probably should change this to use symbol, attribute pairs
	public void addId(String id) {
		idList.add(id);
	}
}

class ReadNode extends BuiltinFunc {
	private String assemblyReadCall(SymbolAttribute attr) {
		String type = attr.getType();
		if (type.equals("INT")) {
			return "sys readi";
		}
		if (type.equals("FLOAT")) {
			return "sys readr";
		}
		throw new UnsupportedOperationException("Cannot handle variables with type " + type);
	}
	
	public String getAssembly(SymbolTables symTabs) {
		ArrayList<String> instructions = new ArrayList<String>();
		for (String id : idList) {
			SymbolAttribute attr = symTabs.getAttribute(id);
			instructions.add(String.format("%s %s", assemblyReadCall(attr), id));
		}
		return String.join("\n", instructions);
	}
}

class WriteNode extends BuiltinFunc {
	private String assemblyWriteCall(SymbolAttribute attr) {
		String type = attr.getType();
		if (type.equals("INT")) {
			return "sys writei";
		}
		if (type.equals("FLOAT")) {
			return "sys writer";
		}
		if (type.equals("STRING")) {
			return "sys writes";
		}
		throw new UnsupportedOperationException("Cannot handle variables with type " + type);
	}
	
	public String getAssembly(SymbolTables symTabs) {
		ArrayList<String> instructions = new ArrayList<String>();
		for (String id : idList) {
			//TODO: get type from symbolTable
			SymbolAttribute attr = symTabs.getAttribute(id);
			instructions.add(String.format("%s %s", assemblyWriteCall(attr), id));
		}
		return String.join("\n", instructions);
	}
}