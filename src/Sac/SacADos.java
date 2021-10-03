package Sac;

import java.util.*;

public class SacADos {
    public ArrayList<Objet> Objets;
    private float poidsMax;
    private String chemin;

    public SacADos(){
        Objets = new ArrayList<Objet>();
    }

    public SacADos(String c, float poidsmaximal){
        this.chemin = c;
        this.poidsMax = poidsmaximal;
        Objets = new ArrayList<Objet>();
    }

    public ArrayList<Objet> getObjets() {
        return Objets;
    }

    public float getValeurTotal(){
        float sum = 0.0F;
        for (int i = 0 ; i < this.Objets.size() ; i++){
            sum += this.Objets.get(i).getValeur();
        }
        return sum;
    }

    public float getPoidsTotal(){
        float sum = 0.0F;
        for (int i = 0 ; i < this.Objets.size() ; i++){
            sum += this.Objets.get(i).getPoids();
        }
        return sum;
    }

    public float getPoidsMax() {
        return poidsMax;
    }


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
