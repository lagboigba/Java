import java.util.Random;
import java.util.Scanner;
public class EE41 {
public static void main(String[] args) {
	int nbvoulu = 2;
	int resultat = calculNbLancer(nbvoulu);
	
	
}
/**Calcul le nombre de lancers nécessaire pour atteindre nbvoulu à l'aide de 2 dés
 * 
 * @param nbvoulu Nombre voulu sur les dés
 * @return nblancer, le nombre de lancers nécessaire pour atteindre nbvoulu
 */
public static int calculNbLancer(int nbvoulu) {
	if (!(nbvoulu <= 12 && nbvoulu >=2)){
		IllegalArgumentException e = new IllegalArgumentException();
		throw e;
	}
	
	int nblancer = 0;
	int resultatlancer = 0 ;
	Random rand = new Random();
	


		while(resultatlancer != nbvoulu)
		{
			resultatlancer = rand.nextInt(6)+1;
			resultatlancer += rand.nextInt(6)+1;
			nblancer ++;
			assert resultatlancer <= 12;
		}
		
	System.out.println("Il a fallu " + nblancer + " lancers pour avoir des yeux de serpents.");

	return nblancer;
}
}

