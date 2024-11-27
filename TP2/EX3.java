class Ordinateur {
    private String nom;
    private String marque;
    private double prix;
    private String description;
    private int stock;

    public Ordinateur(String nom, String marque, double prix, String description, int stock) {
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.description = description;
        this.stock = stock;
    }
    
    public void afficher() {
        System.out.println("Ordinateur: " + nom + ", Marque: " + marque + ", Prix: " + prix +
                           ", Description: " + description + ", Stock: " + stock);
    }
}

class Categorie {
    private String nom;
    private ArrayList<Ordinateur> ordinateurs;
    
    public Categorie(String nom) {
        this.nom = nom;
        this.ordinateurs = new ArrayList<>();
    }
    
    public void ajouterOrdinateur(Ordinateur ordinateur) {
        ordinateurs.add(ordinateur);
    }
    
    public void afficherOrdinateurs() {
        for (Ordinateur ordinateur : ordinateurs) {
            ordinateur.afficher();
        }
    }
}

class Client {
    private String nom;
    private String prenom;
    private String email;
    public Client(String nom, String prenom, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }
    public void afficher() {
        System.out.println("Client: " + nom + " " + prenom + ", Email: " + email);
    }
}

class Commande {
    private Client client;
    private ArrayList<Ordinateur> ordinateurs;

    public Commande(Client client) {
        this.client = client;
        this.ordinateurs = new ArrayList<>();
    }

    public void ajouterOrdinateur(Ordinateur ordinateur) {
        ordinateurs.add(ordinateur);
    }

    public void afficher() {
        client.afficher();
        System.out.println("Ordinateurs dans la commande:");
        for (Ordinateur ordinateur : ordinateurs) {
            ordinateur.afficher();
        }
    }
}

public class CommandeTest {
    public static void main(String[] args) {
        // Création d'ordinateurs
        Ordinateur pc1 = new Ordinateur("PC1", "Dell", 1000, "Description PC1", 10);
        Ordinateur pc2 = new Ordinateur("PC2", "HP", 1200, "Description PC2", 8);
        
        // Création d'une catégorie
        Categorie categorie = new Categorie("Gaming");
        categorie.ajouterOrdinateur(pc1);
        categorie.ajouterOrdinateur(pc2);

        // Création d'un client
        Client client = new Client("Doe", "John", "john.doe@example.com");

        // Création d'une commande
        Commande commande = new Commande(client);
        commande.ajouterOrdinateur(pc1);
        commande.ajouterOrdinateur(pc2);

        // Afficher les informations
        System.out.println("Commande du client:");
        commande.afficher();
    } }
