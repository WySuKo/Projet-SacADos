package Sac;

import java.util.ArrayList;

public class Objet {
    private String nom;
    private float poids;
    private float valeur;
    private float rapport;
    private boolean estDedans;

    public static ArrayList<Objet> Objets = new ArrayList<Objet>();

    public Objet(String n, float p, float v){
        this.nom = n;
        this.poids = p;
        this.valeur = v;
        this.rapport = v / p;
        this.estDedans = false;
    }

    public String getNom() {
        return this.nom;
    }

    public float getRapport(){
        return this.rapport;
    }

    public float getPoids() {
        return this.poids;
    }

    public float getValeur() {
        return this.valeur;
    }

    public boolean isEstDedans() {
        return this.estDedans;
    }

    public void setEstDedans(boolean estDedans) {
        this.estDedans = estDedans;
    }

    public String toString(){
        return this.nom + "; " + this.poids + " ; " + this.valeur;
    }
}
