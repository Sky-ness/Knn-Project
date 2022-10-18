package csvReader;

public enum OuiNon {
	OUI(true), NON(false);
	
	boolean value;
	
	OuiNon( boolean v) {
		value = v;
	}
	
	public boolean getV() {
		return value;
	}
}
