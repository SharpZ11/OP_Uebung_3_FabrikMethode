package writers;

import java.io.IOException;

import business.Artikel;

public class ConcreteKonsoleWriterProduct extends WriterProduct {

	@Override
	public void schreibeArtikel(int anzahlArtikel, Artikel[] artikel) throws IOException {
		
		System.out.println("Anzahl vorhandender Artikel: "+anzahlArtikel + "\n");
		for(int i = 0; i < anzahlArtikel; i++) {
			System.out.println("Artikelnummer:\t"+artikel[i].getArtikelnummer());
			System.out.println("Artikelname:\t"+artikel[i].getArtikelname());
			System.out.println("Basispreis:\t"+artikel[i].getBasispreis());
			System.out.println();
		}    		
	}

}
