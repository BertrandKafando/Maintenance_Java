import metier.MetierImpl;
import metier.Responsable;

public class Application  {
    public  static  void main(String []args){

        Responsable rep=new Responsable("kaf","bertrand","email","telephone", "adresse", "password");

        MetierImpl imp=new MetierImpl();

        //imp.supprimerResponsable(imp.getResponsable());
        //System.out.println(imp.getResponsable());
    }

}
