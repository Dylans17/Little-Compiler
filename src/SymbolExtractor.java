import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

class SymbolExtractor extends LittleBaseListener {

	private Stack<SymbolTable> symbolTableStack;
	private ArrayList<SymbolTable> allSymbolTables;
	private String varDeclType;
	private ArrayList<String> varDeclIdList;
	private int currentBlockNumber;
	
	public SymbolExtractor() {
		this.symbolTableStack = new Stack<SymbolTable>();
		this.allSymbolTables = new ArrayList<SymbolTable>();
		this.currentBlockNumber = 1;
	}

	public void printAllSymbolTables() {
		//step 3 output
		for (SymbolTable symTab : allSymbolTables) {
			symTab.print();
		}
	}
	
	public SymbolTables getSymbolTables() {
		//since step 4 is only using main and globals, this way works
		//to get the symbol table in general, I think the best way to accomplish that
		//is to run SymbolExtractor at the same time as InstructionExtractor
		//then we can access the symbolTableStack while reading
		return new SymbolTables(allSymbolTables);
	}
	
	@Override
	public void enterProgram(LittleParser.ProgramContext ctx) {
		SymbolTable newSymTab = new SymbolTable("GLOBAL");
		this.symbolTableStack.push(newSymTab);
		this.allSymbolTables.add(newSymTab);

	}

	@Override
	public void enterString_decl(LittleParser.String_declContext ctx) {
		SymbolTable current = this.symbolTableStack.peek();
		current.addSymbol(ctx.id().IDENTIFIER().getText(), new StringAttribute(ctx.str().STRINGLITERAL().getText()));
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
			current.addSymbol(var, new SymbolAttribute(varDeclType));
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
		current.addSymbol(ctx.id().getText(), new SymbolAttribute(ctx.var_type().getText()));
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
	
	@Override 
	public void enterIf_stmt(LittleParser.If_stmtContext ctx) {
		SymbolTable newSymTab = new SymbolTable("BLOCK " + this.currentBlockNumber++);
		this.symbolTableStack.push(newSymTab);
		this.allSymbolTables.add(newSymTab);
	}
	
	@Override
	public void exitIf_stmt(LittleParser.If_stmtContext ctx) {
		this.symbolTableStack.pop();
	}
	
	@Override
	public void enterElse_part(LittleParser.Else_partContext ctx) {
		if (ctx.getChildCount() == 0)
			return;
		this.symbolTableStack.pop();
		SymbolTable newSymTab = new SymbolTable("BLOCK " + this.currentBlockNumber++);
		this.symbolTableStack.push(newSymTab);
		this.allSymbolTables.add(newSymTab);
	}
	@Override
	public void enterWhile_stmt(LittleParser.While_stmtContext ctx) {
		SymbolTable newSymTab = new SymbolTable("BLOCK " + this.currentBlockNumber++);
		this.symbolTableStack.push(newSymTab);
		this.allSymbolTables.add(newSymTab);
	}
	
	@Override
	public void exitWhile_stmt(LittleParser.While_stmtContext ctx) {
		this.symbolTableStack.pop();
	}

}//end class
