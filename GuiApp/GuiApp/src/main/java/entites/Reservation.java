package entites;
import java.util.Date;

public class Reservation {
    private String type;
    private int idArticle;
    private Date dateEtHeure;
    private int idClient;

    public Reservation(String type, int idArticle, Date dateEtHeure, int idClient) {
        this.type = type;
        this.idArticle = idArticle;
        this.dateEtHeure = dateEtHeure;
        this.idClient = idClient;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int id) {
        this.idArticle = id;
    }

    public Date getDateEtHeure() {
        return dateEtHeure;
    }

    public void setDateEtHeure(Date dateEtHeure) {
        this.dateEtHeure = dateEtHeure;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

}
    
