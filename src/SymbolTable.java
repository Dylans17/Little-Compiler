import java.util.ArrayList;
import java.util.HashMap;

public class SymbolTable {

	private String scope;
	private HashMap<String, SymbolAttribute> symbolTable;

	private ArrayList<String> symbolNames;

	public SymbolTable(String scope) {
		this.scope = scope;
		this.symbolTable = new HashMap<String, SymbolAttribute>();
		this.symbolNames = new ArrayList<String>();
	}

	public String getScope() {
		return this.scope;
	}

	public void addSymbol(String symbolName, SymbolAttribute attributes) {

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
			SymbolAttribute attr = this.symbolTable.get(symName);
			System.out.printf("name %s type %s", symName, attr.getType());
			if (attr instanceof StringAttribute) {
				System.out.printf(" value %s", ((StringAttribute) attr).getValue());
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public boolean hasAttribute(String id) {
		return symbolTable.containsKey(id);
	}
	
	public SymbolAttribute getAttribute(String id) {
		return symbolTable.get(id);
	}

	public ArrayList<String> getSymbolNames() {
		return symbolNames;
	}
}//end class

class SymbolAttribute {
	private String type;

	public SymbolAttribute(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}
}//end class

class StringAttribute extends SymbolAttribute {
	private String value;

	public StringAttribute(String value) {
		super("STRING");
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}//end class