package org.javaacademy.profession;

import lombok.NonNull;
import org.javaacademy.human.enums.Gender;

public class Manager extends Employee {
    public Manager(@NonNull String name,
                   @NonNull String surname,
                   @NonNull String patronymic,
                   Gender gender) {
        super(name, surname, patronymic, gender);
        setRate(10_000);
    }
}
