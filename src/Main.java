package models;

import java.util.Date;

public class Professeur {
    private int idProfesseur;
    private String nom;
    private String prenom;
    private String cin;
    private String adresse;
    private String telephone;
    private String email;
    private Date dateRecrutement;
    private Departement departement;

    // Constructeur
    public Professeur(int idProfesseur, String nom, String prenom, String cin, String adresse,
                      String telephone, String email, Date dateRecrutement, Departement departement) {
        this.idProfesseur = idProfesseur;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
        this.dateRecrutement = dateRecrutement;
        this.departement = departement;
    }

    // Getters et setters
    public int getIdProfesseur() { return idProfesseur; }
    public void setIdProfesseur(int idProfesseur) { this.idProfesseur = idProfesseur; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public String getCin() { return cin; }
    public void setCin(String cin) { this.cin = cin; }
    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Date getDateRecrutement() { return dateRecrutement; }
    public void setDateRecrutement(Date dateRecrutement) { this.dateRecrutement = dateRecrutement; }
    public Departement getDepartement() { return departement; }
    public void setDepartement(Departement departement) { this.departement = departement; }
}
