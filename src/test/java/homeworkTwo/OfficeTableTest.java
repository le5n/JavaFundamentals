package homeworkTwo;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class OfficeTableTest {

    OfficeTable officeTableOne = new OfficeTable();
    Liner liner = new Liner();
    PaperPack paperPack = new PaperPack();
    Pen pen = new Pen();
    Pencil pencil = new Pencil();

    @Test
    public void makeOfficeTableSet() {

        Stationery [] expectedKit = new Stationery[] {liner, paperPack, pencil, pen};
        String [] expectedClasses = new String[expectedKit.length];

        officeTableOne.makeKit();
        Stationery [] actualKit = officeTableOne.getTableKit();
        String [] actualClasses = new String[actualKit.length];

        for (int i = 0; i < expectedKit.length; i++) {
            expectedClasses[i] = expectedKit[i].getClass().toString();
        }

        for (int i = 0; i < actualKit.length; i++) {
            actualClasses[i] = actualKit[i].getClass().toString();
        }

        Arrays.sort(expectedClasses);
        Arrays.sort(actualClasses);

        assertArrayEquals(expectedClasses,actualClasses);

    }

    @Test
    public void getKitFullPrice(){
        pen.setPrice(25);
        pencil.setPrice(15);
        liner.setPrice(10);
        paperPack.setPrice(100);

        int [] prices = new int [] {pen.getPrice(), pencil.getPrice(), liner.getPrice(), paperPack.getPrice()};
        int expectedPrice = 0;

        for (int price : prices) {
            expectedPrice += price;
        }
       Stationery [] actualKit  = officeTableOne.getTableKit();
        officeTableOne.makeKit();
        int actualPrice = officeTableOne.kitPrice(actualKit);

        assertEquals(expectedPrice, actualPrice);

    }
}