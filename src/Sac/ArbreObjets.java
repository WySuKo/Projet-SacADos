package Sac;

public class ArbreObjets {
    private Integer value;
    private float borneInf;
    private float borneSup;
    ArbreObjets brancheDroite;
    ArbreObjets brancheGauche;

    public ArbreObjets(){
    }

    public void insertion(Integer valeur){
        if(this.value == null){
            this.value = valeur;
            this.brancheGauche = new ArbreObjets();
            this.brancheDroite = new ArbreObjets();
        }
        else {
            if (this.value <= valeur){
                this.brancheDroite.insertion(valeur);
            }
            else{
                this.brancheGauche.insertion(valeur);
            }
        }
    }

}
