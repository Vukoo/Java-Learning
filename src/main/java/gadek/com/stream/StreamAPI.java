package gadek.com.stream;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPI {


    public void exampleMethod(){
        List<String> list = Arrays.asList("1", " 2 " , "3 " , "4?");
        list.add("One");
        list.add("OneAndOnly");
        list.add("Derek");
        list.add("Change");
        list.add("factory");
        list.add("justBefore");
        list.add("Italy");
        list.add("Italy");
        list.add("Thursday");
        list.add("");
        list.add("");
        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> stream = Arrays.stream(arr);
        stream = Stream.of("a", "b", "c");
//        paraller
//        list.parallelStream().forEach(element -> element);
//        count
        long count = list.stream().distinct().count();
//        matchers
        boolean isValid = list.stream().anyMatch(element -> element.contains("h"));
        boolean isValidOne = list.stream().allMatch(element -> element.contains("h"));
        boolean isValidTwo = list.stream().noneMatch(element -> element.contains("h"));
        final boolean b = Stream.empty().allMatch(Objects::nonNull);// true
        final boolean b1 = Stream.empty().anyMatch(Objects::nonNull);// false
//        filter
        Stream<String> filterStream = list.stream().filter(element -> element.contains("d"));
//        map  // flatMap
        Stream<Path> streamMap = list.stream().map(Paths::get);
//      reduction
        final String reduce = list.stream().reduce("", (result, element) -> result = result + element);
//        collecting
        List<String> resultList
                = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        LocalDate local = LocalDate.now();
        Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
//      Java 9:  takeWhile
        Stream.of(1,2,3,4,5,6)
                .takeWhile(i -> i < 4 )
                .forEach(System.out::println);
//        dropWhile
        Stream.of(1,2,3,4,5)
                .dropWhile(x -> x < 4)
                .forEach(System.out::println);
//      iterate
        IntStream.iterate(2, x -> x < 20, x -> x * x)
                .forEach(System.out::println);

//        collection

    }


    public void testflatMap() throws Exception {
        final Stream<List<Integer>> listStream = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4));
        List<Integer> together = listStream // Stream of List<Integer>
                .flatMap(List::stream)
                .map(integer -> integer + 1)
                .collect(Collectors.toList());
//        assertEquals(asList(2, 3, 4, 5), together);
    }

    public void convertStringToUpperCaseStreams() {
        List<String> collected = Stream.of("a", "b", "hello") // Stream of String
                .map(String::toUpperCase) // Returns a stream consisting of the results of applying the given function to the elements of this stream.
                .collect(Collectors.toList());
//        assertEquals(asList("A", "B", "HELLO"), collected);
    }
}
