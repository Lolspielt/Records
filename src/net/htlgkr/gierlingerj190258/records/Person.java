package net.htlgkr.gierlingerj190258.records;

import java.time.LocalDate;
import java.time.LocalTime;

public record Person(int id, String firstname, String lastname, LocalDate birthdate, Gender gender, int salary, Address address, long phoneNumber, String email, String jobTitle, String department, LocalTime workStart, LocalTime workEnd, String note) {
}
