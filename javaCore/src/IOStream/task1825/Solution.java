package IOStream.task1825;

import java.io.*;
import java.util.*;

/*
Собираем файл
Файлы для проверки работы кода:
C:\Users\Евгения\Desktop\task1825\Lion.part1.txt.part1
C:\Users\Евгения\Desktop\task1825\Lion.part1.txt.part3
C:\Users\Евгения\Desktop\task1825\Lion.part1.txt.part11
C:\Users\Евгения\Desktop\task1825\Lion.part1.txt.part4
C:\Users\Евгения\Desktop\task1825\Lion.part1.txt.part6
C:\Users\Евгения\Desktop\task1825\Lion.part1.txt.part5
C:\Users\Евгения\Desktop\task1825\Lion.part1.txt.part2
end
*/

public class Solution {
    public static void main(String[] args) {
        Set<String> fileNames = new TreeSet<>(Comparator.comparingInt(Solution::getPartNumber));
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

        try (FileOutputStream fos = new FileOutputStream(finalFileNameSplit[0] + ".txt", true)) {
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

    private static int getPartNumber(String filename) {
        return Integer.parseInt(filename.replaceFirst("^.+part(?=\\d+$)", ""));
    }
}
