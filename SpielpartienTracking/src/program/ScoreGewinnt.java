package program;

public enum ScoreGewinnt {
	HOECHSTER("Höchster"), NIEDRIGSTER("Niedrigster"), KEINSCORE("Kein Score");
	
	private String text;
	
	private ScoreGewinnt(String text) {
		this.text = text;
	}
	
	public String toString() {
		return text;
	}

}
