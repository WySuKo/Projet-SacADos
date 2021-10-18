import java.util.Scanner;

import static java.lang.System.out;

/**
 * Classe pour l'application du programme
 * @author Fabien Ribeiro, Axel Roche
 * @version 1.0
 * @since 2021-10
 */
public class Main {
    /**
     * Méthode qui permet de lancer l'application
     * @param args les arguments qui seront taper en entrée
     */
    public static void main(String[] args) {

        GestionMain main = new GestionMain();
        /** Prend les valeurs nécessaires :
         * chemin poidsMax méthode
         */
        Scanner debut = new Scanner(System.in);
        out.print("Veuillez saisir les arguments du programme :\n$>resoudre-sac-a-dos ");
        String str = debut.nextLine();
        String[] arguments = str.split(" ");
        //on copie les arguments
        args = arguments.clone();
        main.gestionArgument(args);
    }
}