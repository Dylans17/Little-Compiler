import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

class SymbolExtractor extends LittleBaseListener {

	private Stack<SymbolTable> symbolTableStack;
	private ArrayList<SymbolTable> allSymbolTables;
	private String varDeclType;
	private ArrayList<String> varDeclIdList;

	public SymbolExtractor() {
		this.symbolTableStack = new Stack<SymbolTable>();
		this.allSymbolTables = new ArrayList<SymbolTable>();

	}

	@Override
	public void enterProgram(LittleParser.ProgramContext ctx) {
		SymbolTable newSymTab = new SymbolTable("GLOBAL");
		this.symbolTableStack.push(newSymTab);
		this.allSymbolTables.add(newSymTab);

	}

	@Override
	public void exitProgram(LittleParser.ProgramContext ctx) {
		//step 3 output
		for (SymbolTable symTab : allSymbolTables) {
			symTab.print();
		}
	}

	@Override
	public void enterString_decl(LittleParser.String_declContext ctx) {
		SymbolTable current = this.symbolTableStack.peek();
		current.addSymbol(ctx.id().IDENTIFIER().getText(), new SymbolAttributes("STRING",ctx.str().STRINGLITERAL().getText()));
	}

	@Override
	public void enterVar_decl(LittleParser.Var_declContext ctx) {
		varDeclType = ctx.var_type().getText();
		varDeclIdList = new ArrayList<String>();
	}

	@Override
	public void exitVar_decl(LittleParser.Var_declContext ctx) {
		SymbolTable current = this.symbolTableStack.peek();

		for (String var: varDeclIdList) {
			current.addSymbol(var, new SymbolAttributes(varDeclType, null));
		}

		varDeclType = null;
		varDeclIdList = null;
	}

	@Override
	public void enterId_list(LittleParser.Id_listContext ctx) {
		if (varDeclIdList != null)
			varDeclIdList.add(ctx.id().getText());
	}

	@Override
	public void enterId_tail(LittleParser.Id_tailContext ctx) {
		if (ctx.id() != null && varDeclIdList != null)
			varDeclIdList.add(ctx.id().getText());
	}

	@Override
	public void enterParam_decl(LittleParser.Param_declContext ctx) {
		SymbolTable current = this.symbolTableStack.peek();
		current.addSymbol(ctx.id().getText(), new SymbolAttributes(ctx.var_type().getText(), null));
	}

	@Override
	public void enterFunc_decl(LittleParser.Func_declContext ctx) {
		SymbolTable newSymTab = new SymbolTable(ctx.id().getText());
		this.symbolTableStack.push(newSymTab);
		this.allSymbolTables.add(newSymTab);
	}

	@Override
	public void exitFunc_decl(LittleParser.Func_declContext ctx) {
		this.symbolTableStack.pop();
	}

}//end class

class SymbolTable {

	private String scope;
	private HashMap<String, SymbolAttributes> symbolTable;

	private ArrayList<String> symbolNames;

	public SymbolTable(String scope) {
		this.scope = scope;
		this.symbolTable = new HashMap<String, SymbolAttributes>();
		this.symbolNames = new ArrayList<String>();
	}

	public String getScope() {
		return this.scope;
	}

	public void addSymbol(String symbolName, SymbolAttributes attributes) {

		if(this.symbolTable.containsKey(symbolName)) {
			System.out.printf("DECLARATION ERROR %s\n", symbolName);
			System.exit(0);
		}//end if

		this.symbolTable.put(symbolName, attributes);
		this.symbolNames.add(symbolName);
	}

	public void print() {
		System.out.println("Symbol table " + this.scope);
		for (String symName : symbolNames) {
			SymbolAttributes attr = this.symbolTable.get(symName);
			System.out.printf("name %s type %s\n", symName, attr.getType());
		}
		System.out.println();
	}

}//end class

class SymbolAttributes {

	String type;
	String value;

	public SymbolAttributes(String type, String value) {
		this.type = type;
		this.value = value;
	}

	public String getType() {
		return this.type;
	}

	public String getValue() {
		return this.value;
	}
}//end class
