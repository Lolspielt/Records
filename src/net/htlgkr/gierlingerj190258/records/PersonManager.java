package net.htlgkr.gierlingerj190258.records;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonManager {
    public static Scanner scanner = new Scanner(System.in);

    public static Person newPerson() {
        System.out.println("ID:");
        int id = Integer.parseInt(scanner.nextLine());;
        System.out.println("Firstname:");
        String firstname = scanner.nextLine();
        System.out.println("Lastname:");
        String lastname = scanner.nextLine();
        System.out.println("Birthday in format dd/MM/yyyy:");
        LocalDate birthdate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("Gender:");
        Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());
        System.out.println("Salary:");
        int salary = Integer.parseInt(scanner.nextLine());
        System.out.println("Country:");
        String country = scanner.nextLine();
        System.out.println("City:");
        String city = scanner.nextLine();
        System.out.println("Postcode:");
        int postcode = Integer.parseInt(scanner.nextLine());
        System.out.println("Street:");
        String street = scanner.nextLine();
        System.out.println("House number:");
        int houseNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Phone number:");
        long phoneNumber = Long.parseLong(scanner.nextLine());
        System.out.println("E-mail address:");
        String email = scanner.nextLine();
        System.out.println("Job Title:");
        String jobTitle = scanner.nextLine();
        System.out.println("Department:");
        String department = scanner.nextLine();
        System.out.println("Work start time in format HH:mm:");
        LocalTime workStart = LocalTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("HH:mm"));
        System.out.println("Work end time in format HH:mm:");
        LocalTime workEnd = LocalTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("HH:mm"));
        System.out.println("Note:");
        String note = scanner.nextLine();
        return new Person(id,firstname,lastname,birthdate,gender,salary,new Address(country,city,postcode,street,houseNumber),phoneNumber,email,jobTitle,department,workStart,workEnd,note);
    }

    public static void printPerson(Person person) {
        System.out.println(person.toString());
    }

    public static void searchPerson(List<Person> people) {
        List<Person> peopleResult = search(people);
        if (peopleResult.size() == 0) {
            System.out.println("No Persons found");
            return;
        }
        peopleResult.forEach(System.out::println);
    }

    private static List<Person> search(List<Person> people) {
        List<Person> peopleResult = new ArrayList<>();
        System.out.println("Keyword for searching Person");
        String searchString = scanner.nextLine();
        people.forEach(person -> {});
        for (Person person : people) {
            if (person.firstname().equals(searchString) ||
                    person.lastname().equals(searchString) ||
                    person.note().equals(searchString) ||
                    person.birthdate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).equals(searchString) ||
                    person.address().city().equals(searchString) ||
                    person.address().country().equals(searchString) ||
                    person.address().street().equals(searchString) ||
                    String.valueOf(person.address().houseNumber()).equals(searchString) ||
                    String.valueOf(person.address().postcode()).equals(searchString) ||
                    String.valueOf(person.id()).equals(searchString) ||
                    String.valueOf(person.salary()).equals(searchString) ||
                    String.valueOf(person.phoneNumber()).equals(searchString) ||
                    person.workStart().format(DateTimeFormatter.ofPattern("HH:mm")).equals(searchString) ||
                    person.workEnd().format(DateTimeFormatter.ofPattern("HH:mm")).equals(searchString) ||
                    person.email().equals(searchString) ||
                    person.department().equals(searchString) ||
                    person.gender().toString().equals(searchString) ||
                    person.jobTitle().equals(searchString)) {
                peopleResult.add(person);
            }
        }
        return peopleResult;
    }

    public static void editPerson(List<Person> people) {
        List<Person> peopleResult = search(people);
        if (peopleResult.size() == 0) {
            System.out.println("No Persons found");
            return;
        }
        peopleResult.forEach(System.out::println);
        System.out.println("Type in the index for the Person you want to edit");
        int index = Integer.parseInt(scanner.nextLine());
        people.remove(peopleResult.get(index - 1));
        people.add(newPerson());
    }

    public static void printAll(List<Person> people) {
        people.forEach(System.out::println);
    }

    public static void deletePerson(List<Person> people) {
        List<Person> peopleResult = search(people);
        if (peopleResult.size() == 0) {
            System.out.println("No Persons found");
        }
        peopleResult.forEach(System.out::println);
        System.out.println("Type in the index for the Person you want to edit");
        int index = Integer.parseInt(scanner.nextLine());
        people.remove(peopleResult.get(index - 1));
    }

    public static void analyze(List<Person> people) {
        System.out.println("1...How many People of a specific Gender");
        System.out.println("2...Average age");
        System.out.println("3...Least Salary");
        System.out.println("4...Most Salary");
        System.out.println("5...average Salary");
        int index = Integer.parseInt(scanner.nextLine());


    }

    private static int peopleOfGender(List<Person> people) {
        System.out.println("Gender:");
        int counter = 0;
        Gender gender = Gender.valueOf(scanner.nextLine());
        for (Person person : people) {
            if (person.gender() == gender) {
                counter ++;
            }
        }
        return counter;
    }

    private static double averageAge(List<Person> people) {
        double sumAge = 0;
        for (Person person : people) {
            //sumAge += person.birthdate().until()
        }
        return sumAge;
    }
}
