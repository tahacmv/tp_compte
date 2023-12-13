package org.example;

import java.util.List;

public class Titulaire {
    private String nomTitulaire;
    private String prenomTitulaire;
    private String adresseTitulaire;

    private List<Compte> comptes; // Ajout de la liste de comptes

    public Titulaire(String nomTitulaire, String prenomTitulaire, String adresseTitulaire) {
        this.nomTitulaire = nomTitulaire;
        this.prenomTitulaire = prenomTitulaire;
        this.adresseTitulaire = adresseTitulaire;
    }

    public String getNomTitulaire() {
        return nomTitulaire;
    }

    public void setNomTitulaire(String nomTitulaire) {
        this.nomTitulaire = nomTitulaire;
    }

    public String getPrenomTitulaire() {
        return prenomTitulaire;
    }

    public void setPrenomTitulaire(String prenomTitulaire) {
        this.prenomTitulaire = prenomTitulaire;
    }

    public String getAdresseTitulaire() {
        return adresseTitulaire;
    }

    public void setAdresseTitulaire(String adresseTitulaire) {
        this.adresseTitulaire = adresseTitulaire;
    }
}
