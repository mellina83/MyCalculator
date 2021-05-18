package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class SpielpartienTrackerDBModel implements SpielpartienTrackerModelInterface, Serializable {
	
	private File folder1;
	private File file1;
	
	public SpielpartienTrackerDBModel() {
		
		//Erstellen von Ordner und Datei
		
		folder1 = new File("C://SpielpartienTrackerDB");
		file1 = new File("C://SpielpartienTrackerDB//text.txt");
		
		if (folder1.exists()) {
			System.out.println("Ordner existiert schon");
		} else {
			folder1.mkdirs();
			System.out.println("Ordner wurde erstellt");
		}
		
		
		if (file1.exists()) {
			System.out.println("Datei existiert schon");
		} else {
			try {
				file1.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Txt-Datei wurde erstellt");
		}
		

	} // Ende Konstruktor
	
	//Fuer Test/Pruefung
	public void dateiLesen() {
		
		//Scanner soll Datei lesen
		Scanner scanner = null;
				
		try {
			scanner = new Scanner(file1);
					
			while(scanner.hasNext()) {
				System.out.print(scanner.nextLine() + "\n");
			}
					
					
					
		} catch (FileNotFoundException e) {
			System.out.println("Datei konnte nicht gefunden werden");
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		
	} // Ende Methode dateiLesen
	
	
	@Override
	public void inDateiSchreiben(String string) {
		//Schreiben per FileWriter
		FileWriter writer; 	
		
		try {
			writer = new FileWriter(file1, true);
			writer.write(string);
			writer.write(System.getProperty("line.separator"));
					
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

	
	//Getter und Setter
	
	public File getFile() {
		return file1;
	}


}
