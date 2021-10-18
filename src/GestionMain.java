import Algorithme.Dynamique;
import Algorithme.Glouton;
import Algorithme.PSE;
import Sac.Objet;
import Sac.SacADos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static java.lang.System.out;

public class GestionMain {
    public void gestionArgument(String args[]){

        String messageErreur = null;
        Scanner scan = null;

        if (args.length < 3) {
            messageErreur += "Arguments Manquants : ";
            switch (args.length) {
                case 0:
                    messageErreur += "chemin ";
                case 1:
                    messageErreur += "poids-maximal ";
                case 2:
                    messageErreur += "methode\nSyntaxe: ./resoudre-sac-a-dos chemin poids-maximal > 0 methode;";
                    break;
                default:
                    break;
            }
            throw new IllegalArgumentException(messageErreur);
        }

        try {
            Double.parseDouble(args[1]);
        } catch (NumberFormatException e){
            out.println("Le paramètre du poids maximum du sac n'est pas valide");
            System.exit(1);
        }

        Float poidsMax = Float.parseFloat(args[1]);
        SacADos Sac = new SacADos(args[0], poidsMax);

        if (poidsMax <= 0){
            messageErreur = "Le poids maximal du sac doit être positif";
            throw new IllegalArgumentException(messageErreur);
        }

        try {
            scan = new Scanner(new File(args[0]));
        } catch (FileNotFoundException e)  {
            e.printStackTrace();
            out.println("Fichier qui n'existe pas");
        }

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] caracs = line.split(";");
            Objet.Objets.add(new Objet(caracs[0], Float.parseFloat(caracs[1]), Float.parseFloat(caracs[2])));
        }

        switch(args[2].toLowerCase()) {
            case "gloutonne":
                Glouton a = new Glouton();
                a.resoudre(Sac);
                out.println(Sac.toString());
                break;
            case "dynamique":
                SacADos SAAC = new SacADos(args[0], Math.round(poidsMax));
                Dynamique b = new Dynamique();
                b.resoudre(SAAC);
                out.println(SAAC.toString());
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
    }
}
