package Sac;
import Sac.*;

/**
 * Classe pour la création de l'algorithme PSE
 * @author Fabien Ribeiro, Axel Roche
 * @version 1.0
 * @since 2021-10
 */
public class PSE {
    /**
     * La borne minimale qui nous sera nécessaire pour l'algorithme
     */
    private float borneInf;

    /**
     * La borne maximale qui nous sera nécessaire pour l'algorithme
     */
    private float borneSup;

    private float poidsMaxSac;

    /**
     * L'arbre qui contiendra le chemin de l'arbre le plus optimal
     */
    private ArbreObjets arbreOptimal;

    /**
     * Constructeur de l'algorithme PSE
     */
    public PSE(){

    }

    /**
     * Méthode qui permettra d'effectuer notre algorithme
     */
    public void resoudre(){

    }
    public void creerArbreBinaire(ArbreObjets noeudABR, float borneSup, int pos){
        noeudABR.setBrancheDroite(Objet.Objets.get(pos),pos);
        noeudABR.setBrancheGauche();

        if(noeudABR.getBrancheDroite().getValNoeud() >= borneInf &&
                noeudABR.getBrancheDroite().getPoidsNoeud() <= this.poidsMaxSac){
            this.arbreOptimal = noeudABR.brancheDroite;
            this.borneInf = this.arbreOptimal.getValNoeud();
        }
    }
}
