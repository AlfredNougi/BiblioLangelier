package entites;

import java.util.ArrayList;

public class Bibliotheque {
    private String nom;
    private String numeroTel;
    private String adresse;
    private String lienGoogleMaps;
    private String heuresOuverture;
    private ArrayList<ObjetEmprunt> listeObjetsEmprunt;
    // private ArrayList<Abonne> listeClients;

    public Bibliotheque(String nom, String numeroTel, String adresse, String lienGoogleMaps, String heuresOuverture) {
        this.nom = nom;
        this.numeroTel = numeroTel;
        this.adresse = adresse;
        this.lienGoogleMaps = lienGoogleMaps;
        this.heuresOuverture = heuresOuverture;
        this.listeObjetsEmprunt = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getLienGoogleMaps() {
        return lienGoogleMaps;
    }

    public void setLienGoogleMaps(String lienGoogleMaps) {
        this.lienGoogleMaps = lienGoogleMaps;
    }


    public String getHeuresOuverture() {
        return this.heuresOuverture;
    }

    public void setHeuresOuverture(String heuresOuverture) {
        this.heuresOuverture = heuresOuverture;
    }


    public ArrayList<ObjetEmprunt> getListeObjetsEmprunt() {
        return listeObjetsEmprunt;
    }

    public void setListeObjetsEmprunt(ArrayList<ObjetEmprunt> listeObjetsEmprunt) {
        this.listeObjetsEmprunt = listeObjetsEmprunt;
    }

}
