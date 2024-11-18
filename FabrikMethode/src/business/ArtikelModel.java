package business;

import java.io.*;
import writers.*;
import readers.*;

public class ArtikelModel {
	
	private Artikel[] artikel = new Artikel[100];
	private int anzahlArtikel;
	
	public int getAnzahlArtikel() {
		return anzahlArtikel;
	}

	public void setAnzahlArtikel(int anzahlArtikel) {
		this.anzahlArtikel = anzahlArtikel;
	}

	public void leseArtikelAusCsvDatei()
        throws IOException{
		
		ReaderCreator creator = new ConcreteCsvReaderCreator();
		
		ReaderProduct reader = creator.factoryMethod();
		
		//setAnzahlArtikel(reader.leseAnzahlArtikel());
		
		setAnzahlArtikel(reader.leseAnzahlArtikel());
		this.artikel = reader.leseArtikel();
		
		/*
		 * Alte implementierung der Methode ohne Fabrik Pattern 
		 *
		BufferedReader ein = new BufferedReader(new FileReader("Artikel.csv"));
		this.setAnzahlArtikel(Integer.parseInt(ein.readLine()));
		String[] zeile = null;
		for(int i = 0; i < this.getAnzahlArtikel(); i++) {
			zeile = ein.readLine().split(";");
			this.artikel[i] = new Artikel(
				Integer.parseInt(zeile[0]), zeile[1],
				Double.parseDouble(zeile[2]));
		}    
	    ein.close();
	    */
	}
	
	public void schreibeArtikelInTxtDatei()
	    throws IOException{
		
		// Instanz von ConcreteTxtWriterCreator erstellen um die Factory-Methode
		// innerhalb der Klasse ConcreteTxtWriterCreator aufzurufen
		WriterCreator creator = new ConcreteTxtWriterCreator();
		
		// Factory-Method verwenden um ein WriterProduct zu erstellen
		// creator.factoryMethod returnt ein Objekt von ConcreteTxtWriterProduct()
		WriterProduct writer = creator.factoryMethod();
		
		// WriterProduct Methode aufrufen, um Artikel in Textdatei zu schreiben
		writer.schreibeArtikel(this.getAnzahlArtikel(), this.artikel);
		
		/*
		 * Alte Implementierung der Methode ohne Fabrik Pattern
		 * 
		BufferedWriter aus = new BufferedWriter(new FileWriter("Artikel.txt"));
		aus.write(this.getAnzahlArtikel() + "");
		aus.newLine();
		for(int i = 0; i < this.getAnzahlArtikel(); i++) {
			aus.write(this.artikel[i].getArtikelnummer() + "");
			aus.newLine();
			aus.write(this.artikel[i].getArtikelname());
			aus.newLine();
			aus.write(this.artikel[i].getBasispreis() + "");
			aus.newLine();
		}    
		aus.close();
		*/
	}
	
	public void schreibeArtikelInKonsole()
	throws IOException{
		
		WriterCreator creator = new ConcreteKonsoleWriterCreator();
		
		WriterProduct writer = creator.factoryMethod();
		
		writer.schreibeArtikel(this.getAnzahlArtikel(), this.artikel);
	}

}
