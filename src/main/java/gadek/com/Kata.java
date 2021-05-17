package gadek.com;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Kata {


    //	You will be given an array and a limit value. You must check that all values in the array are below or equal to the limit value. If they are, return true. Else, return false.
    public static boolean smallEnough(int[] a, int limit)
    {
        return Arrays.stream(a).noneMatch(s -> s > limit);
    }
        public static int largestPairSum(int[] numbers){
            IntStream sorted1 = Arrays.stream(numbers).map(i -> -i).sorted().map(i -> -i);
            int sum = sorted1.limit(2).sum();
            return sum;
    }

    @Test
    public void basicTests() {
        assertEquals(true, Kata.smallEnough(new int[] { 66, 101 }, 200));
        assertEquals(false, Kata.smallEnough(new int[] { 78, 117, 110, 99, 104, 117, 107, 115 }, 100));
        assertEquals(true, Kata.smallEnough(new int[] { 101, 45, 75, 105, 99, 107 }, 107));
        assertEquals(true, Kata.smallEnough(new int[] { 80, 117, 115, 104, 45, 85, 112, 115 }, 120));
    }

    public static String camelCase(String input) {
        String result = "";
        for (char ch: input.toCharArray()) {
            if (Character.isUpperCase(ch)){
                result = " " + ch;
            } else {
                result += ch;
            }
        }
        return result;
//        retur input.replaceAll("([A-Z])", " $1");
    }


}
