package no.hvl.dat100.prosjekt.kontroll;

import no.hvl.dat100.prosjekt.modell.KortSamling;
import no.hvl.dat100.prosjekt.modell.KortUtils;
import no.hvl.dat100.prosjekt.TODO;
import no.hvl.dat100.prosjekt.kontroll.spill.Handling;
import no.hvl.dat100.prosjekt.kontroll.spill.Spillere;
import no.hvl.dat100.prosjekt.modell.Kort;

/**
 * Abstrakt klasse som implementerer alle metodene i kontrakten (interfacet) ISpiller,
 * bortsett fra nesteHandling(). Dette er grunnen til at klassen er abstrakt.
 * For å lage "virkelige" spillere, må vi arve fra denne klassen og implementere
 * nesteHandling (fra ISpiller).
 * 
 * Klassen har objektvariablene hand (Hand), antalltrekk (heltall) og spiller
 * (Spillere). Den har to konstruktører. Se beskrivelse av disse.
 * 
 */
public abstract class Spiller implements ISpiller {

	// hand for spilleren (samling)
	private KortSamling hand; 
	
	// antall trekk spilleren har gjort fra fra-bunken
	private int antalltrekk; 
	
	// hvem spilleren er (Nord,Syd,Ingen) - se oppramsklassen Spillere
	private Spillere spiller;
	
	public Kort[] samlingen;

	/**
	 * Standard konstruktør som oppretter en Spiller med en hånd uten kort,
	 * antalltrekk som 0 og setter spiller til Spillere.INGEN.
	 */
	public Spiller() {
		
		// TODO - START
		
		this.hand = new KortSamling();
		antalltrekk = 0;
		spiller = Spillere.INGEN;


	// throw new UnsupportedOperationException(TODO.constructor("Spiller"));
		// TODO - END
	}

	/**
	 * Konstruktør der vi kan sette hvilken spiller det er (NORD, SYD eller
	 * INGEN).
	 * 
	 * @param spiller
	 *            hvilken spiller det er.
	 */
	public Spiller(Spillere spiller) {
		
		// TODO - START
		this.hand = new KortSamling();
		antalltrekk = 0;		
		this.spiller = spiller;

	// 	throw new UnsupportedOperationException(TODO.constructor("Spiller"));
		// TODO - END
	}

	public int getAntallKort() {
		
		// TODO - START
	
		return hand.getAntalKort();
		
	//	throw new UnsupportedOperationException(TODO.method());

		// TODO - END
	}

	public KortSamling getHand() {
		
		// TODO - START
		
		return hand;
		
	//	throw new UnsupportedOperationException(TODO.method());

		// TODO - END
	}

	public int getAntallTrekk() {
		
		// TODO - START
		
		return antalltrekk;
		
	//	throw new UnsupportedOperationException(TODO.method());

		// TODO - END
	}

	public Spillere hvem() {
		
		// TODO - START
		
		return spiller;
		
	// 	throw new UnsupportedOperationException(TODO.method());

		// TODO - END
		
	}

	public void setAntallTrekk(int t) {
		
		// TODO - START
		
		antalltrekk = t;
		
	// 	throw new UnsupportedOperationException(TODO.method());
		// TODO - END
	}

	public boolean erFerdig() {
		
		// TODO - START
		
		if (hand.getAntalKort() > 0)
			return false;
		else
			return true;
		
	// 	throw new UnsupportedOperationException(TODO.method());
		// TODO - END
		
	}

	public void leggTilKort(Kort kort) {
		
		// TODO - START
		
		hand.leggTil(kort);
		
		return;
		
	//	throw new UnsupportedOperationException(TODO.method());
		// TODO - END
		
	}

	public void fjernKort(Kort kort) {
		
		// TODO - START
		
		hand.fjern(kort);
		return;
		
	//	throw new UnsupportedOperationException(TODO.method());
		// TODO - END
		
	}

	public void fjernAlleKort() {
		
		// TODO - START
		
		hand.fjernAlle();
		return;
		
	// 	throw new UnsupportedOperationException(TODO.method());
		// TODO - END
	}

	public void trekker(Kort kort) {
		
		// TODO - START
		
		hand.leggTil(kort);
		antalltrekk++;
		return;
		
	// 	throw new UnsupportedOperationException(TODO.method());
		// TODO - END
		
	}
}



