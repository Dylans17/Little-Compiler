import java.util.ArrayList;

public class InstructionExtractor extends LittleBaseListener {
	private SymbolExtractor symTabs;
	private ArrayList<InstructionNode> instructionList;
	private InstructionNode currentInstruction;
	
	public InstructionExtractor(SymbolExtractor symTabs) {
		this.symTabs = symTabs;
		this.instructionList = new ArrayList<InstructionNode>();
	}
	
	public void simplePrint() {
		//temporary output for testing, will be removed!
		System.out.printf("There are %d read/write/assign statements!\n", instructionList.size());
	}
	
	public void printAssembly() {
		//print all variable declarations
		
	}
	
	//statement types
	@Override 
	public void enterAssign_stmt(LittleParser.Assign_stmtContext ctx) {
		currentInstruction = new AssignNode();
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
	
	@Override
	public void enterExpr(LittleParser.ExprContext ctx) {
		
	}
}


interface InstructionNode {
	void addId(String id);
	String getAssembly();
}

class AssignNode implements InstructionNode {
	String id;
	ExpressionTree valueRoot;

	public void addId(String id) {
		if (this.id != null) {
			throw new IllegalStateException(
					"Should never be in a state where an id is added twice to AssignNode");
		}
		this.id = id;
	}
	
	public void addExpr(LittleParser.ExprContext ctx) {
		this.valueRoot = ExpressionTree.parse(ctx);
	}
	
	public String getAssembly() {
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
	public String getAssembly() {
		String result = "";
		for (String id : idList) {
			//TODO: get type from symbolTable
			//TODO: use registers instead of ids
			result += "sys read[type] " + id;
		}
		return result;
	}
}

class WriteNode extends BuiltinFunc {
	public String getAssembly() {
		String result = "";
		for (String id : idList) {
			//TODO: get type from symbolTable
			//TODO: use registers instead of ids
			result += "sys write[type] " + id;
		}
		return result;
	}
}