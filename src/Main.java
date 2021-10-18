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
        out.print("Veuillez saisir les arguments du programme :\n$>resoudre-sac-a-dos ");
        GestionMain main = new GestionMain();
        Scanner debut = new Scanner(System.in);
        String str = debut.nextLine();
        String[] ok = str.split(" ");
        args = ok.clone();
        main.gestionArgument(args);
    }
}