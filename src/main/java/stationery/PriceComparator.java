package stationery;

import java.util.Comparator;

public class PriceComparator implements Comparator<Stationery> {
    @Override
    public int compare(Stationery first, Stationery second) {
        return Double.compare(first.getPrice(), second.getPrice());
    }
}
