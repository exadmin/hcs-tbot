package com.github.exadmin.hcstbot.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtils {
    public static void writeToFile(Path file, String content) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file.toFile()));
            writer.write(content);

            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String readFromFile(Path file) {
        try {
            return new String(Files.readAllBytes(file));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
