package Algorithme;
import Algorithme.Resolution;
import Sac.ArbreObjets;
import Sac.Objet;
import Sac.SacADos;

/**
 * Classe pour la création de l'algorithme PSE
 * @author Fabien Ribeiro, Axel Roche
 * @version 1.0
 * @since 2021-10
 */
public class PSE implements Resolution {
    /**
     * La borne inférieur
     */
    private float borneInf;

    /**
     * La borne supérieur
     */
    private float borneSup;

    /**
     * L'arbre qui contiendra le chemin de l'arbre le plus optimal
     */
    private ArbreObjets arbreOptimal;


    /**
     * Méthode de résolution PSE
     * @param sac le sac contenant les objets
     */
    @Override
    public void resoudre(SacADos sac){
        //On initialise les bornes à 0
        float borneSup = borneInf = 0;

        //On ajoute la somme des valeurs de tout les objets présent dans la liste
        for(Objet obj : Objet.Objets){
            borneSup += obj.getValeur();
        }
        //Création de la racine
        ArbreObjets racine = new ArbreObjets();
        //Initialisation de l'arbre optimale en lui donnant la racine
        arbreOptimal = racine;
        //Création de l'arbre binaire le plus optimal
        creerArbreBinaire(sac, racine,borneSup,1);
        //Ajoute de l'arbre optimal dans le sac
        ajouterDansSac(arbreOptimal,sac);
    }

    /**
     * Permet de créer l'abre binaire
     * @param sac le sac pour les objets
     * @param noeudABR noeud lors de sa création
     * @param borneSup la borne supérieur
     * @param pos la position de l'objet dans l'arbre
     */
    public void creerArbreBinaire(SacADos sac, ArbreObjets noeudABR, float borneSup, int pos){
        //Création de la branche droite au début de l'arbre
        noeudABR.setBrancheDroite(Objet.Objets.get(pos),pos);
        //Création de la brance gauche
        noeudABR.setBrancheGauche();

        //on ajoute l'objet dans la branche droite si on respecte les bornes sup et inf
        if(noeudABR.getBrancheDroite().getValNoeud() >= borneInf &&
                noeudABR.getBrancheDroite().getPoidsNoeud() <= sac.getPoidsMax()){
            //pour chaque création de branche droite l'arbre optimal prend la valeur de cette branche
            this.arbreOptimal = noeudABR.getBrancheDroite();
            //on prend la valeur du noeud actuel
            this.borneInf = this.arbreOptimal.getValNoeud();
        }
        //si le poids max n'est pas atteint on ajoute une nouvelle branche droite
        if (pos < Objet.Objets.size() - 1 && noeudABR.getPoidsNoeud() < sac.getPoidsMax()){
            creerArbreBinaire(sac,noeudABR.getBrancheDroite(),borneSup,pos + 1);
            //création d'une variable permettant de stopper une fois atteint 0 la création de la branche gauche
            float optiMax = borneSup - Objet.Objets.get(pos).getValeur();

            if ( optiMax >= borneInf ){
                creerArbreBinaire(sac,noeudABR.getBrancheGauche(),optiMax,pos + 1);
            }
        }
    }

    /**
     * Ajoute le meilleur noeud d'objet dans le sac
     * @param meilleurNoeud le meilleur noeud d'objet
     * @param sac le sac dans lequel sera contenu les objets
     */
    public void ajouterDansSac(ArbreObjets meilleurNoeud,SacADos sac){
        int index;
        //si on obtiens -1 alors il n'y a pas d'objet à ajouter
        if ((index = meilleurNoeud.getPosObj()) != -1){
            sac.ajouter(Objet.Objets.get(index));
        }
        //on remonte le meilleur noeud pour mettre les objets dans le sac
        if(!meilleurNoeud.getRacine()){
            ajouterDansSac(meilleurNoeud.getBranchePrincipale(),sac);
        }
    }
}