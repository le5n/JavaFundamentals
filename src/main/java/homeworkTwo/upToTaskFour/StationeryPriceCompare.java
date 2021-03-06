package homeworkTwo.upToTaskFour;

import java.util.Comparator;

class StationeryPriceCompare implements Comparator<Stationery> {
    @Override
    public int compare(Stationery priceOne, Stationery proceTwo) {
        if (priceOne.getPrice() < proceTwo.getPrice()) {
            return -1;
        }

        if (priceOne.getPrice() > proceTwo.getPrice()) {
            return +1;
        }
        return 0;
    }
}
