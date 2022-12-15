package IOStream.task1816;

import java.io.FileReader;
import java.io.IOException;

/*
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader(args[0]);
        int count = 0;
        while (reader.ready()) {
            if (String.valueOf((char)(reader.read())).matches("[A-Za-z]")) {
                count++;
            }
        }
        System.out.println(count);
        reader.close();
    }
}
