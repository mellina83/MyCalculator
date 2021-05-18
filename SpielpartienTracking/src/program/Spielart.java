package program;

public enum Spielart {
	KOOPERATIV("Kooperativ"), KOMPETITIV("Kompetitiv"), SEMIKOOPERATIV("Semi-Kooperativ");
	
	private String text;
	
	private Spielart(String text) {
		this.text = text;
	}
	
	public String toString() {
		return text;
	}

}
