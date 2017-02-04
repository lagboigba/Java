import java.util.Random;
import java.util.Scanner;


public class Exo47 {
static int premiernb[] = new int[10];
static int deuxiemenb[] = new int[10];
static int reponse[] = new int[10];
static Random rand = new Random();
static Scanner sc = new Scanner(System.in);

public static void main(String[] args) {
	System.out.println("D�but du quiz");
	CreationQuiz();
	PoseQuiz();
	NotationQuiz();
}


/**Cr�e le quiee avec deux tableau avec des entiers allant de 0 � 30
 *  
 * 
 * 
 */
public static void CreationQuiz() {
	for (int i = 0; i < 10; i++){
		premiernb[i] = rand.nextInt(31);
		deuxiemenb[i] = rand.nextInt(31);
	}
		
	}

/**Sauvegarde les r�ponses du joueur dans un tableau
 *  
 * 
 * 
 */
public static void PoseQuiz() {
	for (int i = 0; i < 10; i++){
		System.out.println("Question " + i + ": Quel est le r�sultat de " +
							premiernb[i] + " + " + deuxiemenb[i]);
		reponse[i] = sc.nextInt();
		
	}
}

/**V�rifie le nombre de bonnes r�ponses donn�es par le joueur et calcule le nombre de point total
 *  
 * 
 * 
 */

public static void NotationQuiz() {
	int Score = 0;
	for (int i = 0; i < 10; i++){
		System.out.println("Question " + i + ": Quel est le r�sultat de " +
				premiernb[i] + " + " + deuxiemenb[i] + " Votre r�ponse : " +
				reponse[i]);
		if (premiernb[i] + deuxiemenb[i] == reponse[i]){
			System.out.println("Bonne r�ponse");
			Score += 10;
		}
		else{
			int breponse = premiernb[i] + deuxiemenb[i];
			System.out.println("Mauvaise r�ponse, la bonne r�ponse �tait " +
		breponse);
		}
		
	}
System.out.println("Score final :" + Score);}


}
