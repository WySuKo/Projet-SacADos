package Sac;
import Sac.*;

import java.util.Comparator;

/**
 * Classe permettant la comparaison de 2 objets afin de trier l'arraylist
 * @author Fabien Ribeiro, Axel Roche
 * @version 1.0
 * @since 2021-10
 */
public class Comparateur implements Comparator<Objet> {
    /**
     * Comparaison des objets dans l'arraylist
     * @param o le premier objet
     * @param o1 le second objet
     * @return -1 ou 0
     */
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