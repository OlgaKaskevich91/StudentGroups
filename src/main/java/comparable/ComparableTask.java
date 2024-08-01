package comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableTask {
    public static void main(String[] args) {
        List<String>list=new ArrayList<>();
        list.add("Olga");
        list.add("Ivan");
        list.add("Denis");
        list.add("Bob");
        System.out.println("Before sort");
        System.out.println(list);
        Collections.sort(list);
        System.out.println("After sort");
        System.out.println(list);
    }
}
