package Sac;

public class Objet {
    private String nom;
    private float poids;
    private float valeur;
    private boolean estDedans;

    public Objet(String n, float p, float v){
        this.nom = n;
        this.poids = p;
        this.valeur = v;
        this.estDedans = false;
    }

    public String getNom() {
        return nom;
    }

    public float getPoids() {
        return poids;
    }

    public float getValeur() {
        return valeur;
    }

    public boolean isEstDedans() {
        return estDedans;
    }

    public void setEstDedans(boolean estDedans) {
        this.estDedans = estDedans;
    }
}
