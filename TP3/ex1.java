class TropViteException extends Exception {
    public TropViteException(int vitesse) {
        super("C'est une exception de type TropViteException. Vitesse en cause : " + vitesse);
    }
}
class Vehicule {
    public void testVitesse(int vitesse) throws TropViteException {
        if (vitesse > 90) {
            throw new TropViteException(vitesse);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Vehicule vehicule = new Vehicule();
        try {
            vehicule.testVitesse(100); 
            vehicule.testVitesse(80);  
        } catch (TropViteException e) {
            e.printStackTrace();
        }
    }
}
