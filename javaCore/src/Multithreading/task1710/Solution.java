package Multithreading.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    public static SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    public static SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {

        if (args[0].equals("-c")) {
            create(args[1], args[2], args[3]);
        } else if (args[0].equals("-r")) {
            read(args[1]);
        } else if (args[0].equals("-u")) {
            update(args[1], args[2], args[3], args[4]);
        } else if (args[0].equals("-d")) {
            delete(args[1]);
        }

        // Проверка
//        System.out.print("Набор параметров для запуска программы: ");
//
//        for (String arg : args) {
//            System.out.print(arg + " ");
//        }
//
//        System.out.println("\nСодержимое списка allPeople: ");
//
//        for (Person person : allPeople) {
//            System.out.println(person.getName() + " " + person.getSex() + " " + person.getBirthDate());
//        }
    }

    public static void create(String name, String sex, String bd) throws ParseException {
        if (sex.equals("м")) {
            allPeople.add(Person.createMale(name, dateFormat1.parse(bd)));
        } else if (sex.equals("ж")) {
            allPeople.add(Person.createFemale(name, dateFormat1.parse(bd)));
        }
        System.out.println(allPeople.size() - 1);
    }

    public static void read(String id) {
        Person person = allPeople.get(Integer.parseInt(id));
        if (person.getSex().equals(Sex.MALE)) {
            System.out.println(person.getName() + " м " + dateFormat2.format(person.getBirthDate()));
        } else if (person.getSex().equals(Sex.FEMALE)) {
            System.out.println(person.getName() + " ж " + dateFormat2.format(person.getBirthDate()));
        }
    }

    public static void update(String id, String name, String sex, String bd) throws ParseException {
        Person person = allPeople.get(Integer.parseInt(id));
        person.setName(name);
        if (sex.equals("м")) {
            person.setSex(Sex.MALE);
        } else if (sex.equals("ж")) {
            person.setSex(Sex.FEMALE);
        }
        person.setBirthDate(dateFormat1.parse(bd));
        allPeople.set(Integer.parseInt(id), person);
    }

    public static void delete(String id) {
        allPeople.get(Integer.parseInt(id)).setName(null);
        allPeople.get(Integer.parseInt(id)).setSex(null);
        allPeople.get(Integer.parseInt(id)).setBirthDate(null);
    }
}