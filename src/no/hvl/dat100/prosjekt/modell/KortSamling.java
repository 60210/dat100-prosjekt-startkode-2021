package no.hvl.dat100.prosjekt.modell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import no.hvl.dat100.prosjekt.TODO;
import no.hvl.dat100.prosjekt.kontroll.dommer.Regler;

/**
 * Struktur for å lagre ei samling kort. Kan lagre hele kortstokken. Det finnes
 * en konstant i klassen Regler som angir antall kort i hver av de 4 fargene. Når
 * programmet er ferdig settes denne til 13, men under utvikling / testing kan
 * det være praktisk å ha denne mindre.
 * 
 */
public class KortSamling {

	private final int MAKS_KORT = 4 * Regler.MAKS_KORT_FARGE;

	private Kort[] samling;
	private int antall;

	/**
	 * Oppretter en tom Kortsamling med plass til MAKS_KORT (hele kortstokken).
	 */
	public KortSamling() {
		System.out.print("Hello from the kortsamling constructor \n");

		// TODO - START
		
		// initialize the samling array object with a size MAKS_KORT
		this.samling = new Kort[MAKS_KORT];
		
		String s = Integer.toString(samling.length);
		System.out.print("\n The kortsamling has been allocated with array size \n");
		System.out.print(s);
		
		//throw new UnsupportedOperationException(TODO.constructor("KortSamling"));
		// TODO - END
	}

	/**
	 * Returnerer en tabell med kortene i samlinga. Tabellen trenger ikke være
	 * full. Kortene ligger sammenhengende fra starten av tabellen. Kan få
	 * tilgang til antallet ved å bruke metoden getAntallKort(). Metoden er
	 * først og fremst ment å brukes i testklasser. Om man trenger
	 * kortene utenfor, anbefales metoden getAlleKort().
	 * 
	 * @return tabell av kort.
	 */
	public Kort[] getSamling() {
		
		return samling;
		
	}
	
	/**
	 * Antall kort i samlingen.
	 * 
	 * @return antall kort i samlinga.
	 */
	public int getAntalKort() {
		
		// TODO - START
		
		// #TODO need to find the position of the last card in the allocated array
		// returning the length of the allocated array, which can be empty, is not enough
		
		int i = 0;
		int count = 0;
		
		for (i = 0; i < this.samling.length; i++ ) {
			
			// if the current index of the samling array is not null, then we have a card there
			// increment the count
			if (samling[i] != null) {
				count++;
			}
			
			// when the current index is null, we've reached the end of the cards in the array
			if 	(samling[i] == null) {
				
					String s = Integer.toString(count);
					System.out.print("\n The number of cards in the samling is \n");
					System.out.print(s);
					
				break;
			}
		}
		return count;
		
		//throw new UnsupportedOperationException(TODO.method());
		
		// TODO - END
	}
	
	/**
	 * Sjekker om samlinga er tom.
	 * 
	 * @return true om samlinga er tom, false ellers.
	 */
	public boolean erTom() {
		
		// TODO - START
		
		int count = getAntalKort();
		
		if (count == 0){
				return true;
		}
		else
				return false;
	//	throw new UnsupportedOperationException(TODO.method());
		
		// TODO - END
	}

	/**
	 * Legg et kort til samlinga.
	 * 
	 * @param kort
	 *            er kortet som skal leggast til.
	 */
	public void leggTil(Kort kort) {
		
		// TODO - START
		
		// count returned is a number while the array is zero-based index
		int cardcount = 0;
		int LastCardPositionInSamling = 0;
		
		// make sure the samling array is valid
		if (samling != null) {
			
			// get 
			cardcount = this.getAntalKort();
			LastCardPositionInSamling = cardcount;
			
			// add the card to the last position in the samling array
			this.samling[LastCardPositionInSamling] = kort;
			
		}
	
		//throw new UnsupportedOperationException(TODO.method());
		// TODO - END
		
	}
	
