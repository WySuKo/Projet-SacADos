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
    public void resoudre(SacADos sac){
        float borneSup = borneInf = 0;

        for(Objet obj : Objet.Objets){
            borneSup += obj.getValeur();
        }
        ArbreObjets racine = new ArbreObjets();

        arbreOptimal = racine;

        creerArbreBinaire(sac, racine,borneSup,1);

        ajouterDansSac(arbreOptimal,sac);
    }
    public void creerArbreBinaire(SacADos sac, ArbreObjets noeudABR, float borneSup, int pos){
        noeudABR.setBrancheDroite(Objet.Objets.get(pos),pos);
        noeudABR.setBrancheGauche();

        if(noeudABR.getBrancheDroite().getValNoeud() >= borneInf &&
                noeudABR.getBrancheDroite().getPoidsNoeud() <= sac.getPoidsMax()){
            this.arbreOptimal = noeudABR.brancheDroite;
            this.borneInf = this.arbreOptimal.getValNoeud();
        }
        if (pos < Objet.Objets.size() - 1 && noeudABR.getPoidsNoeud() < sac.getPoidsMax()){
            creerArbreBinaire(sac,noeudABR.getBrancheDroite(),borneSup,pos + 1);

            float optiMax = borneSup - Objet.Objets.get(pos).getValeur();

            if ( optiMax >= borneInf ){
                creerArbreBinaire(sac,noeudABR.getBrancheGauche(),optiMax,pos + 1);
            }
        }
    }
    public void ajouterDansSac(ArbreObjets meilleurNoeud,SacADos sac){
        int index;

        if ((index = meilleurNoeud.getPosObj()) != -1){
            sac.ajouter(Objet.Objets.get(index));
        }

        if(!meilleurNoeud.getRacine()){
            ajouterDansSac(meilleurNoeud.getBranchePrincipale(),sac);
        }
    }
}