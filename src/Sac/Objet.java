package Sac;

import java.util.ArrayList;

/**
 * Classe pour les objets qui permettront de remplir le sac
 *
 * @author Fabien Ribeiro, Axel Roche
 * @version 1.0
 * @since 2021-10
 */
public class Objet {
    /**
     * Le nom de l'objet
     */
    private String nom;
    /**
     * Le poids de l'objet
     */
    private float poids;
    /**
     * La valeur de l'objet
     */
    private float valeur;
    /**
     * Le rapport de l'objet -> valeur / poids
     */
    private float rapport;
    /**
     * Tableau dynamique d'objets qui sera utilisé pour chaque algorithme
     */
    public static ArrayList<Objet> Objets = new ArrayList<Objet>();

    /**
     *
     * @param n le nom de l'objet
     * @param p le poids de l'objet
     * @param v la valeur de l'objet
     */
    public Objet(String n, float p, float v){
        this.nom = n;
        this.poids = p;
        this.valeur = v;
        this.rapport = v/p;
    }
    /**
     * Récupère le nom de l'objet
     * @return le nom de l'objet
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Récupère le rapport de l'objet
     * @return le rapport de l'objet
     */
    public float getRapport() {
        return rapport;
    }

    /**
     * Récupère le poids de l'objet
     * @return le poids de l'objet
     */
    public float getPoids() {
        return this.poids;
    }

    /**
     * Récupère la valeur de l'objet
     * @return la valeur de l'objet
     */
    public float getValeur() {
        return this.valeur;
    }

    /**
     * Affiche la chaîne de caractère
     * @return le nom/poids/valeur de l'objet
     */
    public String toString(){
        return this.nom + "; " + this.poids + " ; " + this.valeur;
    }


}