	/**
	 * Legger alle korta (hele kortstokken) til samlinga. Korta vil være sortert
	 * slik at de normalt må stokkes før bruk.
	 */
	public void leggTilAlle() {
		
		// TODO - START
		// Husk: bruk Regler.MAKS_KORT_FARGE for å få antall kort per farge
	
		// farge:  Hjerter, Ruter, Klover, Spar
		// make a loop adding a card in the array until we are at the limit
		
		// the index of the samling array
		int iIndex = 0;
		
		// we need to keep track of how many of each suite we are creating
		int iRuter = 0;
		int iHjerter = 0;
		int iKlover = 0;
		int iSpar = 0;
	
		// loop adding new cards to samling array until the max allowed is reached
		for (iIndex = 0; iIndex < samling.length && iIndex < MAKS_KORT; iIndex++) {
			
			// we add the cards per suite (farge) until we hit the max # allowed per suite
			// if - if else statements evaluate top-down so we will first create all the Ruter cards, then the Hjerter cards, etc.
			if (iRuter < Regler.MAKS_KORT_FARGE) {
				Kort _kort = new Kort (Kortfarge.Ruter, iRuter+1); // set the value of the card in the suite based on the suite counter
				samling[iIndex] = _kort;
				iRuter++;
				}
			else if (iHjerter < Regler.MAKS_KORT_FARGE) {
				Kort _kort = new Kort (Kortfarge.Hjerter, iHjerter+1); // set the value of the card in the suite based on the suite counter
				samling[iIndex] = _kort;
				iHjerter++;
				}
			else if (iKlover < Regler.MAKS_KORT_FARGE) {
				Kort _kort = new Kort (Kortfarge.Klover, iKlover+1); // set the value of the card in the suite based on the suite counter
				samling[iIndex] = _kort;
				iKlover++;
				}
			else if (iSpar < Regler.MAKS_KORT_FARGE) {
				Kort _kort = new Kort (Kortfarge.Spar, iSpar+1); // set the value of the card in the suite based on the suite counter
				samling[iIndex] = _kort;
				iSpar++;
				}
			
			System.out.print("\n Adding card to samling at array position \n");
			String s = Integer.toString(iIndex);
			System.out.print(s);
			System.out.print("\n new card value is \n");
			s = Integer.toString(samling[iIndex].getVerdi());
			System.out.print(s);
			System.out.print("\n new card suite is \n");
			s = samling[iIndex].getFarge().toString();
			System.out.print(s);
			
		}
	        
	// 	throw new UnsupportedOperationException(TODO.method());
		// TODO - END
	}

	/**
	 * Fjerner alle korta fra samlinga slik at den blir tom.
	 */
	public void fjernAlle() {
		
		// TODO - START
		
		// simplest to just null out the existing list and replace with a new one
		this.samling = null;
		this.samling = new Kort[MAKS_KORT];
		
	// 	throw new UnsupportedOperationException(TODO.method());
		// TODO - END
	}
	
	/**
	 * Ser på siste kortet i samlinga.
	 * 
	 * @return siste kortet i samlinga, men det blir ikke fjernet. Dersom samalinga er tom, returneres
	 *         null.
	 */
	public Kort seSiste() {
		
		// TODO - START
	
		
		if (samling == null)
			return null;
		
		// get the count of cards as an INT which we can use to reference the last card in the array
		int count = this.getAntalKort();
		
		// if the list is empty, we simply return null
		if (count == 0)
			return null;
		
		// translate from count to zero-based array, indicating last card in the array...
		int Index = count -1;
		
			System.out.print("\n The last card in the samling is \n");
			String s = Integer.toString(samling[Index].getVerdi());
			System.out.print(s);
			s = samling[Index].getFarge().toString();
			System.out.print(s);
		
		// return a reference to the last card in the array
		return samling[Index];
	
	//	throw new UnsupportedOperationException(TODO.method());

		// TODO - END
		
	}

	/**
	 * Tek ut siste kort fra samlinga.
	 * 
	 * @return siste kortet i samlinga. Dersom samalinga er tom, returneres
	 *         null.
	 */
	public Kort taSiste() {
		
		// TODO - START
		
		// important to check if the list is valid
		if (samling == null)
			return null;
		
		// get the count of cards
		int NumberOfCards = this.getAntalKort();
		
		// return null if empty
		if (NumberOfCards < 1) {
			System.out.print("\n No cards in the samling \n");
			return null;
		}
		
		// set the array index to be zero based count - it will always be one less than the count of cards
		int Index = NumberOfCards-1;
		
		if (samling[Index] != null) {
			System.out.print("\n The last card in the samling is \n");
			String s = Integer.toString(samling[Index].getVerdi());
			System.out.print(s);
			s = samling[Index].getFarge().toString();
			System.out.print(s);
			
			// retrieve the last card's suite and value in a card object we can return
			Kort _kort = new Kort (samling[Index].getFarge(), samling[Index].getVerdi() );
			
			// now remove the last card
			samling[Index] = null;

			return _kort;
		}
			
		return null;
		
		
	//	throw new UnsupportedOperationException(TODO.method());
		
		// TODO - END
	}
	
