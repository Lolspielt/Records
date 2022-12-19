package net.htlgkr.gierlingerj190258.records;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOHandler {
    static String fileName = "notes.json";

    public static void write(String json) {
        File file = new File(fileName);
        try {
            if(!file.exists()) file.createNewFile();
            FileOutputStream stream = new FileOutputStream(file);
            stream.write(json.getBytes());
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String read() {
        File file = new File(fileName);

        try {
            if (file.exists()) {
                int length = (int) file.length();
                byte[] bytes = new byte[length];

                FileInputStream in = new FileInputStream(file);
                in.read(bytes);
                in.close();
                return new String(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
