package net.htlgkr.gierlingerj190258.records;

import java.time.LocalDate;
import java.time.LocalTime;

public record Person(int id, String firstname, String lastname, int birthYear, int birthMonth, int birthDay, Gender gender, int salary, Address address, long phoneNumber, String email, String jobTitle, String department, int startHour, int startMinute, int endHour, int endMinute, String note) {
}
