package Algorithme;
import Sac.*;

/**
 * Classe pour la création de l'algorithme Dynamique
 * @author Fabien Ribeiro, Axel Roche
 * @version 1.0
 * @since 2021-10
 */
public class Dynamique implements Resolution{
    /**
     * Permet de résoudre avec l'algorithme Dynamique
     * @param sac le sac qui contiendra les objets
     */
    @Override
    public void resoudre(SacADos sac){
        //création de la matrice en fonction du nombre d'objet dans la liste ainsi que le poidsMax du sac
        float matrice[][] = new float[Objet.Objets.size()][Math.round(sac.getPoidsMax()) + 1];
        //On remplis la premiere ligne
        for ( int j = 0; j < sac.getPoidsMax();j++) {
            if (Objet.Objets.get(0).getPoids() > j) {
                matrice[0][j] = 0;
            } else {
                matrice[0][j] = Objet.Objets.get(0).getValeur();
            }
        }
        //On remplis les autres lignes avec les valeurs et les poids des objets
        for (int i = 1; i < Objet.Objets.size(); i++) {
            for (int j = 0; j < sac.getPoidsMax()+1; j++) {
                if (Objet.Objets.get(i).getPoids() > j) {
                    matrice[i][j] = matrice[i - 1][j];
                } else {
                    matrice[i][j] = Math.max(matrice[i - 1][j], matrice[i - 1][Math.round(j - Objet.Objets.get(i).getPoids())] + Objet.Objets.get(i).getValeur());
                }
            }
        }
        //on crée deux variable pour remonter le tableau
        int i = Objet.Objets.size()-1;
        int j = (int) sac.getPoidsMax();
        //on remonte le tableau puis on ajoute en fonction de notre position dans la matrice l'objet dans le sac
        while(matrice[i][j] == matrice[i][j-1]){
            j--;
        }
        while(j>0){
            while(i>0 && matrice[i][j] == matrice[i-1][j]){
                i--;
            }
            j = j - (int)(Objet.Objets.get(i).getPoids());
            if (j>=0){

                sac.ajouter(Objet.Objets.get(i));
            }
            i--;
        }
    }
}
