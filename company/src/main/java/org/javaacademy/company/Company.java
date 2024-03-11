package org.javaacademy.company;

import lombok.AccessLevel;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.javaacademy.profession.Employee;
import org.javaacademy.profession.Manager;
import org.javaacademy.profession.Programmer;
import org.javaacademy.profession.Task;

import java.util.*;


@FieldDefaults(level = AccessLevel.PRIVATE)
public class Company {
    final String name;
    @Setter
    Manager manager;
    final List<Programmer> programmers = new ArrayList<>();
    final MultiValuedMap<Programmer, Task> taskList = new ArrayListValuedHashMap<>();
    final Map<Employee, Double> workHours = new HashMap<>();
    int singleRateProgrammers;
    double totalCost;

    public Company(String name, int singleRateProgrammers) {
        this.name = name;
        this.singleRateProgrammers = singleRateProgrammers;
    }

    public void addProgrammer(Programmer programmer) {
        programmers.add(programmer);
        programmer.setRate(singleRateProgrammers);
    }

    //5.3
    public void weeklyWork(Queue<Task> tasks) {
        while (!tasks.isEmpty()) {
            for (Programmer programmer : programmers) {
                if (tasks.isEmpty()) {
                    break;
                }
                Task task = tasks.poll();
                programmer.acceptsTask(task);
                System.out.println(task.getName() + "- сделана");
                taskList.put(programmer, task);
                workHours.put(programmer, workHours.getOrDefault(programmer, 0.0)
                        + task.getNumberHoursPerTask());
                workHours.put(manager, (workHours.getOrDefault(manager, 0.0)
                        + task.getNumberHoursPerTask() * 0.1));
            }
        }
    }

    //5.4
    public void paySalaries() {
        totalCost += manager.getRate() * workHours.getOrDefault(manager, 0.0);
        manager.setMoneyEarned(workHours.getOrDefault(manager, 0.0) * manager.getRate());
        for (Programmer programmer : programmers) {
            programmer.setMoneyEarned(workHours.getOrDefault(programmer, 0.0) * programmer.getRate());
            totalCost += programmer.getRate() * workHours.getOrDefault(programmer, 0.0);
            workHours.put(programmer, 0.0);
        }
        workHours.put(manager, 0.0);
    }

    //5.5
    public void companyInfo() {
        System.out.println(name);
        System.out.printf("Затраты: %.2f%n", totalCost);
        System.out.println("Список выполненных задач у компании:");
        for (Programmer programmer : taskList.keySet()) {
            System.out.print(programmer.getFullName() + " ");
            for (Task task : taskList.get(programmer)) {
                System.out.print(task.getName() + ", ");
            }
            System.out.println();
        }
    }
}
