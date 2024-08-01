package stationery;

import java.util.Comparator;

public class TypeComparator implements Comparator<Stationery> {
    @Override
    public int compare(Stationery first, Stationery second) {
        return first.getType().compareTo(second.getType());
    }
}
