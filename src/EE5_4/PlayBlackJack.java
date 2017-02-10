package EE5_4;

import EE5_4.BlackjackHand;
import EE5_4.Card;
import EE5_4.Deck;
import EE5_4.Hand;
import EE5_4.TextIO;
import java.util.Random;

public class PlayBlackJack {

	
	/**Simule une partie de blackjack jusqu'a ce que le joueur veuille s'arreter
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int nbcarte;
		int fin = 0;
		
		while(fin != 1){
			Deck dck = new Deck();
			BlackjackHand bjh = new BlackjackHand();
			Random rand = new Random();
		nbcarte = rand.nextInt(4)+2;
		
		for(int i=0; i < nbcarte; i++ ){
			bjh.addCard(dck.dealCard());
			System.out.println(dck.dealCard());
			}
		System.out.println("Votre score : " + bjh.getBlackjackValue());
		System.out.println("Pour arreter entrez 1");
		fin = TextIO.getInt();
		}
	}

}
