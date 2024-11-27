class Personne {
    private String nom;
    private String prenom;
    private String email;
    private String tel;
    private int age;

    public Personne(String nom, String prenom, String email, String tel, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
        this.age = age;
    }

    public void afficher() {
        System.out.println("Nom: " + nom + ", Prénom: " + prenom + ", Email: " + email + ", Téléphone: " + tel + ", Âge: " + age);
    }
}

class Adherent extends Personne {
    private int numAdherent;
    public Adherent(String nom, String prenom, String email, String tel, int age, int numAdherent) {
        super(nom, prenom, email, tel, age);
        this.numAdherent = numAdherent; }
    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Numéro Adhérent: " + numAdherent);
    }}

class Auteur extends Personne {
    private int numAuteur;

    public Auteur(String nom, String prenom, String email, String tel, int age, int numAuteur) {
        super(nom, prenom, email, tel, age);
        this.numAuteur = numAuteur;
    }
    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Numéro Auteur: " + numAuteur);
    }}

class Livre {
    private int ISBN;
    private String titre;
    private Auteur auteur;

    public Livre(int ISBN, String titre, Auteur auteur) {
        this.ISBN = ISBN;
        this.titre = titre;
        this.auteur = auteur;
    }

    public void afficher() {
        System.out.println("ISBN: " + ISBN + ", Titre: " + titre);
        System.out.print("Informations de l'Auteur: ");
        auteur.afficher();
    }
}

public class BibliothequeTest {
    public static void main(String[] args) {
        // Créer un adhérent
        Adherent adherent = new Adherent("jjj", "mmm", "jjkk@gmail.com", "0123456789", 25, 101);
        // Créer un auteur
        Auteur auteur = new Auteur("Hhhhh", "Vvvvv", "vvvggg@gmail.com", "0987654321", 46, 202);
        // Créer un livre
        Livre livre = new Livre(123456, "aaaaaa", auteur);

        // Afficher les informations
        System.out.println("Informations de l'Adhérent:");
        adherent.afficher();
        
        System.out.println("\nInformations du Livre:");
        livre.afficher();
    }
}
