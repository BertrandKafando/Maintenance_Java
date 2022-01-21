package Controller;

import metier.MetierImpl;
import metier.Responsable;

public class Test {
    public static void  main(String []args){
        MetierImpl imp =new MetierImpl();
        Responsable responsable= new Responsable("Kddl","Berto","kafando@gmail","tel","add","pass");
        imp.ajouterResponsable(responsable);

    }
}
