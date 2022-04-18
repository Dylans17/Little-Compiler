import java.io.IOException;
import java.util.ArrayList;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Driver {

	public static void main(String[] args) throws IOException {
		CharStream stdin = CharStreams.fromStream(System.in);
		LittleLexer littleLexer = new LittleLexer(stdin);
		CommonTokenStream tokens = new CommonTokenStream(littleLexer);
		LittleParser parser = new LittleParser(tokens);
		SymbolExtractor extractor = new SymbolExtractor();

		//parser.removeErrorListeners(); //do not want default error rules
		//parser.addErrorListener(new BasicErrorListener()); //want basic yes/no

		LittleParser.ProgramContext ctx = parser.program(); //program is start rule
		ParseTreeWalker.DEFAULT.walk(extractor, ctx);
		InstructionExtractor intermediateRepresentation = new InstructionExtractor();
		ParseTreeWalker.DEFAULT.walk(intermediateRepresentation, ctx);
		
		
		ArrayList<InstructionNode> instructionList = intermediateRepresentation.getInstructions();
		//TODO: add optimizations before converting, add optimizations after converting
		
		for (InstructionNode inst : instructionList) {
			System.out.println(inst.getAssembly());
		}
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
