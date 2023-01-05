package IOStream.task1825;

import java.io.*;
import java.util.*;

/*
Собираем файл
Файлы для проверки работы кода:
C:\Users\Евгения\Desktop\task1825\Lion.txt.part1
C:\Users\Евгения\Desktop\task1825\Lion.txt.part3
C:\Users\Евгения\Desktop\task1825\Lion.txt.part11
C:\Users\Евгения\Desktop\task1825\Lion.txt.part4
C:\Users\Евгения\Desktop\task1825\Lion.txt.part6
C:\Users\Евгения\Desktop\task1825\Lion.txt.part5
C:\Users\Евгения\Desktop\task1825\Lion.txt.part2
end
*/

public class Solution {
    public static void main(String[] args) {
        Set<String> fileNames = new TreeSet<>((o1, o2) -> {
            String[] parts1 = o1.split(".part");
            String[] parts2 = o2.split(".part");
            int num1 = Integer.parseInt(parts1[parts1.length - 1]);
            int num2 = Integer.parseInt(parts2[parts2.length - 1]);
            return num1 - num2;
        });
        String[] finalFileNameSplit = new String[1];
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName;
            while (!(fileName = br.readLine()).equals("end")) {
                if (fileName.contains(".part")) {
                    fileNames.add(fileName);
                    finalFileNameSplit = fileName.split(".part");
                } else {
                    System.out.println("invalid filename");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Проверка сортировки
        for (String name : fileNames) {
            System.out.println(name);
        }

        try (FileOutputStream fos = new FileOutputStream(finalFileNameSplit[0], true)) {
            for (String name : fileNames) {
                try (FileInputStream fis = new FileInputStream(name)) {
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    fos.write(buffer);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
