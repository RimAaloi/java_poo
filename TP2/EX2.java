abstract class Employee {
    private String nom;
    private String prenom;
    private String email;
    private String tel;
    private double salaire;
    
    public Employee(String nom, String prenom, String email, String tel, double salaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
        this.salaire = salaire;
    }
    public abstract double calculerSalaire();

    public void afficher() {
        System.out.println("Nom: " + nom + ", Prénom: " + prenom + ", Email: " + email + 
                           ", Téléphone: " + tel +
                           ", Salaire: " + calculerSalaire());
    }
}

class Ingenieur extends Employee {
    public Ingenieur(String nom, String prenom, String email, String tel, double salaire) {
        super(nom, prenom, email, tel, salaire);
    }
    @Override
    public double calculerSalaire() {
        return super.calculerSalaire() * 1.15; // augmentation de 15%
    } }
class Manager extends Employee {
    private String service;
    public Manager(String nom, String prenom, String email, String tel, double salaire, String service) {
        super(nom, prenom, email, tel, salaire);
        this.service = service;
    }
    @Override
    public double calculerSalaire() {
        return super.calculerSalaire() * 1.20; // augmentation de 20%
    }
    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Service: " + service);
    } }

public class EntrepriseTest {
    public static void main(String[] args) {
        // Créer un ingénieur
        Ingenieur ingenieur = new Ingenieur("aaaa", "bbbb", "aaabbb@gmail.com", "0123456789", 3000);
        // Créer un manager
        Manager manager = new Manager("ccc", "ddd", "cccddd@gmail.com", "0987654321", 4000, "Informatique");

        System.out.println("Informations de l'Ingénieur:");
        ingenieur.afficher();
        
        System.out.println("\nInformations du Manager:");
        manager.afficher();
    }
}
