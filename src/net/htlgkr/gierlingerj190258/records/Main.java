package net.htlgkr.gierlingerj190258.records;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Person> people = PersonManager.readPeople();
        int index = 0;
        do {
            index = printMenu();
            switch (index) {
                case 1 -> people.add(PersonManager.newPerson());
                case 2 -> PersonManager.editPerson(people);
                case 3 -> PersonManager.deletePerson(people);
                case 4 -> PersonManager.searchPerson(people);
                case 5 -> PersonManager.printAll(people);
                case 6 -> PersonManager.analyze(people);
            }
            PersonManager.savePeople(people);
        }while(index != 7);
    }

    private static int printMenu() {
        System.out.println("1...New Person");
        System.out.println("2...Edit Person");
        System.out.println("3...Delete Person");
        System.out.println("4...Search Person");
        System.out.println("5...All Persons");
        System.out.println("6...Analysis");
        System.out.println("7...Exit");
        return Integer.parseInt(scanner.nextLine());
    }
}
