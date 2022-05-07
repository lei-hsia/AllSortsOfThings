package threaddemo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author lei
 * @date 07/28/2021 2:11 PM
 */
public class ThreadFilePathDemo {
    private static final String RESOURCE_ROOT_PATH =
            Thread.currentThread().getContextClassLoader().getResource("").getPath();
    public static final String BATCH_POI_POSTER_POIS_FILE_PATH = RESOURCE_ROOT_PATH + "csv/";


    public static String genarateCsvFileName(String taskName) {
        return String.format("%s%s.csv", BATCH_POI_POSTER_POIS_FILE_PATH, taskName);
    }

    public static void main(String[] args) throws IOException {

        boolean made = new File(BATCH_POI_POSTER_POIS_FILE_PATH).mkdir();
        System.out.println(made);

        String testName = genarateCsvFileName("testName");

        Path path = Files.createFile(Paths.get(testName));
        System.out.println(path);

        System.out.println(System.currentTimeMillis());;
    }
}
