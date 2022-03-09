package Entity;

import java.sql.Date;

public class coach {
    private int idcoach;
    private String nomprenom;
    private String email;

    private Date dob;
    private String image;


    @Override
    public String toString() {
        return "coach{" +
                "idcoach=" + idcoach +
                ", nomprenom='" + nomprenom + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", image='" + image + '\'' +
                '}';
    }

    public coach(int idcoach, String nom_prenom, String email, Date dob, String image) {
        this.idcoach = idcoach;
        this.nomprenom = nom_prenom;
        this.email = email;
        this.dob = dob;
        this.image = image;
    }

    public int getIdcoach() {
        return idcoach;
    }

    public void setIdcoach(int idcoach) {
        this.idcoach = idcoach;
    }

    public String getNom_prenom() {
        return nomprenom;
    }

    public void setNom_prenom(String nom_prenom) {
        this.nomprenom = nom_prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
