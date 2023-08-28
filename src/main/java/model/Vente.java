package model;

public class Vente {
    private int id;
    private String nom ;
    private String dateDebutVente ;
    private CategVente CategVente ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDateDebutVente() {
        return dateDebutVente;
    }

    public void setDateDebutVente(String dateDebutVente) {
        this.dateDebutVente = dateDebutVente;
    }

    public model.CategVente getCategVente() {
        return CategVente;
    }

    public void setCategVente(model.CategVente categVente) {
        CategVente = categVente;
    }
}
