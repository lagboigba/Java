import java.util.Random;
import java.util.Scanner;


public class Exo47 {
static int premiernb[] = new int[10];
static int deuxiemenb[] = new int[10];
static int reponse[] = new int[10];
static Random rand = new Random();
static Scanner sc = new Scanner(System.in);

public static void main(String[] args) {
	System.out.println("Début du quiz");
	CreationQuiz();
	PoseQuiz();
	NotationQuiz();
}


/**Crée le quiee avec deux tableau avec des entiers allant de 0 à 30
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

/**Sauvegarde les réponses du joueur dans un tableau
 *  
 * 
 * 
 */
public static void PoseQuiz() {
	for (int i = 0; i < 10; i++){
		System.out.println("Question " + i + ": Quel est le résultat de " +
							premiernb[i] + " + " + deuxiemenb[i]);
		reponse[i] = sc.nextInt();
		
	}
}

/**Vérifie le nombre de bonnes réponses données par le joueur et calcule le nombre de point total
 *  
 * 
 * 
 */

public static void NotationQuiz() {
	int Score = 0;
	for (int i = 0; i < 10; i++){
		System.out.println("Question " + i + ": Quel est le résultat de " +
				premiernb[i] + " + " + deuxiemenb[i] + " Votre réponse : " +
				reponse[i]);
		if (premiernb[i] + deuxiemenb[i] == reponse[i]){
			System.out.println("Bonne réponse");
			Score += 10;
		}
		else{
			int breponse = premiernb[i] + deuxiemenb[i];
			System.out.println("Mauvaise réponse, la bonne réponse était " +
		breponse);
		}
		
	}
System.out.println("Score final :" + Score);}


}
