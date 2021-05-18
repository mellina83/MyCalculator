package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import model.SpielpartienTrackerDBModel;
import program.ScoreGewinnt;
import view.SpielpartienTrackerView;

public class SpielpartienTrackerController extends WindowAdapter implements ActionListener {
	
	private SpielpartienTrackerView view;
	private SpielpartienTrackerDBModel model;
	
	//Konstruktor
	public SpielpartienTrackerController (SpielpartienTrackerView view) {
		this.view = view;
		this.model = new SpielpartienTrackerDBModel();
		
	}
	
	//implementierte Methoden
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == view.getBtnBeenden() || e.getSource() == view.getMniBeenden()) {
			beenden();
		} else if (e.getSource() == view.getBtnLoeschen()) {
			loeschen();
		} else if (e.getSource() == view.getBtnSpeichern()) {
			speichern();
		} else if (e.getSource() == view.getMniBeenden()) {
			beenden();
		} else if (e.getSource() == view.getMniInfo()) {
			infoText();
		} else if (e.getSource() == view.getMniSpeicherinfo()) {
			speicherinfo();
		} else if (view.getCobScoreGewinnt().getSelectedItem().equals(ScoreGewinnt.KEINSCORE)) {
			view.getTxfScoreSpieler1().setEditable(false);
			view.getTxfScoreSpieler2().setEditable(false);
			view.getTxfScoreSpieler3().setEditable(false);
			view.getTxfScoreSpieler4().setEditable(false);
		} else if (!view.getCobScoreGewinnt().getSelectedItem().equals(ScoreGewinnt.KEINSCORE)) {
			view.getTxfScoreSpieler1().setEditable(true);
			view.getTxfScoreSpieler2().setEditable(true);
			view.getTxfScoreSpieler3().setEditable(true);
			view.getTxfScoreSpieler4().setEditable(true);
		} 
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		beenden();
	}
	
	//Ausgelagerte Methoden
	public void beenden() {
		int antwort = JOptionPane.showConfirmDialog(null, "Möchten Sie die Anwendung beenden?", "Beenden", JOptionPane.YES_NO_OPTION);
		if (antwort == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	
	
	public void speichern() {
		
		if (view.getTxfSpielname().getText().length() <= 2 || view.getTxfDatum().getText().length() != 8 || !bestehtAusZahlen(view.getTxfDatum().getText()) || !bestehtAusZahlen(view.getTxfDauer().getText())
				|| view.getTxfSpieler1().getText().length() < 1 && view.getTxfScoreSpieler1().getText().length() > 1
				|| view.getTxfSpieler2().getText().length() < 1 && view.getTxfScoreSpieler2().getText().length() > 1
				|| view.getTxfSpieler3().getText().length() < 1 && view.getTxfScoreSpieler3().getText().length() > 1
				|| view.getTxfSpieler4().getText().length() < 1 && view.getTxfScoreSpieler4().getText().length() > 1
				|| view.getTxfSpieler1().getText().length() < 1 && view.getChbGewinner1().isSelected()
				|| view.getTxfSpieler2().getText().length() < 1 && view.getChbGewinner2().isSelected()
				|| view.getTxfSpieler3().getText().length() < 1 && view.getChbGewinner3().isSelected()
				|| view.getTxfSpieler4().getText().length() < 1 && view.getChbGewinner4().isSelected()) {
			fehlermeldungenWerfen();
		} else {
			//Datensatz als String zusammenfassen
			String spielpartieDatensatz = view.getTxfSpielname().getText() + ";"
			+ view.getCobSpielart().getSelectedItem() + ";"
			+ view.getChbEigenesSpiel().isSelected() + ";"
			+ view.getTxfVariante().getText() + ";"
			+ view.getTxfDatum().getText() + ";"
			+ view.getTxfDauer().getText() + ";"
			+ view.getCobScoreGewinnt().getSelectedItem() + ";"
			+ view.getTxfSpieler1().getText() + ";"
			+ view.getTxfScoreSpieler1().getText() + ";"
			+ view.getChbGewinner1().isSelected() + ";"
			+ view.getTxfSpieler2().getText() + ";"
			+ view.getTxfScoreSpieler2().getText() + ";"
			+ view.getChbGewinner2().isSelected() + ";"
			+ view.getTxfSpieler3().getText() + ";"
			+ view.getTxfScoreSpieler3().getText() + ";"
			+ view.getChbGewinner3().isSelected() + ";"
			+ view.getTxfSpieler4().getText() + ";"
			+ view.getTxfScoreSpieler4().getText() + ";"
			+ view.getChbGewinner4().isSelected() + ";";
			
			//Aufruf der Speichermethode im Model
			model.inDateiSchreiben(spielpartieDatensatz);
			System.out.println(spielpartieDatensatz);
			
			//Eingaben im Formular loeschen und Bestaetigung als Popup anzeigen
			loeschen();
			JOptionPane.showMessageDialog(null, "Datensatz wurde gespeichert");
		}
	}
	
	
	public void fehlermeldungenWerfen()  {
		if (view.getTxfSpielname().getText().length() <= 2) {
			try {
				throw new IllegalArgumentException();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(view, "Name des Spiels muss mindestens aus 2 Buchstaben bestehen", "Eingabefehler", JOptionPane.ERROR_MESSAGE);
			}
		} else if (view.getTxfDatum().getText().length() != 8 || !bestehtAusZahlen(view.getTxfDatum().getText())) {
			try {
				throw new IllegalArgumentException();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(view, "Datum ist ein Pflichtfeld, muss aus Zahlen bestehen\nund wie folgt geschrieben werden: MMTTYYYY\nBeispiel: 15032021 fuer 15.03.2021", "Eingabefehler", JOptionPane.ERROR_MESSAGE);
			}
		} else if (view.getTxfDauer().getText().length() < 1 || !bestehtAusZahlen(view.getTxfDauer().getText())) {
			try {
				throw new IllegalArgumentException();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(view, "Spieldauer ist ein Pflichtfeld und darf nur aus Zahlen bestehen", "Eingabefehler", JOptionPane.ERROR_MESSAGE);
			}
		} else if (view.getTxfSpieler1().getText().length() < 1 && view.getTxfScoreSpieler1().getText().length() > 1
				|| view.getTxfSpieler2().getText().length() < 1 && view.getTxfScoreSpieler2().getText().length() > 1
				|| view.getTxfSpieler3().getText().length() < 1 && view.getTxfScoreSpieler3().getText().length() > 1
				|| view.getTxfSpieler4().getText().length() < 1 && view.getTxfScoreSpieler4().getText().length() > 1) {
			try {
				throw new IllegalArgumentException();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(view, "Wenn Punkte eingegeben wurden, muss der Name des Spielers eingetragen sein", "Eingabefehler", JOptionPane.ERROR_MESSAGE);
			}
		} else if (view.getTxfSpieler1().getText().length() < 1 && view.getChbGewinner1().isSelected()
				|| view.getTxfSpieler2().getText().length() < 1 && view.getChbGewinner2().isSelected()
				|| view.getTxfSpieler3().getText().length() < 1 && view.getChbGewinner3().isSelected()
				|| view.getTxfSpieler4().getText().length() < 1 && view.getChbGewinner4().isSelected()) {
			try {
				throw new IllegalArgumentException();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(view, "Wenn ein Spieler als Gewinner markiert ist, muss der Name eingetragen sein", "Eingabefehler", JOptionPane.ERROR_MESSAGE);
			}
		} 
		
	}
	
	

	
	public boolean bestehtAusZahlen (String eingabe){
		  for( int i = 0, n = eingabe.length(); i<n; i++ )
		    if( Character.isDigit( eingabe.charAt( i ) )) {
		    	return true;	
		    }
		  return false;
		}
	
	

	public void infoText() {
		JOptionPane.showMessageDialog(view, "Spielpartien-Tracker 2021" + System.lineSeparator() + "von Melanie Dürbeck", "Information", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void loeschen() {
		view.getTxfSpielname().setText("");
		view.getTxfVariante().setText("");
		view.getTxfDatum().setText("");
		view.getTxfDauer().setText("");
		view.getTxfSpieler1().setText("");
		view.getTxfSpieler2().setText("");
		view.getTxfSpieler3().setText("");
		view.getTxfSpieler4().setText("");
		view.getTxfScoreSpieler1().setText("");
		view.getTxfScoreSpieler2().setText("");
		view.getTxfScoreSpieler3().setText("");
		view.getTxfScoreSpieler4().setText("");
		view.getCobSpielart().setSelectedIndex(0);
		view.getCobScoreGewinnt().setSelectedIndex(0);
		view.getChbEigenesSpiel().setSelected(false);;
		view.getChbGewinner1().setSelected(false);
		view.getChbGewinner2().setSelected(false);
		view.getChbGewinner3().setSelected(false);
		view.getChbGewinner4().setSelected(false);
	}
	
	public void speicherinfo() {
		JOptionPane.showMessageDialog(view, "Speicherort:" + System.lineSeparator() + "C:/SpielpartienTrackerDB", "Information", JOptionPane.INFORMATION_MESSAGE);
	
	}






}
