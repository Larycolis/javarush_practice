package IOStream.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

/*
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
//        args = new String[] {"-y", "Ботинки для сноубордистов", "7000.50", "20"};
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine(); // "C:\Users\Евгения\Desktop\text(input).txt"
        bufferedReader.close();

        if (args.length != 4) {
            System.out.println("Invalid number of arguments");
        } else if (args[0].equals("-c")) {
            addingProduct(fileName, args);
        } else {
            System.out.println("The first argument is invalid");
        }
    }

    public static int generateId(String fileName) {
        ArrayList<Integer> listId = new ArrayList<>();
        String idIndex;
        String idInList;
        int idGen = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                idIndex = reader.readLine().substring(0, 8);
                idInList = idIndex.trim();
                listId.add(Integer.parseInt(idInList));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Integer id: listId) {
            idGen = Math.max(idGen, id);
        }

        return ++idGen;
    }

    public static void addingProduct(String fileName, String[] args) {
        int id = generateId(fileName);
        String productName = String.format("%-30.30s", args[1]);
        String price = String.format(Locale.ROOT, "%-8.2f", Double.parseDouble(args[2]));
        String quantity = String.format("%-4d", Integer.parseInt(args[3]));
        String addedLine = Integer.toString(id) + productName + price + quantity;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write("\n" + addedLine);
            System.out.println("New line added");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}