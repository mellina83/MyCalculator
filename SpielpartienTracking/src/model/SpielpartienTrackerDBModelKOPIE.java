package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Scanner;

import javax.sound.sampled.Line;

public class SpielpartienTrackerDBModelKOPIE implements Serializable {
	
	
	public SpielpartienTrackerDBModelKOPIE() {
		
		File folder1 = new File("files/ordner");
		File file1 = new File("files/ordner/text.txt");
		
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
		
		//Scanner soll Datei lesen
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(file1);
			
			while(scanner.hasNext()) {
				System.out.print(scanner.next() + " ");
			}
			
			
			
		} catch (FileNotFoundException e) {
			System.out.println("Datei konnte nicht gefunden werden");
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		
		
		//Schreiben
		try {
			OutputStream ioStream = new FileOutputStream(file1);
			String textinhalt = "Nochmal Hallo";
			
			try {
				ioStream.write(textinhalt.getBytes());
				ioStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Datei konnte nicht gefunden werden.");
			e.printStackTrace();
		}
		


	} // Ende Konstruktor
	
	public void inDateiSpeichern(String string) {
		
		
	}
	
	public void dateiExportieren( ) {
		
	}
	
		


}
