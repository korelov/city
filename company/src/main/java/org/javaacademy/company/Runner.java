package org.javaacademy.company;

import lombok.NonNull;
import org.javaacademy.profession.Manager;
import org.javaacademy.profession.Programmer;
import org.javaacademy.profession.Task;
import org.javaacademy.human.enums.Gender;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Runner {
    public static void main(@NonNull String[] args) {
        Company oracle = new Company(args[0], Integer.parseInt(args[1]));
        Manager manager = new Manager("Вася", "иванов", "петрович", Gender.MALE);
        oracle.setManager(manager);
        Programmer programmerOne = new Programmer("Олег", "сидоров", "олегович", Gender.MALE);
        Programmer programmerTwo = new Programmer("Анна", "иванова", "смирнова", Gender.FEMALE);
        oracle.addProgrammer(programmerOne);
        oracle.addProgrammer(programmerTwo);

        Task taskOne = new Task("Проект Поле-Чудес", 8);
        Task taskTwo = new Task("Проект Метро", 12);
        Task taskThree = new Task("Проект Город", 15);

        Queue<Task> tasks = new LinkedList<>(List.of(taskOne, taskTwo, taskThree));
        oracle.weeklyWork(tasks);
        oracle.paySalaries();
        oracle.companyInfo();
    }
}
