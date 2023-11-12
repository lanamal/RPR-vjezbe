package ba.unsa.etf.rpr;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class LaptopDaoJSONFile implements LaptopDao {
    private File file;
    private ArrayList<Laptop> laptopi;

    public LaptopDaoJSONFile(File file) {
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
            ObjectMapper objectMapper = new ObjectMapper();
            laptopi.add(laptop);
            objectMapper.writeValue(file, laptopi);
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
            ObjectMapper objectMapper = new ObjectMapper();
            laptopi = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Laptop.class));
            return laptopi;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
