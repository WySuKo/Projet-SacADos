package Sac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static java.lang.System.*;

public class Main {

    public static void main(String[] args) {
        SacADos SAC = new SacADos("cccc", 12.0f);
        Glouton Algo = new Glouton();
        Dynamique Alg = new Dynamique();
        Scanner scan = null;
        try {
            scan = new Scanner(new File("Items.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] caracs = line.split(";");
            Objet.Objets.add(new Objet(caracs[0], Float.parseFloat(caracs[1]), Float.parseFloat(caracs[2])));
        }
        //out.println(SAC.getObjets());
        //Collections.sort(SAC.getObjets(), new Comparateur());
        //out.println(SAC.getObjets());
        //out.println(Objet.Objets);
        //out.println(SAC.toString());
        out.println(Objet.Objets);
        //Algo.Glouton(SAC);
        //Algo.partition(Objet.Objets, 0, Objet.Objets.size() - 1);
        out.println(Objet.Objets);
        Algo.Glouton(SAC);
        out.println(Objet.Objets);
    }
}
