package homeworkTwo;

class OfficeTable {
    private Stationery[] tableKit;
    Liner liner = new Liner();
    PaperPack paperPack = new PaperPack();
    Pen pen = new Pen();
    Pencil pencil = new Pencil();

    void makeKit() {
        tableKit = new Stationery[]{liner, paperPack, pen, pencil};
    }

    public Stationery[] getTableKit() {
        return tableKit.clone();
    }

    int kitPrice(Stationery[] kit) {
        int fullPrice = 0;
        for (Stationery aKit : kit) {
            fullPrice = fullPrice + aKit.getPrice();
        }

        return fullPrice;
    }
}
