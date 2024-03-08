package org.javaacademy;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.FieldDefaults;


@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee extends Human {
    int moneyEarned;
    int rate;

    public Employee(@NonNull String name,
                    @NonNull String surname,
                    @NonNull String patronymic,
                    Gender gender) {
        super(name, surname, patronymic, gender);
    }
}
