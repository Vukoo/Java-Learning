package gadek.com.stream;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class JavaStreamMain {

    public static void main(String[] args){
        List<Integer> integerList = Arrays.asList(1,5,4,32,11,44233);
        Integer totalSum = integerList.stream().reduce(0, Integer::sum);
        assertNotEquals(totalSum,21);

        List<String> stringList = Arrays.asList("hej", " jak " , "sie " , "masz?");
        String resultString = stringList.stream().reduce("", String::concat);

        assertEquals(resultString, "hej jak sie masz?");
        assertThrows(NullPointerException.class,() -> stringList.stream().reduce(null,String::concat));

        List<User> userList = Arrays.asList(new User("Peter","Coding", 123), new User("John","Wick", null) );
        Integer userAgeSum = userList.stream().reduce(0, JavaStreamMain::sum, Integer::sum);
        final Integer integer = parallerReduceStream(userList);
    }

    private static Integer sum(Integer partialAge, User user) {
        try{
            return partialAge + user.getAge();
        } catch (NullPointerException e){
            return partialAge;
        }
    }

    public static Integer parallerReduceStream(List<User> userList ) {
        return userList
                .parallelStream()
                .reduce(
                        0, (partialAgeResult, user) -> partialAgeResult + user.getAge(), Integer::sum);
    }
}
