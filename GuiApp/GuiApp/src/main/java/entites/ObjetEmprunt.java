package entites;

public class ObjetEmprunt {
    private String titre;
    private String auteur;
    private TypeObjetEmprunt type;
    private int id;
    private String description;
    private boolean estEmprunte;

    public ObjetEmprunt(String titre, String auteur, TypeObjetEmprunt type, int id, String description, boolean estEmprunte) {
        this.titre = titre;
        this.auteur = auteur;
        this.type = type;
        this.id = id;
        this.description = description;
        this.estEmprunte = estEmprunte;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public TypeObjetEmprunt getType() {
        return type;
    }

    public void setType(TypeObjetEmprunt type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEstEmprunte() {
        return this.estEmprunte;
    }

    public void setEstEmprunte(boolean estEmprunte) {
        this.estEmprunte = estEmprunte;
    }


    @Override
    public String toString() {
        return "ID: " + id + ", Titre: " + titre + ", Auteur: " + auteur + ", Type: "
         + type + ", Est emprunté?: " + (estEmprunte ? "oui" : "non");
    }
}
