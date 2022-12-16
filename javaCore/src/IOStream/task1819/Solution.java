package IOStream.task1819;

import java.io.*;
import java.util.ArrayList;

/*
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = bufferedReader.readLine();
        String file2 = bufferedReader.readLine();
        bufferedReader.close();

        try (FileInputStream inputStream1 = new FileInputStream(file1);
             FileInputStream inputStream2 = new FileInputStream(file2);
             FileOutputStream outputStream = new FileOutputStream(file1)) {
            ArrayList<Byte> buffer = new ArrayList<>();
            while (inputStream2.available() > 0) {
                buffer.add((byte) inputStream2.read());
            }
            while (inputStream1.available() > 0) {
                buffer.add((byte) inputStream1.read());
            }
            for (Byte b : buffer) {
                outputStream.write(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
