package org.javaacademy;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee extends Human {
    int moneyEarned;
    @Setter
    int rate;

    public Employee(@NonNull String name,
                    @NonNull String surname,
                    @NonNull String patronymic,
                    Gender gender) {
        super(name, surname, patronymic, gender);
    }
}
