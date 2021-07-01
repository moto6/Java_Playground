package Java_Study.jsok.chp11;

import java.util.Comparator;
import java.util.TreeSet;

public class Comp_ex1 {
    public static void main(String[] args) {
        TreeSet set1 = new TreeSet();
        TreeSet set2 = new TreeSet();


        int[] score = {20,40,30,50,10,43};

        for(int i=0 ; i<score.length ; i++ ) {
            set1.add(new Integer(score[i]));
            set2.add(new Integer(score[i]));

        }

        System.out.println("set1 : "+ set1);
        System.out.println("set2 : "+ set2);

    }

}

class Desending implements Comparator {
    public int compare(Object o1, Object o2) {
        if(o1 instanceof Comparable && o2 instanceof Comparable) {
            Comparable c1 = (Comparable) o1;
            Comparable c2 = (Comparable) o2;
            return c1.compareTo(c2) * -1;//-1을 곱하는 이유는 기본 정렬방식이아닌 역방향 순서로 뒤집겠다는 의미임
        }
        return -1;
    }
}
