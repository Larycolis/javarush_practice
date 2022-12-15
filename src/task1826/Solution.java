package task1826;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
Шифровка
*/

public class Solution {
    public static void main(String[] args) throws IOException {
//        args = new String[]{"-e", "C:/Users/Евгения/Desktop/text(input).txt", "C:/Users/Евгения/Desktop/text(output).txt"};
//        args = new String[] {"-d", "C:/Users/Евгения/Desktop/text(input).txt", "C:/Users/Евгения/Desktop/text(output).txt"};
        FileInputStream inputStream = new FileInputStream(args[1]);
        FileOutputStream outputStream = new FileOutputStream(args[2]);
        switch (args[0]) {
            case "-e":
                while (inputStream.available() > 0) {
                    outputStream.write(inputStream.read() + 1);
                }
            case "-d":
                while (inputStream.available() > 0) {
                    outputStream.write(inputStream.read() - 1);
                }
        }
        inputStream.close();
        outputStream.close();
    }
}
