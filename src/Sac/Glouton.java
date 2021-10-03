package Sac;
import Sac.*;
import java.util.*;

import static java.lang.System.out;

public class Glouton  {
    public Glouton(){

    }
    public void Glouton(SacADos sac){
        int somme = 0;
        Collections.sort(Objet.Objets, new Comparateur()); // Objets = Arraylist static d'objets attrapé dans le fichier.txt
        for (int i = 0 ; i < Objet.Objets.size() ; i++){
            somme += Objet.Objets.get(i).getPoids();
            if (somme < sac.getPoidsMax()){
                sac.getObjets().add(Objet.Objets.get(i));
            }
            else{
                somme-= Objet.Objets.get(i).getPoids();
            }
        }
    }
}