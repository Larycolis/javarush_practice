package IOStream.task1817;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/*
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // Проверка
        args = new String[] {"C:/Users/Евгения/Desktop/Git.txt"};
        try (FileInputStream inputStream = new FileInputStream(args[0])) {
            ArrayList<Character> symbols = new ArrayList<>();
            int spaceСount = 0;
            int symbolCount = 0;
            while (inputStream.available() > 0) {
                symbols.add((char) inputStream.read());
            }
            for (Character spaceSymbol : symbols) {
                if (spaceSymbol.equals(' ')) {
                    spaceСount++;
                }
                symbolCount++;
            }
            float ratio = (float) spaceСount / symbolCount * 100;
            System.out.println(spaceСount);
            System.out.println(symbolCount);
            System.out.format("%.2f", ratio);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}