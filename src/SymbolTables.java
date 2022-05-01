import java.util.ArrayList;


public class SymbolTables {
	ArrayList<SymbolTable> symTabs;
	
	public SymbolTables(ArrayList<SymbolTable> symTabs) {
		this.symTabs = symTabs;
	}
	
	public ArrayList<String> getSymbolNames() {
		ArrayList<String> result = new ArrayList<String>();
		int numNesting = symTabs.size();
		for (int i = numNesting - 1; i >= 0; i--) {
			SymbolTable symTab = symTabs.get(i);
			for (String name : symTab.getSymbolNames()) {
				if (!result.contains(name)) {
					result.add(name);
				}
			}
		}
		return result;
	}
	
	public SymbolAttribute getAttribute(String name) {
		int numNesting = symTabs.size();
		for (int i = numNesting - 1; i >= 0; i--) {
			SymbolTable symTab = symTabs.get(i);
			if (symTab.hasAttribute(name)) {
				return symTab.getAttribute(name);
			}
		}
		return null;
	}
}
