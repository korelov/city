package org.javaacademy;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Programmer extends Employee {
    Task task;

    public Programmer(@NonNull String name,
                      @NonNull String surname,
                      @NonNull String patronymic,
                      Gender gender) {
        super(name, surname, patronymic, gender);
    }

    @Override
    public void setRate(int rate) {
        if (rate >= 1500 && rate <= 2000) {
            super.setRate(rate);
            return;
        }
        throw new IllegalArgumentException("Ставка от 1500 до 2000 рублей");
    }

    public void changeTaskStatus(@NonNull Task task) {
        if (this.task.isDone()) {
            task.setDone(false);
            return;
        }
        task.setDone(true);
    }

    public void acceptsTask(Task task) {
        this.task = task;
        task.setDone(true);
    }

    @Override
    public String toString() {
        return getFullName();
    }

}
