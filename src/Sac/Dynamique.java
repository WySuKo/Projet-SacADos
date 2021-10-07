package Sac;
import Sac.*;

public class Dynamique {
    public float matrice[][] = new float[0][];
    public Dynamique(){

    }

    public void AlgoDynamique(SacADos sac){

        for (int j = 0; j < sac.getPoidsMax();j++){
            if (Objet.Objets.get(0).getPoids() > j){
                matrice[0][j] = 0;
            }
            else{
                matrice[0][j] = Objet.Objets.get(0).getValeur();
            }
            for (int i = 1; i < Objet.Objets.size(); i++){
                if (Objet.Objets.get(i).getPoids() > j){
                    matrice[i][j] = matrice[i-1][j];
                }
                else{
                    matrice[i][j] = Math.max(matrice[i-1][j],matrice[i-1][(int) (j - Objet.Objets.get(i).getPoids())] + Objet.Objets.get(i).getValeur());
                }
            }
         }
        }
}
