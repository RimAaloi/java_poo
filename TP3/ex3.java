class NoteInvalideException extends Exception {
    public NoteInvalideException(int note) {
        super("Exception de type NoteInvalideException. Note invalide : " + note);
    }
}
class Evaluateur {
    public Evaluateur() {
        // Constructeur vide
    }
    public void verifierNote(int note) throws NoteInvalideException {
        if (note < 0 || note > 20) {
            throw new NoteInvalideException(note);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Evaluateur evaluateur = new Evaluateur();
        try {
            evaluateur.verifierNote(15); 
            evaluateur.verifierNote(25);
        } catch (NoteInvalideException e) {
            e.printStackTrace();
        }
    }
}
