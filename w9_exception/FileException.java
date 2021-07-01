import java.beans.FeatureDescriptor;
import java.io.*;
import java.util.List;

import javax.xml.catalog.CatalogFeatures.Feature;

import java.util.ArrayList;

public class FileException {

    private List<Integer> list;
    private static final int SIZE = 100;

    public FileException () {
        list = new ArrayList<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            list.add(i*i*i);
        }
    }

    public void writeList() throws Exception{
	// The FileWriter constructor throws IOException, which must be caught.
    
        PrintWriter fileHandler = new PrintWriter(new FileWriter("output.txt"));
    
        for (int i = 0; i < SIZE; i++) {
            // The get(int) method throws IndexOutOfBoundsException, which must be caught.
            fileHandler.println("Value at: " + i + " = " + list.get(i));
        }
        fileHandler.close();
    }

    public static void main(String[] args) throws Exception{
        FileException fe = new FileException();
        fe.writeList();
    }
}