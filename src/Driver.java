import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.Vocabulary;

public class Driver {

	public static void main(String[] args) throws IOException {
		CharStream stdin = CharStreams.fromStream(System.in);
		Little littleLexer = new Little(stdin);
		Vocabulary vocab = littleLexer.getVocabulary();
		for (Token t:littleLexer.getAllTokens()) {
			System.out.println("Token Type: " + vocab.getSymbolicName(t.getType()));
			System.out.println("Value: " + t.getText());
		}
	}
}
