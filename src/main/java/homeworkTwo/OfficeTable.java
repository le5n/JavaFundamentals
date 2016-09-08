package homeworkTwo;

public class OfficeTable {
    Stationery[] tableKit;
    Liner liner = new Liner();
    PaperPack paperPack = new PaperPack();
    Pen pen = new Pen();
    Pencil pencil = new Pencil();



    public Stationery[] makeKit() {
        return tableKit = new Stationery[]{liner, paperPack, pen, pencil};
    }

    int kitPrice(Stationery [] kit) {
        int fullPrice = 0;
        for (int i = 0; i < kit.length; i++) {
            fullPrice = fullPrice + kit[i].getPrice();
        }

        return fullPrice;
    }
}
