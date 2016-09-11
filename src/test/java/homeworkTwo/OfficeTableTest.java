package homeworkTwo;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class OfficeTableTest {

    private OfficeTable officeTableOne = new OfficeTable();
    private Liner liner = new Liner();
    private PaperPack paperPack = new PaperPack();
    private Pen pen = new Pen();
    private Pencil pencil = new Pencil();

    @Before
    public void setPrice() {
        liner.setPrice(10);
        paperPack.setPrice(100);
        pen.setPrice(25);
        pencil.setPrice(20);
    }

    @Test
    public void priceOfficeTableKit() throws Exception {

        officeTableOne.makeOfficeTableKit(liner);
        officeTableOne.makeOfficeTableKit(pen);
        officeTableOne.makeOfficeTableKit(pencil);
        officeTableOne.makeOfficeTableKit(paperPack);

        int actualPrice = officeTableOne.countPrice();
        int expectedPrice = 155;
        assertEquals(expectedPrice, actualPrice);

    }

    @Before
    public void setName() {
        liner.setName("Линейка");
        pen.setName("Ручка");
        pencil.setName("Карандаш");
        paperPack.setName("Бумага");
    }

    @Test
    public void correctCompare() throws Exception {
        Comparator<Stationery> stationeryComparator = new StationeryPriceCompare().thenComparing(new StationeryNameCompare());
        officeTableOne.makeOfficeTableKit(liner);
        officeTableOne.makeOfficeTableKit(pen);
        officeTableOne.makeOfficeTableKit(pencil);
        officeTableOne.makeOfficeTableKit(paperPack);

        ArrayList<Stationery> actualKit = officeTableOne.getOfficeStationaryKit();
        Collections.sort(actualKit, stationeryComparator);

        int[] expectedPrice = new int[]{10, 20, 25, 100};
        String[] expcetedName = new String[]{"Линейка", "Карандаш", "Ручка", "Бумага"};

        for (int i = 0; i < actualKit.size(); i++) {
            assertEquals(expectedPrice[i], actualKit.get(i).getPrice());
            assertEquals(expcetedName[i], actualKit.get(i).getName());
        }
    }
}