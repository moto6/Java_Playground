package chp15_Lambda;

import java.util.Arrays;
import java.util.Comparator;

public class Launcher151 {
    public static void main(String[] args) {
        String [] names = {"DONG","SAN","JANE","COOP","WOODY"};

        Comparator<String> stringComparator = ((o1, o2) -> o1.compareTo(o2));
        Comparator<String> sc2 = String::compareTo;

        Arrays.sort(names,stringComparator);
        Arrays.sort(names,sc2);
        Arrays.sort(names,Comparator.reverseOrder());
        Arrays.sort(names,Comparator.naturalOrder());
        Arrays.sort(names,(s1, s2) -> s1.length()+s2.length());
        //type만 맞춰준 형태일뿐 아무런 의미없는 코드

        System.out.println(Arrays.toString(names));
    }
}
