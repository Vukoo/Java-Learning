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

        List<User> userList = Arrays.asList(new User("Peter","Coding", 123), new User("John","Wick", 11) );
        Integer userAgeSum = userList.stream().reduce(0, (partialAge, user) -> partialAge + user.getAge(), Integer::sum);
        assertEquals(userAgeSum,134);
    }
}
