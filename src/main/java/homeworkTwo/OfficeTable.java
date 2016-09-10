package homeworkTwo;

public class OfficeTable {
    private Liner liner;
    private PaperPack paperPack;
    private Pen pen;
    private Pencil pencil;
    private Stationery[] stationeries;

    public OfficeTable() {
        liner = new Liner();
        paperPack = new PaperPack();
        pen = new Pen();
        pencil = new Pencil();
    }

    public Stationery[] makeKit() {
        initKitPrices();
        stationeries = new Stationery[]{liner, paperPack, pen, pencil};
        return stationeries;
    }

    public Stationery[] getStationeries() {
        return stationeries;
    }

    private void initKitPrices() {
        pen.setPrice(25);
        pencil.setPrice(15);
        liner.setPrice(10);
        paperPack.setPrice(100);
    }

    int kitPrice(Stationery [] kit) {
        int fullPrice = 0;
        for (Stationery aKit : kit) {
            fullPrice = fullPrice + aKit.getPrice();
        }

        return fullPrice;
    }
}
