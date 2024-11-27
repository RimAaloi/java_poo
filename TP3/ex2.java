class RacineCarreeException extends Exception {
    public RacineCarreeException(int nombre) {
        super("C'est une exception de type RacineCarreeException. Nombre négatif : " + nombre);
    }
}
class Calculateur {
    public double testRacineCarree(int nombre) throws RacineCarreeException {
        if (nombre < 0) {
            throw new RacineCarreeException(nombre);
        }
        return Math.sqrt(nombre);
    }
}
public class Main {
    public static void main(String[] args) {
        Calculateur calculateur = new Calculateur();
        try {
            System.out.println(calculateur.testRacineCarree(25)); 
            System.out.println(calculateur.testRacineCarree(-5)); 
        } catch (RacineCarreeException e) {
            e.printStackTrace();
        }
    }
}
