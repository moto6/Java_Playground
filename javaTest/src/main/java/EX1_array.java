import java.util.*;
import java.util.stream.Collectors;

public class EX1_array {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Apple","Banana","Melon","Grape","Strawberry"));

        System.out.print("Original : ");
        System.out.println(list + "\n\n");

        ex_map(list);
        ex_filter(list);


    }

    public static void ex_map(ArrayList<String> testList) {
        System.out.println("ex_map");

        System.out.print("stream().map().joining() : ");
        System.out.println(testList.stream().map(s->s.toUpperCase()).collect(Collectors.joining(" "))); //APPLE BANANA MELON GRAPE STRAWBERRY
        System.out.print("\n");


        System.out.print("stream().map().toList() : ");
        System.out.println(testList.stream().map(s->s.toUpperCase()).collect(Collectors.toList())); //[APPLE, BANANA, MELON, GRAPE, STRAWBERRY]
        System.out.print("\n");

        System.out.print("Original : String::toUpperCase");
        System.out.println(testList.stream().map(String::toUpperCase).collect(Collectors.toList())); //[APPLE, BANANA, MELON, GRAPE, STRAWBERRY]
        System.out.print("\n");

        System.out.print("foreach");
        testList.stream().map(String::toUpperCase).forEach(s -> System.out.println(s));
        System.out.print("\n");
    }

    public static void ex_filter(ArrayList<String> list) {
        System.out.println("ex_filter");
        //list.stream().filter(t->t.length()>5)
        // 5이상인 요소
        System.out.println(list.stream().filter(t->t.length()>5).collect(Collectors.joining(" "))); //Banana Strawberry

        System.out.println(list.stream().filter(t->t.length()>5).collect(Collectors.toList())); //[Banana, Strawberry]

    }


    }
