class Produit {
    private long id;
    private String nom;
    private String marque;
    private double prix;
    private String description;
    private int nombreEnStock;

    public Produit(long id, String nom, String marque, double prix, String description, int nombreEnStock) {
        this.id = id;
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.description = description;
        this.nombreEnStock = nombreEnStock;
    }
    public long getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }
    public String getMarque() {
        return marque;
    }

    public double getPrix() {
        return prix;
    }
    public String getDescription() {
        return description;
    }
    public int getNombreEnStock() {
        return nombreEnStock;
    }
    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", marque='" + marque + '\'' +
                ", prix=" + prix +
                ", description='" + description + '\'' +
                ", nombreEnStock=" + nombreEnStock +
                '}';
    }
}

interface IMetierProduit {
    Produit add(Produit p);
    List<Produit> getAll();
    List<Produit> findByNom(String motCle);
    Produit findById(long id);
    void delete(long id);
}
class MetierProduitImpl implements IMetierProduit {
    private List<Produit> produits = new ArrayList<>();
    @Override
    public Produit add(Produit p) {
        produits.add(p);
        return p;
    }
    @Override
    public List<Produit> getAll() {
        return produits;
    }
    @Override
    public List<Produit> findByNom(String motCle) {
        return produits.stream()
                .filter(p -> p.getNom().toLowerCase().contains(motCle.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public Produit findById(long id) {
        return produits.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }
    @Override
    public void delete(long id) {
        produits.removeIf(p -> p.getId() == id);
    }
}

public class Application {
    public static void main(String[] args) {
        MetierProduitImpl metier = new MetierProduitImpl();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Afficher la liste des produits");
            System.out.println("2. Rechercher des produits par mot clé");
            System.out.println("3. Ajouter un nouveau produit dans la liste");
            System.out.println("4. Récupérer et afficher un produit par ID");
            System.out.println("5. Supprimer un produit par ID");
            System.out.println("6. Quitter ce programme");
            System.out.print("Choisissez une option: ");
            
            int choix = scanner.nextInt();
            scanner.nextLine(); 

            switch (choix) {
                case 1:
                    List<Produit> produits = metier.getAll();
                    if (produits.isEmpty()) {
                        System.out.println("Aucun produit disponible.");
                    } else {
                        produits.forEach(System.out::println);
                    }
                    break;
                case 2:
                    System.out.print("Entrez le mot clé: ");
                    String motCle = scanner.nextLine();
                    List<Produit> resultats = metier.findByNom(motCle);
                    if (resultats.isEmpty()) {
                        System.out.println("Aucun produit trouvé avec ce mot clé.");
                    } else {
                        resultats.forEach(System.out::println);
                    }
                    break;
                case 3:
                    System.out.print("Entrez l'ID du produit: ");
                    long id = scanner.nextLong();
                    scanner.nextLine(); 
                    System.out.print("Entrez le nom du produit: ");
                    String nom = scanner.nextLine();
                    System.out.print("Entrez la marque du produit: ");
                    String marque = scanner.nextLine();
                    System.out.print("Entrez le prix du produit: ");
                    double prix = scanner.nextDouble();
                    scanner.nextLine(); 
                    System.out.print("Entrez la description du produit: ");
                    String description = scanner.nextLine();
                    System.out.print("Entrez le nombre en stock: ");
                    int nombreEnStock = scanner.nextInt();
                    scanner.nextLine();

                    Produit nouveauProduit = new Produit(id, nom, marque, prix, description, nombreEnStock);
                    metier.add(nouveauProduit);
                    System.out.println("Produit ajouté avec succès.");
                    break;
                case 4:
                    System.out.print("Entrez l'ID du produit à afficher: ");
                    long idToFind = scanner.nextLong();
                    Produit produitTrouve = metier.findById(idToFind);
                    if (produitTrouve != null) {
                        System.out.println(produitTrouve);
                    } else {
                        System.out.println("Produit non trouvé.");
                    }
                    break;
                case 5:
                    System.out.print("Entrez l'ID du produit à supprimer: ");
                    long idToDelete = scanner.nextLong();
                    metier.delete(idToDelete);
                    System.out.println("Produit supprimé (s'il existait).");
                    break;
                case 6:
                    running = false;
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            } }
        scanner.close();
    }
}
