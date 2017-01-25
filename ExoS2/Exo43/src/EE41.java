import java.util.Random;
import java.util.Scanner;
public class EE41 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Entrer le nombre voulu");
	int nbvoulu = sc.nextInt();
	int resultat = calculNbLancer(nbvoulu);
	
	
}

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
			resultatlancer = rand.nextInt(11)+2;
			nblancer ++;
		}
	System.out.println("Il a fallu " + nblancer + " lancers");

	return nblancer;
}
}

