package entites;

public class Abonne {
    private int id;
    private String prenom;
    private String nom;
    private String email;
    private String phone;
    private String adress;

    public Abonne(int id, String firstName, String lastName, String email, String phone, String adress) {
        this.id = id;
        this.prenom = firstName;
        this.nom = lastName;
        this.email = email;
        this.adress=adress;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String firstName) {
        this.prenom = firstName;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String lastName) {
        this.nom = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return this.adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

}