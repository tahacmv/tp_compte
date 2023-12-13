package org.example;

public class Compte {

    // Attributs
    private int numeroCompte;
    private String nomTitulaire;
    private String prenomTitulaire;
    private String adresseTitulaire;
    private double solde;
    private double decouvertMaximalAutorise;
    private double debitMaximalAutorise;

    // Variable de classe
    private static final double DECOUVERT_DEFAUT = 800.0;
    private static final double DEBIT_DEFAUT = 1000.0;

    public Compte(int numeroCompte, String nomTitulaire, String prenomTitulaire, String adresseTitulaire, double solde, double decouvertMaximalAutorise, double debitMaximalAutorise) {
        this.numeroCompte = numeroCompte;
        this.nomTitulaire = nomTitulaire;
        this.prenomTitulaire = prenomTitulaire;
        this.adresseTitulaire = adresseTitulaire;
        this.solde = solde;
        this.decouvertMaximalAutorise = decouvertMaximalAutorise;
        this.debitMaximalAutorise = debitMaximalAutorise;
    }


    public void crediter(double montant) {
        if (montant > 0) {
            this.solde += montant;
            System.out.println("Crédit de " + montant + "€ effectué. Nouveau solde : " + this.solde + "€");
        } else {
            System.out.println("Le montant à créditer doit être positif.");
        }
    }

    public void debiter(double montant) {
        if (montant > 0) {
            double nouveauSolde = this.solde - montant;
            if (nouveauSolde >= -this.decouvertMaximalAutorise) {
                this.solde = nouveauSolde;
                System.out.println("Débit de " + montant + "€ effectué. Nouveau solde : " + this.solde + "€");
            } else {
                System.out.println("Opération impossible. Solde insuffisant.");
            }
        } else {
            System.out.println("Le montant à débiter doit être positif.");
        }
    }

    public void virement(Compte compteBeneficiaire, double montant) {
        if (montant > 0) {
            if (this.solde - montant >= -this.decouvertMaximalAutorise) {
                this.debiter(montant);
                compteBeneficiaire.crediter(montant);
                System.out.println("Virement de " + montant + "€ effectué vers le compte " + destinataire.numeroCompte);
            } else {
                System.out.println("Opération impossible. Solde insuffisant pour effectuer le virement.");
            }
        } else {
            System.out.println("Le montant du virement doit être positif.");
        }
    }


    public String consulterInformations() {
        String etatCompte = "Numéro de compte : " + this.numeroCompte +
                "\nTitulaire : " + this.prenomTitulaire + " " + this.nomTitulaire +
                "\nAdresse : " + this.adresseTitulaire +
                "\nSolde : " + this.solde + "€" +
                "\nDécouvert maximal autorisé : " + this.decouvertMaximalAutorise + "€" +
                "\nDébit maximal autorisé : " + this.debitMaximalAutorise + "€" +
                "\nSituation du compte : " + (this.solde < 0 ? "À découvert" : "À jour");

        return etatCompte;
    }

}
