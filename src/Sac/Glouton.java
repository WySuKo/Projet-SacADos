package Sac;
import Sac.*;

import java.lang.reflect.Array;
import java.util.*;
import java.util.ArrayList;

import static java.lang.System.out;

/**
 * Classe permettant de faire l'algorithme Glouton
 * @author Fabien Ribeiro, Axel Roche
 * @version 1.0
 * @since 2021-10
 */
public class Glouton {
    /**
     * Constructeur permettant d'initialiser l'algorithme
     */
    public Glouton() {
    }

    /**
     * Algorithme glouton
     * @param sac le sac à trier et remplir en fonction de l'algorithme
     */
    public void Glouton(SacADos sac) {
        int somme = 0;
        Collections.sort(Objet.Objets, new Comparateur()); // Objets = Arraylist static d'objets attrapés dans le fichier.txt
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
        Collections.swap(Objet.Objets, Objets.indexOf(a), Objets.indexOf(b));
    }

    public Objet choixPivot(ArrayList<Objet> Objets){
        int p = ((Objet.Objets.size() / 2));
        Objet pivot = Objet.Objets.get(p);
        return pivot;
    }

    public void repartition(ArrayList<Objet> Objets, Objet premier, Objet dernier, Objet p){
        echanger(Objet.Objets, choixPivot(Objets), dernier);
        int e = Objet.Objets.indexOf(premier);
        for (int i = 0; i < Objet.Objets.size() - 1; i++){
            if(Objet.Objets.get(i).getRapport() < dernier.getRapport()){
                echanger(Objet.Objets, Objet.Objets.get(i), premier);
                e++;
                premier = Objet.Objets.get(e);
            } else {
                echanger(Objet.Objets, dernier, premier);
            }
        }
    }

    public void triRapideRec(ArrayList<Objet> Objets, Objet premier, Objet dernier){
        if (premier.getRapport() < dernier.getRapport()){
            Objet p = choixPivot(Objets);
            repartition(Objet.Objets, premier, dernier, p);
            triRapideRec(Objet.Objets, premier, Objets.get(Objets.size() - 1));
            triRapideRec(Objet.Objets, Objets.get(Objets.size() + 1), dernier);
        }
    }
    public void triRapide(ArrayList<Objet> Objets){
        triRapideRec(Objet.Objets, Objets.get(0), Objets.get(Objet.Objets.size() - 1));
    }
}
