package Sac;

public class ABR {
    private ABR parent;
    private ABR filsDroit;
    private ABR filsGauche;
    private int profondeur;
    private float valeur;
    private float poids;
    private int indexObjet;

    public ABR(){
        this.parent = this;
        this.profondeur = 0;
        this.poids = this.valeur = 0;
    }
    public ABR(ABR parent, float valeur, float poids, int index){
        this.parent = parent;
        this.profondeur = profondeur;
        this.valeur = valeur;
        this.poids = poids;
        this.indexObjet = index;
    }

    public void setFilsGauche(Objet Objet, int index){
        this.filsGauche= new ABR(this.parent, this.valeur + Objet.getValeur(), this.poids + Objet.getPoids(), index);
    }

    public void setFilsDroit(){
        this.filsDroit = new ABR(this.parent, this.valeur, this.poids, -1);
    }
    public ABR getFilsDroit(){
        return this.filsDroit;
    }
    public ABR getFilsGauche(){
        return this.filsGauche;
    }
    public ABR getParent(){
        return this.parent;
    }
    public float getValeur(){
        return this.valeur;
    }
    public float getPoids(){
        return this.poids;
    }
    public int getIndexObjet(){
        return this.indexObjet;
    }
    public boolean estRacine(){
        return this.profondeur == 0;
    }
}
