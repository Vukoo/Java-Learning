package gadek.com;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.IntStream.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Kata {
    public static void main(String[] args) {
        solve2(new int[]{3,4,4,3,6,3});
    }

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
    public static int [] solve(int [] arr){
        return Arrays.stream(arr).distinct().toArray();
    }
    public static int [] solve2(int [] arr){
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < arr.length ; i++) {
            int temp = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if(temp == arr[j]){
                    break;
                } else if(arr.length == j+1){
                    arrayList.add(temp);
                }
            }
        }
        arrayList.add(arr[arr.length-1]);

        int[] array = arrayList.stream().mapToInt(i->i).toArray();
        return array;
    }
    public static int[] solve3(int[] arr) {
        LinkedList<Integer> unique = new LinkedList<Integer>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!unique.contains(arr[i])) {
                unique.addFirst(arr[i]);
            }
        }
        return unique.stream().mapToInt(i -> i).toArray();
    }

    public static boolean validParentheses(String parens)
    {
        List<Character> leftChar = new ArrayList<>();
        List<Character> rightChar = new ArrayList<>();
        char left = ')';
        char right = '(';
        for (char sign: parens.toCharArray()) {
            if(sign == left){
                leftChar.add(sign);
            } else if(sign == right){
                if(leftChar.size() > rightChar.size()){
                    return false;
                }
                rightChar.add(right);
            }
        }
        if(rightChar.size() == leftChar.size() || (rightChar.isEmpty() && leftChar.isEmpty())){
            return true;
        } else {
            return false;
        }
    }

    @Test
    public void sampleTest() {
        // assertEquals("expected", "actual");
        assertEquals(true,validParentheses( "()" ));
        assertEquals(false,validParentheses( "())" ));
        assertEquals(true,validParentheses( "32423(sgsdg)" ));
        assertEquals(false,validParentheses( "(dsgdsg))2432" ));
        assertEquals(true,validParentheses( "adasdasfa" ));
        assertEquals(false,validParentheses( ")(" ));
        assertEquals(true,validParentheses( "" ));
    }

    public static String reverseWords(String str) {
        StringBuilder buffer = new StringBuilder();
        String[] split = str.split(" ");
        Stream.of(split)
                .collect(Collectors.toCollection(ArrayDeque::new))
                .descendingIterator().forEachRemaining(word -> {
            buffer.append(word);
            buffer.append(" ");

        });
        return buffer.substring(0,buffer.length()-1);
    }
    public static String reverseWordsCollection(String str){
        //write your code here...
        List Words = Arrays.asList(str.split(" "));
        Collections.reverse(Words);
        return String.join(" ", Words);
    }

    static IntStream revRange(int from, int to) {
        return IntStream.range(from, to)
                .map(i -> to - i + from - 1);
    }
    @Test
    public void testSomething() {
        assertEquals("eating like I", reverseWords("I like eating"));
        assertEquals("flying like I", reverseWords("I like flying"));
        assertEquals("nice is world The", reverseWords("The world is nice"));
    }
}
