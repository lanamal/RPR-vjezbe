package ba.unsa.etf.rpr;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class LaptopDaoXMLFile implements LaptopDao {
    private File file;
    private ArrayList<Laptop> laptopi;

    public LaptopDaoXMLFile(File file) {
        this.file = file;
        this.laptopi = new ArrayList<>();
    }
    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }
    @Override
    public void dodajLaptopUFile(Laptop laptop) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            laptopi.add(laptop);
            xmlMapper.writeValue(file, laptopi);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Laptop getLaptop(String procesor) throws NeodgovarajuciProcesorException {
        for (Laptop laptop : laptopi) {
            if (laptop.getProcesor().equals(procesor)) {
                return laptop;
            }
        }
        throw new NeodgovarajuciProcesorException("Laptop sa procesorom " + procesor + " nije pronađen.");
    }
    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {
        this.laptopi = laptopi;
    }
    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            laptopi = xmlMapper.readValue(file, xmlMapper.getTypeFactory().constructCollectionType(ArrayList.class, Laptop.class));
            return laptopi;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

