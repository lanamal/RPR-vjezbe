package ba.unsa.etf.rpr;
import java.io.Serializable;

public class Laptop implements Serializable {
    private String brend, model, procesor, grafickaKartica, velicinaEkrana;
    private double cijena;
    private int ram, hdd, ssd;

    public Laptop() {}
    public Laptop(String brend, String model, String procesor, String grafickaKartica, String velicinaEkrana, double cijena, int ram, int hdd, int ssd) {
        this.brend = brend;
        this.model = model;
        this.procesor = procesor;
        this.grafickaKartica = grafickaKartica;
        this.velicinaEkrana = velicinaEkrana;
        this.cijena = cijena;
        this.ram = ram;
        this.hdd = hdd;
        this.ssd = ssd;
    }
    public void setBrend(String brend) {
        this.brend = brend;
    }
    public String getBrend() { return brend; }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getProcesor() {
        return procesor;
    }
    public void setProcesor(String procesor) { this.procesor = procesor; }
    public String getGrafickaKartica() {
        return grafickaKartica;
    }
    public void setGrafickaKartica(String grafickaKartica) {
        this.grafickaKartica = grafickaKartica;
    }
    public String getVelicinaEkrana() {
        return velicinaEkrana;
    }
    public void setVelicinaEkrana(String velicinaEkrana) {
        this.velicinaEkrana = velicinaEkrana;
    }
    public double getCijena() {
        return cijena;
    }
    public void setCijena(double cijena) {
        this.cijena = cijena;
    }
    public int getRam() {
        return ram;
    }
    public void setRam(int ram) {
        this.ram = ram;
    }
    public int getHdd() {
        return hdd;
    }
    public void setHdd(int hdd) {
        this.hdd = hdd;
    }
    public int getSsd() {
        return ssd;
    }
    public void setSsd(int ssd) {
        this.ssd = ssd;
    }
    @Override
    public String toString() {
        return "Laptop{" +
                "brend='" + brend + '\'' +
                ", model='" + model + '\'' +
                ", procesor='" + procesor + '\'' +
                ", grafickaKartica='" + grafickaKartica + '\'' +
                ", velicinaEkrana='" + velicinaEkrana + '\'' +
                ", cijena=" + cijena +
                ", ram=" + ram +
                ", hdd=" + hdd +
                ", ssd=" + ssd +
                '}';
    }
}
