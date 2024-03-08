package org.javaacademy;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;


@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Company {
    String name;
    Manager manager;
    List<Programmer> programmers;
    MultiValuedMap<Programmer, Task> taskList = new ArrayListValuedHashMap<>();
    Map<Employee, Integer> workHours = new HashMap<>();
    @NonFinal
    double totalCost;

    public Company(String name, List<Programmer> programmers, Manager manager, int singleRateProgrammers) {
        this.name = name;
        this.manager = manager;
        this.programmers = programmers;
        this.totalCost = 0;
        for (Programmer programmer : programmers) {
            programmer.setRate(singleRateProgrammers);
        }
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
                workHours.put(programmer, workHours.getOrDefault(programmer, 0)
                        + task.getNumberHoursPerTask());
                workHours.put(manager, (workHours.getOrDefault(manager, 0)
                        + (int) (Math.ceil(task.getNumberHoursPerTask() * 0.1))));
            }
        }
    }

    //5.4
    public void paySalaries() {
        totalCost += manager.getRate() * workHours.getOrDefault(manager, 0);
        for (Programmer programmer : programmers) {
            totalCost += programmer.getRate() * workHours.getOrDefault(programmer, 0);
            workHours.put(programmer, 0);
        }
        workHours.put(manager, 0);
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
