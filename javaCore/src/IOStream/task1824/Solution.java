import java.io.*;

/*
Файлы и исключения
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                String path = bufferedReader.readLine();
                try {
                    FileInputStream fileIn = new FileInputStream(path);
                    fileIn.close();
                } catch (FileNotFoundException e) {
                    System.out.println(path);
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        bufferedReader.close();
    }
}
