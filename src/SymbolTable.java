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

class IntAttribute extends SymbolAttribute {
	//0-not known, 1-exact value, 2-register
	private int valueKnown;
	private Integer storedValue;
	private String storedRegister;
	public IntAttribute() {
		super("INT");
		valueKnown = 0;
	}
	
	public void storeRegister(String register) {
		valueKnown = 2;
		this.storedRegister = register;
	}
	
	public void storeValue(int value) {
		valueKnown = 1;
		storedValue = value;
	}
	
	public boolean valueIsStored() {
		return valueKnown == 1;
	}
	
	public Integer getStoredValue() {
		return valueIsStored() ? storedValue : null;
	}
	
	public boolean valueIsRegister() {
		return valueKnown == 2;
	}
	
	public String getRegister() {
		return valueIsRegister() ? storedRegister : null;
	}
	
	public String getStorageString(String id) {
		if (valueIsStored()) {
			return getStoredValue().toString();
		}
		else if (valueIsRegister()) {
			return getRegister();
		}
		else {
			return id;
		}
	}
}

class FloatAttribute extends SymbolAttribute {
	//0-not known, 1-exact value, 2-register
	private int valueKnown;
	private Double storedValue;
	private String storedRegister;
	public FloatAttribute() {
		super("FLOAT");
		valueKnown = 0;
	}
	
	public void storeRegister(String register) {
		valueKnown = 2;
		this.storedRegister = register;
	}
	
	public void storeValue(double value) {
		valueKnown = 1;
		storedValue = value;
	}
	
	public boolean valueIsStored() {
		return valueKnown == 1;
	}
	
	public Double getStoredValue() {
		return valueIsStored() ? storedValue : null;
	}
	
	public boolean valueIsRegister() {
		return valueKnown == 2;
	}
	
	public String getRegister() {
		return valueIsRegister() ? storedRegister : null;
	}
	
	public String getStorageString(String id) {
		if (valueIsStored()) {
			return getStoredValue().toString();
		}
		else if (valueIsRegister()) {
			return getRegister();
		}
		else {
			return id;
		}
	}
}

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