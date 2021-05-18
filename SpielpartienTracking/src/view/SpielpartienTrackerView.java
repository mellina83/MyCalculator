package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.Date;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.SpielpartienTrackerController;
import program.ScoreGewinnt;
import program.Spielart;

public class SpielpartienTrackerView extends JFrame {
	
	//Komponenten deklarieren
	
	private SpielpartienTrackerController controller;
	
	private JLabel lblSpielname;
	private JLabel lblEigenesSpiel;
	private JLabel lblSpielart;
	private JLabel lblVariante;
	private JLabel lblSpielernamen;
	private JLabel lblScores;
	private JLabel lblGewinner;
	private JLabel lblScoreGewinnt;
	private JLabel lblDatum;
	private JLabel lblDauer;
	
	private JTextField txfSpielname;
	private JCheckBox chbEigenesSpiel;
	private JComboBox<Spielart> cobSpielart;
	private JTextField txfVariante;
	private JTextField txfDatum;
	private JTextField txfDauer;
	private JTextField txfSpieler1;
	private JTextField txfSpieler2;
	private JTextField txfSpieler3;
	private JTextField txfSpieler4;
	private JTextField txfScoreSpieler1;
	private JTextField txfScoreSpieler2;
	private JTextField txfScoreSpieler3;
	private JTextField txfScoreSpieler4;
	private JCheckBox chbGewinner1;
	private JCheckBox chbGewinner2;
	private JCheckBox chbGewinner3;
	private JCheckBox chbGewinner4;
	private JComboBox<ScoreGewinnt> cobScoreGewinnt;
	
	private JButton btnLoeschen;
	private JButton btnSpeichern;
	private JButton btnBeenden;
	
	private JMenuBar menubar;
	private JMenu mnuDatei;
	private JMenu mnuInfo;
	private JMenuItem mniSpeicherinfo;
	private JMenuItem mniBeenden;
	private JMenuItem mniInfo;
	
	private JPanel pnlInhalt; //Container fuer die Komponenten
	private JPanel pnlSpielInfos;
	private JPanel pnlSpielerInfos;
	private JPanel pnlButtons;
	
	
	public SpielpartienTrackerView() {
		this.setTitle("Spielpartien-Tracker");
		this.setSize(500, 600);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.controller = new SpielpartienTrackerController (this);
		
		this.initComponents();
		
		//Komponenten hinzufuegen
		
		menubar.add(mnuDatei);
		menubar.add(mnuInfo);
		mnuDatei.add(mniSpeicherinfo);
		mnuDatei.add(mniBeenden);
		mnuInfo.add(mniInfo);
		this.setJMenuBar(menubar);
		
		pnlSpielInfos.add(lblSpielname);
		pnlSpielInfos.add(txfSpielname);
		pnlSpielInfos.add(lblSpielart);
		pnlSpielInfos.add(cobSpielart);
		pnlSpielInfos.add(lblEigenesSpiel);
		pnlSpielInfos.add(chbEigenesSpiel);
		pnlSpielInfos.add(lblVariante);
		pnlSpielInfos.add(txfVariante);
		pnlSpielInfos.add(lblDatum);
		pnlSpielInfos.add(txfDatum);
		pnlSpielInfos.add(lblDauer);
		pnlSpielInfos.add(txfDauer);
		pnlSpielInfos.add(lblScoreGewinnt);
		pnlSpielInfos.add(cobScoreGewinnt);
		
		pnlSpielerInfos.add(lblSpielernamen);
		pnlSpielerInfos.add(lblScores);
		pnlSpielerInfos.add(lblGewinner);
		pnlSpielerInfos.add(txfSpieler1);
		pnlSpielerInfos.add(txfScoreSpieler1);
		pnlSpielerInfos.add(chbGewinner1);
		pnlSpielerInfos.add(txfSpieler2);
		pnlSpielerInfos.add(txfScoreSpieler2);
		pnlSpielerInfos.add(chbGewinner2);
		pnlSpielerInfos.add(txfSpieler3);
		pnlSpielerInfos.add(txfScoreSpieler3);
		pnlSpielerInfos.add(chbGewinner3);
		pnlSpielerInfos.add(txfSpieler4);
		pnlSpielerInfos.add(txfScoreSpieler4);
		pnlSpielerInfos.add(chbGewinner4);
		
		pnlButtons.add(btnLoeschen);
		pnlButtons.add(btnSpeichern);
		pnlButtons.add(btnBeenden);
		
		pnlInhalt.add(pnlSpielInfos);
		pnlInhalt.add(pnlSpielerInfos);
		pnlInhalt.add(pnlButtons);
		
		this.setContentPane(pnlInhalt);
		
		//Layout der Panels
		pnlInhalt.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnlSpielInfos.setLayout(new GridLayout(7, 2, 10, 15));
		pnlSpielerInfos.setLayout(new GridLayout(5, 3, 10, 15));
		pnlButtons.setLayout(new FlowLayout(FlowLayout.CENTER));
			
		//Listener hinzufuegen
		mniSpeicherinfo.addActionListener(controller);
		mniBeenden.addActionListener(controller);
		mniInfo.addActionListener(controller);
		cobSpielart.addActionListener(controller);
		cobScoreGewinnt.addActionListener(controller);
		btnLoeschen.addActionListener(controller);
		btnSpeichern.addActionListener(controller);
		btnBeenden.addActionListener(controller);
		this.addWindowListener(controller);
		
		
	} //Ende Konstruktor
	
	
	public void initComponents() {
		
		this.menubar = new JMenuBar();
		this.mnuDatei = new JMenu("Datei");
		this.mnuInfo = new JMenu("Info");
		this.mniSpeicherinfo = new JMenuItem("Speicherinfo");
		this.mniBeenden = new JMenuItem("Beenden");
		this.mniInfo = new JMenuItem("Info");
		
		this.lblSpielname = new JLabel("Name des Spiels");
		this.lblSpielart = new JLabel("Spiel-Art");
		this.lblEigenesSpiel = new JLabel("Eigenes Spiel?");
		this.lblVariante = new JLabel("Variante");
		this.lblDatum = new JLabel("Datum");
		this.lblDauer = new JLabel("Dauer in Minuten");
		this.lblSpielernamen = new JLabel("Namen der Spieler");
		this.lblScores = new JLabel ("Erreichte Punkte");
		this.lblGewinner = new JLabel ("Gewinner");
		this.lblScoreGewinnt = new JLabel ("Welcher Score gewinnt?");
		this.cobScoreGewinnt = new JComboBox<> (ScoreGewinnt.values());
		
		
		this.txfSpielname = new JTextField(15);
		this.chbEigenesSpiel = new JCheckBox();
		this.cobSpielart = new JComboBox<>(Spielart.values());
		this.txfVariante = new JTextField(15);
		this.txfDatum = new JTextField (15);
		this.txfDauer = new JTextField(15);
		this.txfSpieler1 = new JTextField(15);
		this.txfSpieler2 = new JTextField(15);
		this.txfSpieler3 = new JTextField(15);
		this.txfSpieler4 = new JTextField(15);
		this.txfScoreSpieler1 = new JTextField(5);
		this.txfScoreSpieler2 = new JTextField(5);
		this.txfScoreSpieler3 = new JTextField(5);
		this.txfScoreSpieler4 = new JTextField(5);
		this.chbGewinner1 = new JCheckBox();
		this.chbGewinner2 = new JCheckBox();
		this.chbGewinner3 = new JCheckBox();
		this.chbGewinner4 = new JCheckBox();
		
		this.btnLoeschen = new JButton("Löschen");
		this.btnBeenden = new JButton("Beenden");
		this.btnSpeichern = new JButton("Speichern");
		
		this.pnlInhalt = new JPanel();
		this.pnlButtons = new JPanel();
		this.pnlSpielerInfos = new JPanel();
		this.pnlSpielInfos = new JPanel();	
	}
	
