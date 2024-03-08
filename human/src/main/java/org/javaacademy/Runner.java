package org.javaacademy;

import static org.javaacademy.Gender.MALE;
import static org.javaacademy.Gender.FEMALE;

public class Runner {

    public static void main(String[] args) {
        Human humanOne = new Human("максим", "корелов", "владимирович", MALE);
        Human humanOne1 = new Human("максим", "корелов", "владимирович", MALE);
        System.out.println(humanOne.equals(humanOne1));

        Human humanTwo = new Human("оля", "виноградова", "сергеевна", FEMALE);
        Human children = humanOne.makeChildren(
                "петя", "корелов", "максимович", MALE, humanTwo);

        System.out.println(humanOne.getChildren().get(0).getFullName());
        System.out.println(humanTwo.getChildren().get(0).getFullName());
        System.out.println(children.getFather().getFullName());
        System.out.println(children.getMother().getFullName());
    }
}
