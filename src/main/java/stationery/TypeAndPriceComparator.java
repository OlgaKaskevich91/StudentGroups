package stationery;

import java.util.Comparator;

public class TypeAndPriceComparator implements Comparator<Stationery> {
    @Override
    public int compare(Stationery first, Stationery second) {
        int result = first.getType().compareTo(second.getType());
        if (result == 0) {
            return Double.compare(first.getPrice(), second.getPrice());
        } else {
            return result;
        }
    }
}
