    package Algorithme;
    import Sac.*;

    public class Dynamique implements Resolution{
        public Dynamique(){
        }
        @Override
        public void resoudre(SacADos sac){
            //float matrice[][] = new float[Objet.Objets.size()][(int) sac.getPoidsMax()+1];
            float matrice[][] = new float[Objet.Objets.size()][Math.round(sac.getPoidsMax()) + 1];
            for ( int j = 0; j < sac.getPoidsMax();j++) {
                if (Objet.Objets.get(0).getPoids() > j) {
                    matrice[0][j] = 0;
                } else {
                    matrice[0][j] = Objet.Objets.get(0).getValeur();
                }
            }
            for (int i = 1; i < Objet.Objets.size(); i++) {
                for (int j = 0; j < sac.getPoidsMax()+1; j++) {
                    if (Objet.Objets.get(i).getPoids() > j) {
                        matrice[i][j] = matrice[i - 1][j];
                    } else {
                        matrice[i][j] = Math.max(matrice[i - 1][j], matrice[i - 1][Math.round(j - Objet.Objets.get(i).getPoids())] + Objet.Objets.get(i).getValeur());
                    }
                }
            }

            int i = Objet.Objets.size()-1;
            int j = (int) sac.getPoidsMax();
            while(matrice[i][j] == matrice[i][j-1]){
                j--;
            }
            while(j>0){
                while(i>0 && matrice[i][j] == matrice[i-1][j]){
                    i--;
                }
                j = j - (int)(Objet.Objets.get(i).getPoids());
                if (j>=0){
                    //sac.getObjets().add(Objet.Objets.get(i));
                    sac.ajouter(Objet.Objets.get(i));
                }
                i--;
            }
            }
    }
