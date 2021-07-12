package chp15_Lambda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


// original from : https://www.hackerrank.com/challenges/3d-surface-area/problem
public class Launcher155 {
    public static void main(String[] args) throws IOException {

        String input =
                "3 3 " +
                "1 3 4 " +
                "2 2 3 " +
                "1 2 4 ";

        String[] firstMultipleInput = input.replaceAll("\\s+$", "").split(" ");
        int H = Integer.parseInt(firstMultipleInput[0]);
        int W = Integer.parseInt(firstMultipleInput[1]);
        List<List<Integer>> A = new ArrayList<>();

        IntStream.range(0, H).forEach(i -> {
            A.add(
                    Stream.of(input.replaceAll("\\s+$", "").split(" "))
                            .map(Integer::parseInt)
                            .collect(toList()));
            int result = Result.surfaceArea(A);
        });
    }
}

class Result {
    public static  int surfaceArea(List<List<Integer>> A) {
        //for(int i=0 ; i<A.size() ; i++) {
            for(int j=0; j<A.get(0).size() ; j++) {
                System.out.print(A.get(0).get(j) + " ");
            }
            //System.out.println("");
        //}
        return 0;
    }

}