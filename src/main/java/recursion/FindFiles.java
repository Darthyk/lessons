package recursion;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindFiles {


    public static List<String> getFiles(String path) throws IOException {
        File folder = new File(path);
        List<String> files = new ArrayList<>();
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                files.addAll(getFiles(file.getPath()));
            }
            if(file.isFile()) {
                files.add(file.getName());
            }
        }
        return files;
    }
}
