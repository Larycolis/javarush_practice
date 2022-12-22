package IOStream.task1820;

import java.io.*;

/*
Округление чисел
*/

public class Solution {
    public static void main(String[] args) {
        // C:\Users\Евгения\Desktop\text(input).txt inFile: 3.49 3.50 3.51 -3.49 -3.50 -3.51
        // C:\Users\Евгения\Desktop\text(output).txt outFile: 3 4 4 -3 -3 -4
        String fileName1 = null;
        String fileName2 = null;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = bufferedReader.readLine();
            fileName2 = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert fileName1 != null;
        assert fileName2 != null;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName1));
             BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2))) {
            while (reader.ready()) {
                String[] splitData = reader.readLine().split("\\s");
                for (String str : splitData) {
                    writer.write(Math.round(Double.parseDouble(str)) + " ");
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
