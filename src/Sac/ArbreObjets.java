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
     * Les objets contenus dans la branche
     */
    private final Objet objet;

    /**
     * Position de l'objet dans l'arbre
     */
    private int position;

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
        this.objet = null;
    }

    /**
     * Constructeur pour la créations des branches
     * @param racine la racine père où sera initilisé les branches
     * @param obj   l'objet qui sera contenu dans la branche
     * @param pos position de l'objet dans la branche
     */
    public ArbreObjets(ArbreObjets racine,Objet obj,int pos){
        this.branchePrincipale = racine;
        this.objet = obj;
        this.profondeur = branchePrincipale.profondeur +1;
        this.position = pos;
    }

    /**
     * Modification de la branche droite afin de lui faire contenir les objets
     * @param obj l'objet qui sera contenu dans la branche
     * @param pos la position de l'objet dans le sac
     */
    public void setBrancheDroite(Objet obj,int pos) {
        this.brancheDroite = new ArbreObjets(brancheDroite,obj,pos);
    }

    /**
     * Modification de la branche gauche
     */
    public void setBrancheGauche() {
        this.brancheGauche = new ArbreObjets(brancheGauche,objet,-1);
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
     * Récupère l'objet de la branche
     * @return l'objet
     */
    public Objet getObjet() {
        return this.objet;
    }

    /**
     * Récupère la position
     * @return la position
     */
    public int getPosition() {
        return this.position;
    }

    /**
     * Récupère la racine de l'arbre
     * @return la racine
     */
    public boolean getRacine() {
        return this.profondeur == 0;
    }
}
