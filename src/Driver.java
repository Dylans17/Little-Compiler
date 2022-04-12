import java.io.IOException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Driver {

	public static void main(String[] args) throws IOException {
		CharStream stdin = CharStreams.fromStream(System.in);
		LittleLexer littleLexer = new LittleLexer(stdin);
		CommonTokenStream tokens = new CommonTokenStream(littleLexer);
		LittleParser parser = new LittleParser(tokens);
		SymbolExtractor extractor = new SymbolExtractor();

		parser.removeErrorListeners(); //do not want default error rules
		parser.addErrorListener(new BasicErrorListener()); //want basic yes/no

		LittleParser.ProgramContext ctx = parser.program(); //program is start rule
		ParseTreeWalker.DEFAULT.walk(extractor, ctx);
		
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
