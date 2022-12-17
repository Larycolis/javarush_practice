package IOStream.task1822;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

/*
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) {
        // Проверка
//        args = new String[] {"195"};
        try (BufferedReader pathReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(pathReader.readLine()))) {
            String line = null;
            while ((line = fileReader.readLine()) != null) {
                if (line.startsWith(args[0] + " ")) {
                    System.out.print(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
