package ba.unsa.etf.rpr;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LaptopDaoJSONFileTest {
    private LaptopDaoJSONFile laptopDao;

    @BeforeEach
    void setUp() {
        File mockFile = mock(File.class);
        laptopDao = new LaptopDaoJSONFile(mockFile);
    }

    @Test
    void testGetLaptop() throws NeodgovarajuciProcesorException {
        Laptop laptop = new Laptop("TestBrend", "TestModel", "TestProcesor", "TestGraficka", "15.6", 999.99, 16, 512, 256);
        laptopDao.dodajLaptopUListu(laptop);

        Laptop result = laptopDao.getLaptop("TestProcesor");

        assertEquals(laptop, result);
    }
    @Test
    void testNapuniListu() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Laptop> laptopi = new ArrayList<>();
        laptopi.add(new Laptop("Dell", "Inspiron", "Intel i5", "Nvidia GTX 1650", "15.6", 800.0, 8, 1000, 256));
        laptopi.add(new Laptop("HP", "Pavilion", "AMD Ryzen 7", "AMD Radeon RX 5500M", "17.3", 1200.0, 16, 512, 0));

        Field field = LaptopDaoJSONFile.class.getDeclaredField("laptopi");
        field.setAccessible(true);
        field.set(laptopDao, laptopi);

        assertEquals(laptopi, field.get(laptopDao));
    }
    @Test
    void getLaptopWithNonExistingProcesor() throws NeodgovarajuciProcesorException {
        LaptopDaoJSONFile laptopDaoMock = mock(LaptopDaoJSONFile.class);

        when(laptopDaoMock.getLaptop("Non-existing procesor")).thenThrow(new NeodgovarajuciProcesorException("Laptop sa procesorom Non-existing procesor nije pronadjen."));

        assertThrows(NeodgovarajuciProcesorException.class, () -> laptopDaoMock.getLaptop("Non-existing procesor"));
    }
    @Test
    void testDodajLaptopUListu() throws NoSuchFieldException, IllegalAccessException {
        Laptop laptop = new Laptop("Acer", "Predator", "Intel i9", "Nvidia RTX 3080", "17.3", 2500.0, 32, 2000, 1);

        laptopDao.dodajLaptopUListu(laptop);

        Field field = LaptopDaoJSONFile.class.getDeclaredField("laptopi");
        field.setAccessible(true);

        @SuppressWarnings("unchecked")
        ArrayList<Laptop> result = (ArrayList<Laptop>) field.get(laptopDao);

        assertTrue(result.contains(laptop));
    }
    @Test
    void testDodajLaptopUFile() throws IOException {
        File tempFile = File.createTempFile("testFile", ".json");
        LaptopDaoJSONFile laptopDao = new LaptopDaoJSONFile(tempFile);
        Laptop expectedLaptop = new Laptop("null", "IdeaPad", "AMD Ryzen 5", "Integrated Graphics", "14.0", 600.0, 8, 512, 0);

        laptopDao.dodajLaptopUFile(expectedLaptop);

        ArrayList<Laptop> laptopsFromFile = laptopDao.vratiPodatkeIzDatoteke();
        assertEquals(1, laptopsFromFile.size());

        Laptop actualLaptop = laptopsFromFile.get(0);
        assertEquals(expectedLaptop.getBrend(), actualLaptop.getBrend());
        assertEquals(expectedLaptop.getModel(), actualLaptop.getModel());
        assertEquals(expectedLaptop.getProcesor(), actualLaptop.getProcesor());
        assertEquals(expectedLaptop.getGrafickaKartica(), actualLaptop.getGrafickaKartica());
        assertEquals(expectedLaptop.getVelicinaEkrana(), actualLaptop.getVelicinaEkrana());
        assertEquals(expectedLaptop.getCijena(), actualLaptop.getCijena());
        assertEquals(expectedLaptop.getRam(), actualLaptop.getRam());
        assertEquals(expectedLaptop.getHdd(), actualLaptop.getHdd());
        assertEquals(expectedLaptop.getSsd(), actualLaptop.getSsd());
    }
}