package readers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import business.Artikel;

public class ConcreteCsvReaderProduct extends ReaderProduct {
	
	private BufferedReader ein;
	private int anzahlArtikel;
	
	public ConcreteCsvReaderProduct() throws IOException {
		this.ein = new BufferedReader(new FileReader("Artikel.csv"));
		this.anzahlArtikel = Integer.parseInt(ein.readLine());
	}

	@Override
	public int leseAnzahlArtikel() throws IOException {
		return this.anzahlArtikel;
	}

	@Override
	public Artikel[] leseArtikel() throws IOException {
		Artikel[] artikel = new Artikel[this.anzahlArtikel];
		String[] zeile = null;
		for(int i = 0; i < this.leseAnzahlArtikel(); i++) {
			zeile = ein.readLine().split(";");
			artikel[i] = new Artikel(
				Integer.parseInt(zeile[0]), zeile[1],
				Double.parseDouble(zeile[2]));
		}    
	    ein.close();
		return artikel;
	}

}
