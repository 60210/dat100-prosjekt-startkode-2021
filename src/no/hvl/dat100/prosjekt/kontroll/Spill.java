package no.hvl.dat100.prosjekt.kontroll;

import java.util.ArrayList;

import no.hvl.dat100.prosjekt.modell.KortSamling;
import no.hvl.dat100.prosjekt.TODO;
import no.hvl.dat100.prosjekt.kontroll.dommer.Regler;
import no.hvl.dat100.prosjekt.kontroll.spill.Handling;
import no.hvl.dat100.prosjekt.kontroll.spill.HandlingsType;
import no.hvl.dat100.prosjekt.kontroll.spill.Spillere;
//import no.hvl.dat100.prosjekt.kontroll.tester.TSpiller;
import no.hvl.dat100.prosjekt.modell.Kort;
import no.hvl.dat100.prosjekt.modell.KortUtils;


/**
 * Klassen har objektvariaber som er referanser til de spillerne, nord og syd
 * (type ISpiller). Den har ogsÂ en bunke man deler/trekker fra og en bunke man
 * spiller til.
 * 
 */
public class Spill {

	private ISpiller nord;
	private ISpiller syd;
	
	private Bord bord;
	
	// antall kort som skal deles ut til hver spiller ved start
	public final static int ANTALL_KORT_START = Regler.ANTALL_KORT_START;
	
	public Spill() {
		
		// TODO - START
		
		bord = new Bord();
		this.nord = new DeriveSpiller(Spillere.NORD);
		this.syd  = new DeriveSpiller(Spillere.SYD);
		
		
 	//	throw new UnsupportedOperationException(TODO.constructor("Spill"));
		// TODO - END
		
	}
	
	/**
	 * Gir referanse/peker til bord.
	 * 
	 * @return referanse/peker bord objekt.
	 */
	public Bord getBord() {
		
		// TODO - START
		
		return bord;
	// 	throw new UnsupportedOperationException(TODO.method());

		// TODO - END
		
	}
	
	/**
	 * Gir referanse/peker til syd spilleren.
	 * 
	 * @return referanse/peker til syd spiller.
	 */
	public ISpiller getSyd() {
		
		// TODO - START
		
		return this.syd;
		
		// throw new UnsupportedOperationException(TODO.method());

		// TODO - END
		
	}

	/**
	 * Gir referanse/peker til nord.
	 * 
	 * @return referanse/peker til nord.
	 */
	public ISpiller getNord() {
		
		// TODO - START

		return this.nord;
		
	// 	throw new UnsupportedOperationException(TODO.method());

		// TODO - END
	}

	/**
	 * Metoden oppretter to spillere, nord og syd. Det opprettes to bunker, fra
	 * og til. Alle kortene legges til fra. Bunken fra stokkes. Deretter deles
	 * det ut kort fra fra-bunken til nord og syd i henhold til regler. Til
	 * slutt tas øverste kortet fra fra-bunken og legges til til-bunken.
	 * 
	 * Nord har type RandomSpiller (som er forhåndefinert). Syd vil være spiller
	 * av en klasse laget av gruppen (implementeres i oppgave 3).
	 */
	public void start() {
		
		// TODO - START
		
		// initialize the players using the player class, derived from the abstract player class
		this.nord = new DeriveSpiller(Spillere.NORD);
		this.syd  = new DeriveSpiller(Spillere.SYD);
		
		// get references to the table's Fra and Til card piles
	    KortSamling bunkeFra = bord.getBunkeFra();
	    KortSamling bunkeTil = bord.getBunkeTil();
	    
	    // allocate all cards to the Fra card pile
	    bunkeFra.leggTilAlle();
	    
	    // shuffle the Fra pile
	    KortUtils.stokk(bunkeFra);
		  
	 // loop through adding cards to the players' hands
		for (int i =0; i< ANTALL_KORT_START; i++) { 
			
			nord.leggTilKort(bord.taOversteFraBunke());
			syd.leggTilKort(bord.taOversteFraBunke());
	
		}
		
		// finally, add the card from the top of the Fra pile to the Til pile
		bunkeTil.leggTil(bord.taOversteFraBunke());
		
		
	// 	throw new UnsupportedOperationException(TODO.method());
		// TODO - END
	}

	/**
	 * Deler ut kort til nord og syd.
	 * 
	 */
	private void delutKort() {

		// TODO - START
		
		// loop through adding cards to the players' hands
		for (int i =0; i< ANTALL_KORT_START; i++) { 
			
			nord.leggTilKort(bord.taOversteFraBunke());
			syd.leggTilKort(bord.taOversteFraBunke());
	
		}
		
	//	throw new UnsupportedOperationException(TODO.method());
		// TODO - END
	}

