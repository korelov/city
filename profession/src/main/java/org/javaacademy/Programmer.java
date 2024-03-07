package org.javaacademy;

import lombok.NonNull;

public class Programmist extends Employee {
    public Programmist(@NonNull String name, @NonNull String surname, @NonNull String patronymic, Gender gender) {
        super(name, surname, patronymic, gender);
    }


}
