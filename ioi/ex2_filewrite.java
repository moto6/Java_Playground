package Java_Study.ioi;

import java.io.*;

public class ex2_filewrite {

    public static void main(String[] args) {
        File file = new File("hi.txt");
        String s = "Hello DongHun!!!";

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(s);
            bw.write("Mu YAAA HOOO!");
            bw.close();
            System.out.println(file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
