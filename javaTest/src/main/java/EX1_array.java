import java.util.*;
import java.util.stream.Collectors;

public class EX1_array {
    public static void main(String[] args) {
        ArrayList<String> testList = new ArrayList<>(Arrays.asList("Apple","Banana","Melon","Grape","Strawberry"));


        System.out.println(testList);

        //testList.stream().map(s->s.toLowerCase());
        testList.stream().map(String::toUpperCase);


        System.out.println(testList.stream().map(s->s.toUpperCase()).collect(Collectors.joining(" "))); //APPLE BANANA MELON GRAPE STRAWBERRY

        System.out.println(testList.stream().map(s->s.toUpperCase()).collect(Collectors.toList())); //[APPLE, BANANA, MELON, GRAPE, STRAWBERRY]
        System.out.println(testList.stream().map(String::toUpperCase).collect(Collectors.toList())); //[APPLE, BANANA, MELON, GRAPE, STRAWBERRY]

        testList.stream().map(String::toUpperCase).forEach(s -> System.out.println(s));

    }

}
