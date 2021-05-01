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

        User humanCaterpillar = userList.stream().reduce(new User("head","tail",0), JavaStreamMain::addUser);
        assertEquals(humanCaterpillar.getName(), "headPeterJohn");
        benchmarkParaller();
        benchmarkWithoutParaller();

    }

    public static User addUser(User humanCaterpillar, User user){
        humanCaterpillar.setAge(sum(0, user));
        humanCaterpillar.setName(humanCaterpillar.getName() + user.getName());
        humanCaterpillar.setSurname(humanCaterpillar.getSurname() + user.getSurname());
        return humanCaterpillar;
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
                        0, JavaStreamMain::sum, Integer::sum);
    }

    public static void benchmarkParaller()
    {
        long startTime = System.currentTimeMillis();
        final Integer integer = parallerReduceStream(generateRandomUser());
        long endTime = System.currentTimeMillis();
        System.out.println("Total benchmarkTest Parallel execution time: " + (endTime-startTime) + "ms");
    }

    public static void benchmarkWithoutParaller()
    {
        long startTime = System.currentTimeMillis();
        final Integer reduce = generateRandomUser().stream().reduce(0, JavaStreamMain::sum, Integer::sum);
        long endTime = System.currentTimeMillis();
        System.out.println("Total benchmarkTest2 execution time: " + (endTime-startTime) + "ms");
    }

    public static List<User> generateRandomUser(){
        List<User> userList = new ArrayList<>();
        for (int i = 0; i <100000000 ; i++) {
            User user = new User("a", "sa", (int) Math.random());
            userList.add(user);
        }
        return userList;
    }
}
