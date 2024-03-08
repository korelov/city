package org.javaacademy;

import java.time.LocalDate;

import static org.javaacademy.Gender.FEMALE;
import static org.javaacademy.Gender.MALE;
import static org.javaacademy.enums.FamilyStatus.NOT_MARRIED;

public class RunnerTest {
    public static void main(String[] args) {
        CivilRegistry civilRegistry = new CivilRegistry("TEST_ZAGS");
        LocalDate localDate = LocalDate.of(2023, 2, 20);

        Citizen maksim = new Citizen(
                "максим", "корелов", "владимирович", MALE, NOT_MARRIED);
        Citizen marina = new Citizen(
                "марина", "сидорова", "сергеевна", FEMALE, NOT_MARRIED);
        Citizen oleg = new Citizen(
                "олег", "иванов", "олегович", MALE, NOT_MARRIED);
        Citizen anna = new Citizen(
                "анна", "виноградова", "петрович", FEMALE, NOT_MARRIED);

        civilRegistry.weddingRegistration(maksim, marina, localDate);
        civilRegistry.weddingRegistration(oleg, anna, localDate);
        civilRegistry.divorce(oleg, anna, localDate);

//        тут две ошибки, вызов у null метода из human и каст из субкласса в суперкласс
//        System.out.println(oleg.getSpouse().getFullName());
//        Human children = marina.makeChildren("ребенок", "ребенок", "ребенок", MALE, maksim);
        civilRegistry.printStatistic();
    }
}
