package org.javaacademy;

import lombok.NonNull;
import lombok.ToString;

@ToString
public class Manager extends Employee {
    public Manager(@NonNull String name,
                   @NonNull String surname,
                   @NonNull String patronymic,
                   Gender gender) {
        super(name, surname, patronymic, gender);
        setRate(10_000);
    }
}
