package ap.chapter7;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util.println;

/**
 * @author lei
 * @date 01/07/2022 11:45 AM
 */
public class ReverseFileWriting {
    public static void main(String[] args) throws IOException {
        // TODO filename <<<<
        String filename = Thread.currentThread().getContextClassLoader().getResource("").getPath()+"lucky";
        try {
            Scanner scanner = new Scanner(new File(filename));
            ArrayList<String> lines = new ArrayList<>();
            // Read all lines and store in our ArrayList
            while (scanner.hasNextLine()) { lines.add(scanner.nextLine());
            }
            // Output the lines from back to front
            for (int i = lines.size() - 1; i >= 0; i--) {
                println(lines.get(i));
            }
        } catch (IOException ex) {
            println("Could not read file."); }
    }
}
