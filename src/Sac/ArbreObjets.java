package Sac;

/**
 * Classe permettannt la création de l'arbre
 * @author Fabien Ribeiro, Axel Roche
 * @version 1.0
 * @since 2021-10
 */
public class ArbreObjets {
    /**
     * La racine de notre arbre
     */
    private final ArbreObjets branchePrincipale;

    /**
     * Branche droite de l'arbre, équivaut au fils droit de son père
     */
    ArbreObjets brancheDroite;

    /**
     * Branche gauche de l'arbre, équivaut au fils gauche de son père
     */
    ArbreObjets brancheGauche;

    /**
     * La valeur du noeud
     */
    private final float valNoeud;

    /**
     *
     */
    private final float poidsNoeud;
    /**
     * Position de l'objet dans l'arbre
     */
    private int posObj;

    /**
     * Profondeur de l'arbre
     */
    private final int profondeur;

    /**
     * Constructeur de notre racine, initialisation de chacunes des données correspondantes
     */
    public ArbreObjets(){
        this.branchePrincipale = this;
        this.profondeur = 0;
        this.valNoeud = 0;
        this.poidsNoeud = 0;
    }

    /**
     * Constructeur permettant la création d'une branche
     * @param racine le noeud parant de la branche
     * @param poids le poids du noeud
     * @param valeur la valeur du noeud
     * @param pos la position de l'objet dans le noeud
     */
    public ArbreObjets(ArbreObjets racine,float poids,float valeur,int pos){
        this.branchePrincipale = racine;
        this.poidsNoeud = poids;
        this.valNoeud = valeur;
        this.posObj = pos;
        this.profondeur = branchePrincipale.profondeur +1;
    }

    /**
     * Modification de la branche droite afin de lui faire contenir les objets
     * @param obj l'objet qui sera contenu dans la branche
     * @param pos la position de l'objet dans le sac
     */
    public void setBrancheDroite(Objet obj,int pos) {
        this.brancheDroite = new ArbreObjets(this,poidsNoeud + obj.getPoids(),valNoeud + obj.getValeur(),pos);
    }

    /**
     * Modification de la branche gauche
     */
    public void setBrancheGauche() {
        this.brancheGauche = new ArbreObjets(this,poidsNoeud,valNoeud,-1);
    }

    /**
     * Récupère la branche principale
     * @return la branche principale
     */
    public ArbreObjets getBranchePrincipale() {
        return branchePrincipale;
    }

    /**
     * Récupère la branche droite
     * @return la branche droite
     */
    public ArbreObjets getBrancheDroite() {
        return this.brancheDroite;
    }

    /**
     * Récupère la branche gauche
     * @return la branche gauche
     */
    public ArbreObjets getBrancheGauche() {
        return this.brancheGauche;
    }


    /**
     * Récupère la position
     * @return la position
     */
    public int getPosObj() {
        return this.posObj;
    }

    /**
     * Récupère la racine de l'arbre
     * @return la racine
     */
    public boolean getRacine() {
        return this.profondeur == 0;
    }

    public float getValNoeud() {
        return valNoeud;
    }

    public float getPoidsNoeud() {
        return poidsNoeud;
    }
}