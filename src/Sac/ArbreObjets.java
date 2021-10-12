package Sac;

/**
 * Classe permettannt la création de l'arbre
 * @author Fabien Ribeiro, Axel Roche
 * @version 1.0
 * @since 2021-10
 */
public class ArbreObjets {
    private final ArbreObjets branchePrincipale;
    ArbreObjets brancheDroite;
    ArbreObjets brancheGauche;
    private final Objet objet;
    private int position;
    private final int profondeur;

    public ArbreObjets(){
        this.branchePrincipale = this;
        this.profondeur = 0;
        this.objet = null;
    }

    public ArbreObjets(ArbreObjets racine,Objet obj,int pos){
        this.branchePrincipale = racine;
        this.objet = obj;
        this.profondeur = branchePrincipale.profondeur +1;
        this.position = pos;
    }

    public void setBrancheDroite(Objet obj,int pos) {
        this.brancheDroite = new ArbreObjets(brancheDroite,obj,pos);
    }

    public void setBrancheGauche() {
        this.brancheGauche = new ArbreObjets(brancheGauche,objet,-1);
    }

    public ArbreObjets getBranchePrincipale() {
        return branchePrincipale;
    }

    public ArbreObjets getBrancheDroite() {
        return this.brancheDroite;
    }

    public ArbreObjets getBrancheGauche() {
        return this.brancheGauche;
    }

    public Objet getObjet() {
        return this.objet;
    }


    public int getPosition() {
        return this.position;
    }

    public boolean getRacine() {
        return this.profondeur == 0;
    }
}
