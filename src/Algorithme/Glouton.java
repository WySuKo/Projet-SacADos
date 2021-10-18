package Algorithme;
import Algorithme.Resolution;
import Sac.Objet;
import Sac.SacADos;

import java.util.*;
import java.util.ArrayList;

/**
 * Classe pour la création de l'algorithme Glouton
 * @author Fabien Ribeiro, Axel Roche
 * @version 1.0
 * @since 2021-10
 */
public class Glouton implements Resolution {
    /**
     * Méthode qui permet de résoudre le sac avec l'algo glouton
     * @param sac le sac pour les objets
     */
    @Override
    public void resoudre(SacADos sac) {
        //Algo de tri dans la liste d'objet
        Quicksort(Objet.Objets, 0, Objet.Objets.size() - 1);
        //On change la liste en décroissant
        Collections.reverse(Objet.Objets);
        //On boucle sur tout les objets de la liste d'objet puis on ajoute
        for (int i = 0; i < Objet.Objets.size(); i++) {
                sac.ajouter(Objet.Objets.get(i));
        }
    }

    /**
     * Méthode échanger qui permet d'échanger deux objets
     * @param Objets liste d'objet
     * @param a l'objet à échanger avec l'objet b
     * @param b l'objet à échanger avec l'objet a
     */
    public void echanger(ArrayList<Objet> Objets, Objet a, Objet b){
        Collections.swap(Objet.Objets, Objets.indexOf(a), Objets.indexOf(b));
    }

    /**
     * Méthode qui permet de partitionner en plusieurs tableau la liste d'objet
     * @param Objets la liste d'objet qui sera partionnée
     * @param debut le début de la partition
     * @param fin la fin de la partition
     * @return la position de l'objet trié
     */
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

    /**
     * Méthode qui permet de faire l'algorithme de QuickSort
     * @param Objets la liste d'objet
     * @param debut la position du premier élément dans la liste
     * @param fin la position du dernier élément dans la liste
     */
    public void Quicksort(ArrayList<Objet> Objets, int debut, int fin) {
        if (debut < fin) {
            int pi = partition(Objets, debut, fin);
            Quicksort(Objets, debut, fin - 1);
            Quicksort(Objets, pi + 1, fin);
        }
    }

}


