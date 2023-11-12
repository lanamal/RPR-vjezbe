package ba.unsa.etf.rpr;
import java.io.*;
import java.util.ArrayList;
import ba.unsa.etf.rpr.*;

public class Main {
    public static void main(String[] args) {
        // Testiranje LaptopDaoSerializableFile
        LaptopDaoSerializableFile daoSerializableFile = new LaptopDaoSerializableFile(new File("laptopi.txt"));
        testirajDao(daoSerializableFile);

        // Testiranje LaptopDaoJSONFile
        LaptopDaoJSONFile daoJSONFile = new LaptopDaoJSONFile(new File("laptopi.json"));
        testirajDao(daoJSONFile);

        // Testiranje LaptopDaoXMLFile
        LaptopDaoXMLFile daoXMLFile = new LaptopDaoXMLFile(new File("laptopi.xml"));
        testirajDao(daoXMLFile);
    }
    private static void testirajDao(LaptopDao dao) {
        ArrayList<Laptop> laptopi = new ArrayList<>();
        laptopi.add(new Laptop("Dell", "Inspiron", "Intel i5", "Nvidia GTX 1650", "15.6", 800.0, 8, 1000, 256));
        laptopi.add(new Laptop("HP", "Pavilion", "AMD Ryzen 7", "AMD Radeon RX 5500M", "17.3", 1200.0, 16, 512, 0));

        dao.napuniListu(laptopi);

        // Dodaj laptop u file
        dao.dodajLaptopUFile(new Laptop("Lenovo", "ThinkPad", "Intel i7", "Nvidia Quadro", "14.0", 1500.0, 16, 512, 0));

        // Ucitaj podatke iz file-a
        ArrayList<Laptop> ucitaniLaptopi = dao.vratiPodatkeIzDatoteke();
        System.out.println("Ucitani laptopi: " + ucitaniLaptopi);

        try {
            // Pretrazi laptop po procesoru
            Laptop trazeniLaptop = dao.getLaptop("Intel i5");
            System.out.println("Pronadjeni laptop: " + trazeniLaptop);
        } catch (NeodgovarajuciProcesorException e) {
            System.out.println(e.getMessage());
        }
    }
}
