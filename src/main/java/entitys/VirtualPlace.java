package entitys;

public class VirtualPlace extends Place{
    private String linkToFie;

    public VirtualPlace(String linkToFie) {
        this.linkToFie = linkToFie;
    }

    public String getLinkToFie() {
        return linkToFie;
    }

    public void setLinkToFie(String linkToFie) {
        this.linkToFie = linkToFie;
    }

    @Override
    public String toString() {
        return "VirtualPlace{" +
                "linkToFie='" + linkToFie + '\'' +
                '}';
    }
}
