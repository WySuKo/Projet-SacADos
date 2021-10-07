package Sac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static java.lang.System.*;

public class Main {

    public static void main(String[] args) {
        SacADos SAC = new SacADos("cccc", 5.0f);
        Glouton Algo = new Glouton();
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
        Algo.AlgoGlouton(SAC);
        out.println(SAC.toString());
    }
}
