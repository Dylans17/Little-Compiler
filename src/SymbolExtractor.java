import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

class SymbolExtractor extends LittleBaseListener {

	private Stack<SymbolTable> symbolTableStack;
	private ArrayList<SymbolTable> allSymbolTables;

	public SymbolExtractor() {
		this.symbolTableStack = new Stack<SymbolTable>();
		this.allSymbolTables = new ArrayList<SymbolTable>();
		
	}

	@Override public void enterProgram(LittleParser.ProgramContext ctx) {
		SymbolTable newSymTab = new SymbolTable("GLOBAL");
		this.symbolTableStack.push(newSymTab);
		this.allSymbolTables.add(newSymTab);

	}

	@Override public void exitProgram(LittleParser.ProgramContext ctx) {
		//step 3 output
		for (SymbolTable symTab : allSymbolTables) {
			symTab.print();
		}
	}

	@Override public void enterPgm_body(LittleParser.Pgm_bodyContext ctx) {

	}

	@Override public void exitPgm_body(LittleParser.Pgm_bodyContext ctx) {

	}

	@Override public void enterDecl(LittleParser.DeclContext ctx) {

	}

	@Override public void exitDecl(LittleParser.DeclContext ctx) {

	}

	@Override public void enterString_decl(LittleParser.String_declContext ctx) {

		this.symbolTableStack.peek().addSymbol(ctx.id().IDENTIFIER().getText(), new SymbolAttributes("STRING",ctx.str().STRINGLITERAL().getText()));

	}

	@Override public void exitString_decl(LittleParser.String_declContext ctx) {

	}

	@Override public void enterVar_decl(LittleParser.Var_declContext ctx) {

	}

	@Override public void exitVar_decl(LittleParser.Var_declContext ctx) {

	}

	@Override public void enterFunc_decl(LittleParser.Func_declContext ctx) {

	}

	@Override public void exitFunc_decl(LittleParser.Func_declContext ctx) {

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
