package Sac;

import java.util.ArrayList;

public class SacADos {
    private ArrayList<Objet> Objets = new ArrayList<Objet>();
    private float poidsMax;
    private String chemin;

    public SacADos(){
        ArrayList<Objet> Objets = new ArrayList<Objet>();
    }

    public SacADos(String c, float poidsmaximal){
        this.chemin = c;
        this.poidsMax = poidsmaximal;
        ArrayList<Objet> Objets = new ArrayList<Objet>();
    }


}
