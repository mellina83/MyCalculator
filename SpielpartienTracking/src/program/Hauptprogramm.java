package program;

import javax.swing.JFrame;

import view.SpielpartienTrackerView;

public class Hauptprogramm {

	public static void main(String[] args) {
		JFrame frame = new SpielpartienTrackerView();
		frame.setVisible(true);
		
		
		System.out.println("Das ist die Main vom Spielpartien-Tracker");

	}

}
