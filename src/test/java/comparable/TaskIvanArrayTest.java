package comparable;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class TaskIvanArrayTest {

    @Test
    void testBasicCase() {
        List<Double> input = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        assertEquals(6.0, TaskIvanArray.foundMaxSum(input));
    }

    @Test
    void testNegativeNumbers() {
        List<Double> input = Arrays.asList(-5.0, 2.0, -3.0, 7.0, 1.0);
        assertEquals(9.0, TaskIvanArray.foundMaxSum(input));
    }

    @Test
    void testEvenNumberOfElements() {
        List<Double> input = Arrays.asList(3.0, 1.0, 7.0, 9.0, 4.0, 2.0);
        assertEquals(16.0, TaskIvanArray.foundMaxSum(input));
    }

    @Test
    void testSameElements() {
        List<Double> input = Arrays.asList(5.0, 5.0, 5.0, 5.0, 5.0);
        assertEquals(10.0, TaskIvanArray.foundMaxSum(input));
    }

    @Test
    void testTwoElements() {
        List<Double> input = Arrays.asList(100.0, 200.0);
        assertEquals(300.0, TaskIvanArray.foundMaxSum(input));
    }

    @Test
    void testLargeNumbers() {
        List<Double> input = Arrays.asList(1000000.0, 2000000.0, 3000000.0, 4000000.0, 5000000.0);
        assertEquals(6000000.0, TaskIvanArray.foundMaxSum(input));
    }

    @Test
    void testFractionalNumbers() {
        List<Double> input = Arrays.asList(1.5, 2.7, 3.2, 4.1, 5.9);
        assertEquals(7.4, TaskIvanArray.foundMaxSum(input), 0.0001);
    }
    @Test
    void testEmptyArray(){
        List<Double>input=new ArrayList<>();
        assertEquals(0,TaskIvanArray.foundMaxSum(input));
    }

    @org.junit.jupiter.api.Test
    void foundMaxSum() {
    }
}