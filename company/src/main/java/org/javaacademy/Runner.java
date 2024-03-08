package org.javaacademy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Runner {
    public static void main(String[] args) {
        Manager manager = new Manager("Вася", "иванов", "петрович", Gender.MALE);
        Programmer programmerOne = new Programmer("Олег", "сидоров", "олегович", Gender.MALE);
        Programmer programmerTwo = new Programmer("Анна", "иванова", "смирнова", Gender.FEMALE);
        List<Programmer> programmers = Arrays.asList(programmerOne, programmerTwo);

        Task taskOne = new Task("Проект Поле-Чудес", 8);
        Task taskTwo = new Task("Проект Метро", 12);
        Task taskThree = new Task("Проект Город", 15);

        Company oracle = new Company("Oracle", programmers, manager, 1_800);
        Queue<Task> tasks = new LinkedList<>(List.of(taskOne, taskTwo, taskThree));
        oracle.weeklyWork(tasks);
        oracle.paySalaries();
        oracle.companyInfo();

        //кто сколько заработал
        System.out.println(manager.getFullName() + "заработал " + manager.getMoneyEarned());
        System.out.println(programmerOne.getFullName() + "заработал " + programmerOne.getMoneyEarned());
        System.out.println(programmerTwo.getFullName() + "заработал " + programmerTwo.getMoneyEarned());
    }
}
