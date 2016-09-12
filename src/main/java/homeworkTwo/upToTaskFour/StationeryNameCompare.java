package homeworkTwo.upToTaskFour;

import java.util.Comparator;

class StationeryNameCompare implements Comparator<Stationery> {
    @Override
    public int compare(Stationery nameOne, Stationery nameTwo) {
        return nameOne.getName().compareTo(nameTwo.getName());
    }
}