	/**
	 * Undersøker om et kort finst i samlinga.
	 * 
	 * @param kort.
	 * 
	 * @return true om kortet finst i samlinga, false ellers.
	 */
	public boolean har(Kort kort) {
		
		// TODO - START
		
		// iterate over array samling checking for match for Kort passed in
		// if match is found, immediately return true
		// if none is found, exit for loop and return false
		
		if (kort == null)
				return false;
		
		int count = getAntalKort();
		
		if (count == 0){
				return false;
		}
		
		
		// this special for loop is useful for iterating over an array to find a specific item
		// the helper utility will simply assign each object in the array to element in order
		// 
		for (Kort element : samling) {
			if (element == null) { 
				System.out.print("\n Houston, we have a problem with element search \n");
				break;
			}
				
			// we need to check that the current looping element has BOTH the same farge and verdi
			// we can use the Kort methods sammeFarge and sammeVerdi to compare
			if (element.sammeFarge(kort) && (element.sammeVerdi(kort)))
            {
		            	System.out.print("\n Found the card requested \n");
		    			String s = Integer.toString(kort.getVerdi());
		    			System.out.print(s);
		    			s = kort.getFarge().toString();
		    			System.out.print(s);
                return true;
            }
		}
            
        return false;
		
		// throw new UnsupportedOperationException(TODO.method());
		// return false;
		// TODO - END
		
	}

	/**
	 * Fjernar et kort frå samlinga. Dersom kortet ikke finnest i samlinga,
	 * skjer ingenting med samilingen
	 * 
	 * @param kort
	 *            kortet som skal fjernast. Dersom kortet ikke finnes, skjer
	 *            ingenting.
	 * @return true om kortet blev fjernet fra samlinga, false ellers.
	 */
			 
	public boolean fjern(Kort kort) {
		
		// TODO - START
		
		// if the list is invalid or the card to be removed is invalid, just return null
		if ((samling == null) || (kort == null))
			return false;
		
		// to remove a card from the samling array, we have to find where it is (its index) in the array
		// we create a brand new placeholder samling array
		// we rebuild the samling with the card values as we loop through the array, one card at a time
		// but if we get a match for the card to be removed, we skip that one
		// the new list should be 1 less than the original
		// finally, we simply switch the new list to have the old "samling" variable name
		int iIndex = 0;
		int fjerncardIndex = 0;
		int purgedArrayIndex = 0;
		
		// quick check to see if the card is in the current array
		if (har(kort)) 
		{
			// if so, get the current # of cards
			int count = getAntalKort();
			
			// create a new placeholder list which will hold all the cards minus the card to be removed
			Kort[] purgedCardArray = new Kort[MAKS_KORT];
			
			// iterate through the list 
			for (Kort element : samling) {
				
				// if we have a match with the card 
				if (element.sammeFarge(kort) && (element.sammeVerdi(kort)))
	            {
					
					// a for loop to recreate the cards in the new list without the card to be removed
					for (iIndex = 0; iIndex < count; iIndex++) {
						
						if (iIndex != fjerncardIndex) // if the current card in the old list isn't the one we want to remove
						{
							// create a new card with the same values as the corresponding card in the orig list						
							Kort _kort = new Kort (samling[iIndex].getFarge(), samling[iIndex].getVerdi() );
							
							// assign it to the new list with the corrected index position 
							purgedCardArray[purgedArrayIndex] = _kort;
							
							// increment the new array index
							purgedArrayIndex++;
						}
								
					}
					
					// finally, replace the master list with the new list purged of the card
					samling = purgedCardArray;
				    return true;
	            }
				// we need to get the index for the card that is to be removed, so as we loop through
				// don't forget to increment the index while we're looking for the card to be removed
				fjerncardIndex++;
			}
	            
		}
            
        return false;
		

		
	//	throw new UnsupportedOperationException(TODO.method());

		// TODO - END
	}

	/**
	 * Gir kortene som en tabell av samme lengde som antall kort i samlingen
	 * 
	 * @return tabell av kort som er i samlingen, der kort skal ha samme rekkefølge
	 *         som i kortsamlinga.
	 */
	public Kort[] getAllekort() {
		
		// TODO - START
		
		// this returns an array of just the cards, in the proper order
	
		int count = getAntalKort();
		
		// create a new array with a size of the count of cards
		Kort[] allekort = new Kort[count];
		
		// if there are no cards, return an empty list
		if (count == 0)
			return allekort;
		
		// loop through the existing samling list, adding cards to the new list
		for (int iIndex = 0; iIndex < allekort.length; iIndex++) {
			
				Kort _kort = new Kort (samling[iIndex].getFarge(), samling[iIndex].getVerdi() );
				allekort[iIndex] = _kort;
		
			}
		// when done, return the new list
		return allekort; 
		
		// throw new UnsupportedOperationException(TODO.method());

		// TODO - END
	
	}
	
}
