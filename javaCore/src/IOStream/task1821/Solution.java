package IOStream.task1821;

import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

/*
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) {
        // Проверка
//        args = new String[] {"C:/Users/Евгения/Desktop/Git.txt"};
        Map<Character, Integer> map = new TreeMap<>();
        char symbol;
        try (FileReader reader = new FileReader(args[0])) {
            while (reader.ready()) {
                symbol = (char) reader.read();
                if (!map.containsKey(symbol)) {
                    map.put(symbol, 1);
                } else {
                    map.put(symbol, map.get(symbol) + 1);
                }
            }
            for (Map.Entry<Character, Integer> position : map.entrySet()) {
                System.out.println(position.getKey() + " " + position.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
