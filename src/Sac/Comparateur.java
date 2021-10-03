package Sac;
import Sac.*;

import java.util.Comparator;

// Methode de comparaison de 2 objets afin de trier l'arraylist

public class Comparateur implements Comparator<Objet> {
    @Override
    public int compare(Objet o, Objet o1){
        float difference = o.getRapport() - o1.getRapport();
        if (difference > 0){
            return -1;
        }
        if (difference < 0)
            return 1;
        return 0;
    }
}