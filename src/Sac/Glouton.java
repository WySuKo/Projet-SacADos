package Sac;
import Sac.*;

import java.lang.reflect.Array;
import java.util.*;
import java.util.ArrayList;

import static java.lang.System.out;

public class Glouton {
    public Glouton() {
    }

    public void Glouton(SacADos sac) {
        int somme = 0;
        Collections.sort(Objet.Objets, new Comparateur()); // Objets = Arraylist static d'objets attrapé dans le fichier.txt
        for (int i = 0; i < Objet.Objets.size(); i++) {
            somme += Objet.Objets.get(i).getPoids();
            if (somme < sac.getPoidsMax()) {
                sac.getObjets().add(Objet.Objets.get(i));
            } else {
                somme -= Objet.Objets.get(i).getPoids();
            }
        }
    }
    /* Tentative de traduction du pseudo code dans le cours
     erreur sûre dans la méthode triRapideRec dans son for. */
    public void echanger(ArrayList<Objet> Objets, Objet a, Objet b){
        Collections.swap(Objets, Objets.indexOf(a), Objets.indexOf(b));
    }
    public void repartition(ArrayList<Objet> Objets, Objet premier, Objet dernier ){
        Objet pivot = premier;
        for (int i = 0; i < Objets.size() - 1; i++){
            if(Objets.get(i).getRapport() < dernier.getRapport()){
                echanger(Objets, Objets.get(i), dernier);
            } else {
                echanger(Objets, dernier, premier);
            }
        }
    }
    public void triRapideRec(ArrayList<Objet> Objets, Objet premier, Objet dernier){
        if (premier.getRapport() < dernier.getRapport()){
            Objet pivot = dernier;
            repartition(Objets, premier, dernier);
            triRapideRec(Objets, premier, dernier);
        }
    }
    public void triRapide(ArrayList<Objet> Objets){
        triRapideRec(Objets, Objets.get(0), Objets.get(Objet.Objets.size() - 1));
    }
}
