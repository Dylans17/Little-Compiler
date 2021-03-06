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
        SymbolAttribute attr = symTabs.getAttribute(id);
        boolean intMode = attr.getType().equals("INT");
        AssemblyReturnPair result = valueRoot.getAssembly(symTabs, intMode);
        
        if (intMode) {
            IntAttribute attrI = (IntAttribute) attr;
            String value = result.getId();
            try {
                int intVal = Integer.parseInt(value);
                attrI.storeValue(intVal);
            }
            catch (NumberFormatException e) {
                attrI.storeRegister(value);
            }
        }
        else {
            FloatAttribute attrF = (FloatAttribute) attr;
            String fValue = result.getId();
            try {
            	double floatVal = Double.parseDouble(fValue);
            	attrF.storeValue(floatVal);
            }
            catch(NumberFormatException e) {
            	attrF.storeRegister(fValue);
            }
        }
        return result.getCode();
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
	public String getAssembly(SymbolTables symTabs) {
		ArrayList<String> instructions = new ArrayList<String>();
		for (String id : idList) {
			SymbolAttribute attr = symTabs.getAttribute(id);
			instructions.add(assemblyReadCall(attr));
		}
		return String.join("\n", instructions);
	}

	private String assemblyReadCall(SymbolAttribute attr) {
		String type = attr.getType();
		String register = RegisterCounter.getNext();
		if (type.equals("INT")) {
			IntAttribute attrI = (IntAttribute) attr;
			attrI.storeRegister(register);
			return "sys readi " + register;
		}
		if (type.equals("FLOAT")) {
			FloatAttribute attrF = (FloatAttribute) attr;
			attrF.storeRegister(register);
			return "sys readr " + register;
		}
		throw new UnsupportedOperationException("Cannot read variables with type " + type);
	}
}

class WriteNode extends BuiltinFunc {
	private String assemblyWriteCall(SymbolAttribute attr, String id) {
		String type = attr.getType();
		if (type.equals("INT")) {
			IntAttribute attrI = ((IntAttribute) attr);
			String value = attrI.getStorageString(id);
			if (!attrI.valueIsStored()) {
				return "sys writei " + value;
			}
			String register = RegisterCounter.getNext();
			return String.format("move %s %s\nsys writei %s", value, register, register);
		}
		if (type.equals("FLOAT")) {
			FloatAttribute attrF = ((FloatAttribute) attr);
			String value = attrF.getStorageString(id);
			if (!attrF.valueIsStored()) {
				return "sys writer " + value;
			}
			String register = RegisterCounter.getNext();
			return String.format("move %s %s\nsys writer %s", value, register, register);
		}
		if (type.equals("STRING")) {
			return "sys writes " + id;
		}
		throw new UnsupportedOperationException("Cannot handle variables with type " + type);
	}
	
	public String getAssembly(SymbolTables symTabs) {
		ArrayList<String> instructions = new ArrayList<String>();
		for (String id : idList) {
			//TODO: get type from symbolTable
			SymbolAttribute attr = symTabs.getAttribute(id);
			instructions.add(assemblyWriteCall(attr, id));
		}
		return String.join("\n", instructions);
	}
}