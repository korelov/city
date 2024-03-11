package org.javaacademy.civilregistry;

import lombok.NonNull;

import java.time.LocalDate;
import java.time.Month;

import static org.javaacademy.civilregistry.enums.FamilyStatus.NOT_MARRIED;
import static org.javaacademy.human.enums.Gender.FEMALE;
import static org.javaacademy.human.enums.Gender.MALE;

public class RunnerProm {
    public static void main(@NonNull String[] args) {
        CivilRegistry civilRegistry = new CivilRegistry(args[0]);
        LocalDate localDate = LocalDate.of(2023, Month.FEBRUARY, 20);
        Citizen maksim = new Citizen(
                "максим", "корелов", "владимирович", MALE, NOT_MARRIED);
        Citizen marina = new Citizen(
                "марина", "сидорова", "сергеевна", FEMALE, NOT_MARRIED);
        Citizen oleg = new Citizen(
                "олег", "иванов", "олегович", MALE, NOT_MARRIED);
        Citizen anna = new Citizen(
                "анна", "виноградова", "петрович", FEMALE, NOT_MARRIED);
        Citizen petr = new Citizen(marina.makeChildren(
                "Петя", "ребенок", "ребенок", MALE, maksim));
        Citizen olya = new Citizen(anna.makeChildren(
                "оля", "ребенок", "ребенок", FEMALE, oleg));
        Citizen vika = new Citizen(marina.makeChildren(
                "оля", "ребенок", "ребенок", FEMALE, maksim));
        civilRegistry.weddingRegistration(maksim, marina, localDate);
        civilRegistry.weddingRegistration(oleg, anna, localDate);
        civilRegistry.divorce(oleg, anna, localDate);
        civilRegistry.childBirth(petr, maksim, marina, localDate);
        civilRegistry.childBirth(olya, oleg, anna, localDate);
        civilRegistry.childBirth(vika, marina, maksim, localDate);
        civilRegistry.printStatistic();
    }
}