	//Getter und Setter
	
	public JTextField getTxfSpielname() {
		return txfSpielname;
	}
	
	public void setTxfSpielname(JTextField txfSpielname) {
		if (txfSpielname.getText().length() <= 2) {
			throw new IllegalArgumentException("Laenge des Namens sollte mindestens 3 Zeichen beinhalten");
		}
		//this.txfSpielname = txfSpielname;
	}
	
	public JCheckBox getChbEigenesSpiel() {
		return chbEigenesSpiel;
	}
	
	public JComboBox<Spielart> getCobSpielart() {
		return cobSpielart;
	}
	
	public JTextField getTxfVariante() {
		return txfVariante;
	}
	
	public void setTxfVariante (JTextField txfVariante) {
		this.txfVariante = txfVariante;
	}
	
	public JTextField getTxfDatum() {
		return txfDatum;
	}
	
	public JTextField setTxfDatum(JTextField txfDatum) {	
		if (txfDatum.getText().length() <= 7 || txfDatum.getText().length() > 8) {
			throw new IllegalArgumentException("Das Datum muss aus 8 Zeichen bestehen: TTMMYYYY");
		} 
		return this.txfDatum = txfDatum;
		
		//Noch auf Zahlen pruefen
	}
	
	public JTextField getTxfDauer() {
		return txfDauer;
	}
	
	public void setTxfDauer(JTextField txfDauer) {
		this.txfDauer = txfDauer;
	}
	//Auf Zahlen pruefen
	
	public JTextField getTxfSpieler1() {
		return txfSpieler1;
	}
	
	public void setTxfSpieler1(JTextField txfSpieler1) {
		this.txfSpieler1 = txfSpieler1;
		
		//Auf Zahlen pruefen
		//Setter fuer txfSpieler 2-4
	}
	
	public JTextField getTxfSpieler2() {
		return txfSpieler2;
	}
	
	public JTextField getTxfSpieler3() {
		return txfSpieler3;
	}
	
	public JTextField getTxfSpieler4() {
		return txfSpieler4;
	}
	

	
	public JTextField getTxfScoreSpieler1() {
		return txfScoreSpieler1;
	}
	
	public JTextField getTxfScoreSpieler2() {
		return txfScoreSpieler2;
	}
	
	public JTextField getTxfScoreSpieler3() {
		return txfScoreSpieler3;
	}
	
	public JTextField getTxfScoreSpieler4() {
		return txfScoreSpieler4;
	}
	
	public JCheckBox getChbGewinner1() {
		return chbGewinner1;
	}
	
	public JCheckBox getChbGewinner2() {
		return chbGewinner2;
	}
	
	public JCheckBox getChbGewinner3() {
		return chbGewinner3;
	}
	
	public JCheckBox getChbGewinner4() {
		return chbGewinner4;
	}
	
	public JComboBox<ScoreGewinnt> getCobScoreGewinnt() {
		return cobScoreGewinnt;
	}
	
	public JButton getBtnLoeschen() {
		return btnLoeschen;
	}
	
	public JButton getBtnSpeichern() {
		return btnSpeichern;
	}
	
	public JButton getBtnBeenden() {
		return btnBeenden;
	}
	
	public JMenuItem getMniSpeicherinfo() {
		return mniSpeicherinfo;
	}
	
	public JMenuItem getMniBeenden() {
		return mniBeenden;
	}
	
	public JMenuItem getMniInfo() {
		return mniInfo;
	}

}
