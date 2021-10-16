package Sac;

import java.awt.geom.Arc2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static java.lang.System.*;

/**
 * Classe pour l'application du programme
 * @author Fabien Ribeiro, Axel Roche
 * @version 1.0
 * @since 2021-10
 */
public class Main {
    public static void main(String[] args) {
        Date D1 = new Date();
        Float poidsMax = Float.parseFloat(args[1]);

        SacADos Sac = new SacADos(args[0], poidsMax);
        Scanner scan = null;
        try {
            scan = new Scanner(new File(args[0]));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] caracs = line.split(";");
            Objet.Objets.add(new Objet(caracs[0], Float.parseFloat(caracs[1]), Float.parseFloat(caracs[2])));
        }
        switch(args[2]) {
            case "glouton":
                Glouton a = new Glouton();
                a.resoudre(Sac);
                out.println(Sac.toString());
                break;
            case "dynamique":
                Dynamique b = new Dynamique();
                b.resoudre(Sac);
                out.println(Sac.toString());
                break;
            case "pse":
                PSE c = new PSE();
                c.resoudre(Sac);
                out.println(Sac.toString());
                break;
            default:
                System.out.println("Aucun algorithme spécifié.");
                break;
        }
        Date D2 = new Date();
        long dateDiff = D2.getTime() - D1.getTime();
        System.out.println("\nTemps pris pour résoudre le sac: " + TimeUnit.MILLISECONDS.convert(dateDiff, TimeUnit.MILLISECONDS) + "ms");
    }
}