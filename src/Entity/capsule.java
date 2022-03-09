package Entity;

public class capsule {
    Integer id;
    String nomcapsule;
    String typecapsule;
    String longcasule;
    String programmecapsule, chemincapsule,cible,image;

    @Override
    public String toString() {
        return "capsule{" +
                "id=" + id +
                ", nomcapsule='" + nomcapsule + '\'' +
                ", typecapsule='" + typecapsule + '\'' +
                ", longcasule='" + longcasule + '\'' +
                ", programmecapsule='" + programmecapsule + '\'' +
                ", chemincapsule='" + chemincapsule + '\'' +
                ", cible='" + cible + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public capsule(Integer id, String nomcapsule, String typecapsule, String longcasule, String programmecapsule, String chemincapsule, String cible, String image) {
        this.id = id;
        this.nomcapsule = nomcapsule;
        this.typecapsule = typecapsule;
        this.longcasule = longcasule;
        this.programmecapsule = programmecapsule;
        this.chemincapsule = chemincapsule;
        this.cible = cible;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomcapsule() {
        return nomcapsule;
    }

    public void setNomcapsule(String nomcapsule) {
        this.nomcapsule = nomcapsule;
    }

    public String getTypecapsule() {
        return typecapsule;
    }

    public void setTypecapsule(String typecapsule) {
        this.typecapsule = typecapsule;
    }

    public String getLongcasule() {
        return longcasule;
    }

    public void setLongcasule(String longcasule) {
        this.longcasule = longcasule;
    }

    public String getProgrammecapsule() {
        return programmecapsule;
    }

    public void setProgrammecapsule(String programmecapsule) {
        this.programmecapsule = programmecapsule;
    }

    public String getChemincapsule() {
        return chemincapsule;
    }

    public void setChemincapsule(String chemincapsule) {
        this.chemincapsule = chemincapsule;
    }

    public String getCible() {
        return cible;
    }

    public void setCible(String cible) {
        this.cible = cible;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
