package ba.unsa.etf.rpr;
import java.io.*;
import java.util.ArrayList;

public class LaptopDaoSerializableFile implements LaptopDao {
    private File file;
    private ArrayList<Laptop> laptopi;

    public LaptopDaoSerializableFile(File file) {
        this.file = file;
        this.laptopi = new ArrayList<>();
    }
    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }
    @Override
    public void dodajLaptopUFile(Laptop laptop) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            laptopi.add(laptop);
            outputStream.writeObject(laptopi);
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
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
            laptopi = (ArrayList<Laptop>) inputStream.readObject();
            return laptopi;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
