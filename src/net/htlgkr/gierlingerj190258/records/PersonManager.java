package net.htlgkr.gierlingerj190258.records;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;
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
        return new Person(id,firstname,lastname,birthdate.getYear(), birthdate.getMonthValue(), birthdate.getDayOfMonth(), gender,salary,new Address(country,city,postcode,street,houseNumber),phoneNumber,email,jobTitle,department,workStart.getHour(),workStart.getMinute(),workEnd.getHour(),workEnd.getMinute(),note);
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
                    LocalDate.of(person.birthYear(), person.birthMonth(), person.birthDay()).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).equals(searchString) ||
                    person.address().city().equals(searchString) ||
                    person.address().country().equals(searchString) ||
                    person.address().street().equals(searchString) ||
                    String.valueOf(person.address().houseNumber()).equals(searchString) ||
                    String.valueOf(person.address().postcode()).equals(searchString) ||
                    String.valueOf(person.id()).equals(searchString) ||
                    String.valueOf(person.salary()).equals(searchString) ||
                    String.valueOf(person.phoneNumber()).equals(searchString) ||
                    LocalTime.of(person.startHour(), person.startMinute()).format(DateTimeFormatter.ofPattern("HH:mm")).equals(searchString) ||
                    LocalTime.of(person.endHour(), person.endMinute()).format(DateTimeFormatter.ofPattern("HH:mm")).equals(searchString) ||
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
        switch (index) {
            case 1 -> peopleOfGender(people);
            case 2 -> averageAge(people);
            case 3 -> leastSalary(people);
            case 4 -> mostSalary(people);
            case 5 -> averageSalary(people);
        }
    }

    private static void peopleOfGender(List<Person> people) {
        System.out.println("Gender:");
        Gender gender = Gender.valueOf(scanner.nextLine());
        int counter = 0;
        for (Person person : people) {
            if (person.gender() == gender) {
                counter ++;
            }
        }
        System.out.println("There are " + counter + "people of gender: " + gender.toString());
    }

    private static void averageAge(List<Person> people) {
        double averageAge = people.stream()
                .map(person -> LocalDate.now().getYear() - person.birthYear())
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
        System.out.println("Average Age: " + averageAge);
    }

    private static void leastSalary(List<Person> people) {
        int leastSalary = people.stream().map(Person::salary)
                .mapToInt(Integer::intValue)
                .min()
                .getAsInt();
        System.out.println("Least Salary: " + leastSalary);
    }

    private static void mostSalary(List<Person> people) {
        int mostSalary = people.stream().map(Person::salary)
                .mapToInt(Integer::intValue)
                .max()
                .getAsInt();
        System.out.println("Most Salary: " + mostSalary);
    }

    private static void averageSalary(List<Person> people) {
        double averageSalary = people.stream().map(Person::salary)
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
        System.out.println("Average Salary: " + averageSalary);
    }

    public static void savePeople(List<Person> people) {
        Gson gson = new Gson();
        String json = gson.toJson(people);
        IOHandler.write(json);
    }

    public static List<Person> readPeople() {
        List<Person> people = new ArrayList<>();
        Gson gson = new Gson();
        String json = IOHandler.read();
        if (json != null) {
            Type collectionType = new TypeToken<List<Person>>(){}.getType();
            people = gson.fromJson(json, collectionType);
        }
        return people;
    }
}
