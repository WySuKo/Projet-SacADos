package Sac;
import Sac.*;

import java.lang.reflect.Array;
import java.util.*;
import java.util.ArrayList;

import static java.lang.System.out;

public class Glouton implements Resolution{
    public Glouton() {
    }

    @Override
    public void resoudre(SacADos sac) {
        int somme = 0;
        //Collections.sort(Objet.Objets, new Comparateur()); // Objets = Arraylist static d'objets attrapés dans le fichier.txt
        Quicksort(Objet.Objets, 0, Objet.Objets.size() - 1);
        Collections.reverse(Objet.Objets);
        for (int i = 0; i < Objet.Objets.size(); i++) {
            somme += Objet.Objets.get(i).getPoids();
            if (somme < sac.getPoidsMax()) {
                //sac.getObjets().add(Objet.Objets.get(i));
                sac.ajouter(Objet.Objets.get(i));
            } else {
                somme -= Objet.Objets.get(i).getPoids();
            }
        }
    }

    public void echanger(ArrayList<Objet> Objets, Objet a, Objet b){
        Collections.swap(Objet.Objets, Objets.indexOf(a), Objets.indexOf(b));
    }

    public int partition(ArrayList<Objet> Objets, int debut, int fin){
        int pivot = Objets.indexOf(Objets.get(fin));
        int premier = (debut - 1);

        for (int i = debut; i < fin; i++){
            if(Objets.get(i).getRapport() < Objets.get(pivot).getRapport()){
                premier++;
                echanger(Objets, Objet.Objets.get(i), Objet.Objets.get(premier));
            }
        }
        echanger(Objets, Objet.Objets.get(premier + 1), Objet.Objets.get(fin));
        return (premier + 1);
    }
    public void Quicksort(ArrayList<Objet> Objets, int debut, int fin) {
        if (debut < fin) {
            int pi = partition(Objets, debut, fin);
            Quicksort(Objets, debut, fin - 1);
            Quicksort(Objets, pi + 1, fin);
        }
    }

}


