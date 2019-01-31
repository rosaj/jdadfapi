package com.jdadfapi;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 10-Nov-17
 * Time: 07:11
 */

public class FileUtils {


    public static void checkOrCreateDirectory(File file) {
        Path path = file.toPath().getParent();

        if (!Files.exists(path)) {
            File dir = new File(file.getParent());
            dir.mkdirs();
        }
    }
}
