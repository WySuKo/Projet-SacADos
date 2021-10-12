package Sac;

import java.util.*;

/**
 * Classe qui pour la création de notre sac à dos
 *
 * @author Fabien Ribeiro, Axel Roche
 * @version 1.0
 * @since 2021-10
 */
public class SacADos {
    /**
     * La liste d'objet qui permettra de stocker les objets dans le sac
     */
    private ArrayList<Objet> Objets;
    /**
     * Le poids maximal du sac
     */
    private float poidsMax;
    /**
     * Le chemin que parcours le compilateur pour le sac
     */
    private String chemin;


    /**
     * Constructeur du sac à dos
     * @param c le chemin du sac à dos
     * @param poidsmaximal le poids maximal du sac à dos
     */
    public SacADos(String c, float poidsmaximal){
        this.chemin = c;
        this.poidsMax = poidsmaximal;
        Objets = new ArrayList<Objet>();
    }

    /**
     * Récupère la liste d'objet du sac à dos
     * @return les objets du sac à dos
     */
    public ArrayList<Objet> getObjets() {
        return Objets;
    }

    /**
     * Fait la samme des valeurs des objets contenus dans le sac
     * @return la somme
     */
    public float getValeurTotal(){
        float sum = 0.0F;
        for (int i = 0 ; i < this.Objets.size() ; i++){
            sum += this.Objets.get(i).getValeur();
        }
        return sum;
    }

    /**
     * Fait la somme des poids des objets contenus dans le sac
     * @return la somme
     */
    public float getPoidsTotal(){
        float sum = 0.0F;
        for (int i = 0 ; i < this.Objets.size() ; i++){
            sum += this.Objets.get(i).getPoids();
        }
        return sum;
    }

    /**
     * Récupère le poids maximal du sac
      * @return le poids maximal
     */
    public float getPoidsMax() {
        return poidsMax;
    }

    /**
     * Affiche la chaîne de caractère permettant d'avoir l'état actuel du sac
     * @return la chaîne de caractère
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Informations sac à dos :\n");
        s.append("-Poids maximal : " + this.getPoidsMax() + "\n");
        s.append("-Poids actuel = " + this.getPoidsTotal() + "(" + (this.getPoidsTotal() * 100 / this.getPoidsMax()) + "%)\n" );
        s.append("-Valeur totale : " + this.getValeurTotal() + "\n");
        s.append("-Contenu :\n");
        for (int i = 0; i<this.Objets.size() ; i++) {
            s.append(" >" + this.getObjets().get(i).toString() +" \n");
        }
        return s.toString();
    }
}