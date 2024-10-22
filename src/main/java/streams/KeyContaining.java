package streams;

import java.util.Arrays;
import java.util.List;

public class KeyContaining {
    List<Integer> arrayNumber = Arrays.asList(9, 1, 7, 9, 4, 2);

public static double foundMaxSum(List<Double> num) {
    double maxSum = 0;
    for (int k = 0; k < num.size()/2; k++) {
        double sum = num.get(k) + num.get(num.size() - 1 - k);
        if (sum > maxSum) {
            maxSum = sum;
        }
    }
    return maxSum;
}
}
