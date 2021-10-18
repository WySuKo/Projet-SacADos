import java.util.Scanner;

import static java.lang.System.out;

/**
 * Classe pour l'application du programme
 * @author Fabien Ribeiro, Axel Roche
 * @version 1.0
 * @since 2021-10
 */
public class Main {
    public static void main(String[] args) {
        GestionMain main = new GestionMain();
        Scanner debut = new Scanner(System.in);
        out.println("Veuillez saisir les arguments du programme");
        String str = debut.nextLine();
        String[] argus = str.split(" ");
        args[0] = argus[0];
        args[1] = argus[1];
        args[2] = argus[2];
        main.gestionArgument(args);
    }
}