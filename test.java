package Java_Study.ioi;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BufferedReader br = null;
        PrintWriter pw = null;
        try {
            br = new BufferedReader(new FileReader("src/../hi.txt"));
            pw = new PrintWriter("test.txt");

            String line = null;
            while((line = br.readLine())!=null)
            {
                pw.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("Success filecopy");
            pw.close();
            try {
                br.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
