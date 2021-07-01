package Java_Study.ioi;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.*;

public class ex1_stream {
    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("123.txt");
            BufferedOutputStream bos = new BufferedOutputStream(fos, 5);


            for (int i = 0; i<=9 ; i++) {
                bos.write(i);
            }
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

