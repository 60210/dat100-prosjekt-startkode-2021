package no.hvl.dat100.prosjekt.modell;

import java.util.Random;

import no.hvl.dat100.prosjekt.TODO;

public class KortUtils {

	/**
	 * Sorterer en samling. Rekkefølgen er bestemt av compareTo() i Kort-klassen.
	 * 
	 * @see Kort
	 * 
	 * @param samling
	 * 			samling av kort som skal sorteres. 
	 */
	
	public static void sorter(KortSamling samling) {
		
		// TODO - START

		if (samling.erTom())
			return;
		
		int iCards = 0;
		Kort tmpkort;
		
		iCards = samling.getAntalKort();
		
		Kort[] Unsorted = samling.getSamling();
	
		// loop through the array, comparing the values of adjacent cards and moving the cards if needed
		for (int i = 0; i < iCards; i++) {
			
			for (int j = i +1; j < iCards; j++) {
				
				// The value 0 if the card is equal, a value less than 0 if this comes
			    //  first and a value greater than 0 if this comes last.
				int test = Unsorted[j].compareTo(Unsorted[i]);
				
				if (test < 0) {
					
					// assign card i to tempcard object
					tmpkort = Unsorted[i];
					// assign value of j to i card object
					Unsorted[i] = Unsorted[j];
					// assign value of tempcard (orig value of i) to j object / position
					Unsorted[j] = tmpkort;
					
				}		
				
			}
			
		}
		
		
	//	throw new UnsupportedOperationException(TODO.method());
		// TODO - END
	}
	
	/**
	 * Stokkar en kortsamling. 
	 * 
	 * @param samling
	 * 			samling av kort som skal stokkes. 
	 */
	public static void stokk(KortSamling samling) {
		
		// TODO - START
		
		if (samling.erTom())
			return;
		
		int iCards = 0;
		Kort tmpkort;
		
		iCards = samling.getAntalKort();
		
		Kort[] ar = samling.getSamling();
		
		Random rnd = new Random();
		
		for (int i = iCards - 1; i > 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	      // Simple swap
	      tmpkort = ar[index];
	      ar[index] = ar[i];
	      ar[i] = tmpkort;
	    }
	  
	
		
	// 	throw new UnsupportedOperationException(TODO.method());
		// TODO - END
	}
	
}
