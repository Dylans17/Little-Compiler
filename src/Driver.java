import java.io.IOException;
import org.antlr.v4.runtime.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Driver {

	public static void main(String[] args) throws IOException {
		CharStream stdin = CharStreams.fromStream(System.in);
		LittleLexer littleLexer = new LittleLexer(stdin);
		CommonTokenStream tokens = new CommonTokenStream(littleLexer);
		LittleParser parser = new LittleParser(tokens);
		parser.removeErrorListeners(); //do not want default error rules
		parser.addErrorListener(new BasicErrorListener()); //want basic yes/no
		parser.program(); //program is start rule
		System.out.println("Accepted");
	}
}


class BasicErrorListener extends BaseErrorListener {
	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
	int line, int charPositionInLine, String msg, RecognitionException e) {
		System.out.println("Not accepted");
		System.exit(-1);
	}
}

class SymbolExtractor extends LittleBaseListener {
	
	private Stack<SymbolTable> symbolTableStack;
	private SymbolTable currentTable;
	
	public SymbolExtractor() {
		this.symbolTableStack = new Stack<SymbolTable>();
		this.currentTable = null;
	}
	
	@Override public void enterProgram(LittleParser.ProgramContext ctx) {
		
		this.symbolTableStack.push(new SymbolTable("GLOBAL"));
		this.currentTable = this.symbolTableStack.peek();
		
	}
	
	@Override public void exitProgram(LittleParser.ProgramContext ctx) {
		
		
		
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
		
		this.currentTable.addSymbol(ctx.id().IDENTIFIER().getText(), new SymbolAttributes("STRING",ctx.str().STRINGLITERAL().getText()));
		
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

class SymbolTable{
	
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
	
	public String getValue()
	{
		return this.value;
	}
	
}//end classs