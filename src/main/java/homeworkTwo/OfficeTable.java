package homeworkTwo;

import java.util.ArrayList;
import java.util.Comparator;

class OfficeTable {
    private Liner liner;
    private PaperPack paperPack;
    private Pen pen;
    private Pencil pencil;
    Comparator<Stationery> stationeryComparator = new StationeryPriceCompare().
            thenComparing(new StationeryNameCompare());
    private ArrayList<Stationery> officeStationaryKit = new ArrayList<Stationery>();

    void makeOfficeTableKit(Stationery thing) {
        officeStationaryKit.add(thing);
    }

    ArrayList<Stationery> getOfficeStationaryKit() {
        return officeStationaryKit;
    }


    int countPrice() {
        int fullPrice = 0;
        for (Stationery anOfficeStationaryKit : officeStationaryKit) {
            fullPrice += anOfficeStationaryKit.getPrice();
        }
        return fullPrice;
    }
}