	/**
	 * Trekker et kort fra fra-bunken til spilleren gitt som parameter. Om
	 * fra-bunken er tom, må man "snu" til-bunken. Se info om metoden
	 * snuTilBunken().
	 * 
	 * @param spiller
	 *            spilleren som trekker.
	 * 
	 * @return kortet som trekkes.
	 */
	public Kort trekkFraBunke(ISpiller spiller) {

		// TODO - START
		
		
		// if the From-card pile is empty, refresh the pile
		if (bord.bunkefraTom())
			bord.snuTilBunken();
		
	
		// return the top card from the Fra Pile
		Kort kort = bord.taOversteFraBunke();
		spiller.leggTilKort(kort);
		spiller.setAntallTrekk(spiller.getAntallTrekk()+1);
		
		
		return kort;
		
	
		//throw new UnsupportedOperationException(TODO.method());

		// TODO - END
	}

	/**
	 * Gir neste handling for en spiller (spilt et kort, trekker et kort, forbi)
	 * 
	 * @param spiller
	 *            spiller som skal handle.
	 * 
	 * @return handlingen som skal utføres av kontroll delen.
	 */
	public Handling nesteHandling(ISpiller spiller) {
		
		// TODO - START
		// Hint: se på hvilke metoder som er tilgjengelig på en spiller
		
		// retrieve the player's hand
		KortSamling _hand = spiller.getHand();
	
		// check what the player can do by passing in their last card to the method which will check
		return spiller.nesteHandling(_hand.seSiste());
		
		// throw new UnsupportedOperationException(TODO.method());

		// TODO - END
		
	}

	/**
	 * Metoden spiller et kort. Den sjekker at spiller har kortet. Dersom det er
	 * tilfelle, fjernes kortet fra spilleren og legges til til-bunken. Metoden
	 * nulltiller også antall ganger spilleren har trukket kort.
	 * 
	 * @param spiller
	 *            den som spiller.
	 * @param kort
	 *            kort som spilles.
	 * 
	 * @return true dersom spilleren har kortet, false ellers.
	 */
	public boolean leggnedKort(ISpiller spiller, Kort kort) {
		
		// TODO - START
		
		// get the player's hand
		KortSamling _hand = spiller.getHand();
		
		// if the player has the card...
		if(_hand.har(kort)) {
			
			// remove it from her hand
			_hand.fjern(kort);
			
			// lay it down on the Til card pile
			bord.leggNedBunkeTil(kort);
			
			// null out the # of times the player has pulled a card
			spiller.setAntallTrekk(0);
			
			return true;
			
		}
		else 
			return false;
			
		
		// throw new UnsupportedOperationException(TODO.method());

		// TODO - END
	}

	/**
	 * Metode for å si forbi. Må nullstille antall ganger spilleren har trukket
	 * kort.
	 * 
	 * @param spiller
	 *            spilleren som er i tur.
	 */
	public void forbiSpiller(ISpiller spiller) {
		
		// TODO - START
		
		// ToDO: What to do here?
		
		spiller.setAntallTrekk(0);
		
	// 	throw new UnsupportedOperationException(TODO.method());
	
		// TODO - END
	}

	/**
	 * Metode for å utføre en handling (trekke, spille, forbi). Dersom handling
	 * er kort, blir kortet også spilt.
	 * 
	 * @param spiller
	 *            spiller som utfører handlingen.
	 * @param handling
	 *            handling som utføres.
	 * 
	 * @return kort som trekkes, kort som spilles eller null ved forbi.
	 */
	public Kort utforHandling(ISpiller spiller, Handling handling) {

		// TODO - START
		Kort kort = null;
		
		if (handling.getType() == HandlingsType.LEGGNED) {
			
			Kort[] allekort = spiller.getHand().getAllekort();
			kort = allekort[0];
			
			leggnedKort(spiller, kort);
		}
		else if (handling.getType() == HandlingsType.TREKK) {
			kort = trekkFraBunke(spiller);
			return kort;
		}
		else {
			forbiSpiller(spiller);
			return null;
		}

		// Hint: del opp i de tre mulige handlinger og vurder 
		// om noen andre private metoder i klassen kan brukes
		// til å implementere denne metoden
		
		return kort;
				
	// 	throw new UnsupportedOperationException(TODO.method());

		// TODO - END
	}

}