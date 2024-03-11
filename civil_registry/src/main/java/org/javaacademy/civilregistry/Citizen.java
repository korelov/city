package org.javaacademy.civilregistry;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.javaacademy.human.Human;
import org.javaacademy.civilregistry.enums.FamilyStatus;
import org.javaacademy.human.enums.Gender;


@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Citizen extends Human {
    FamilyStatus familyStatus;
    Citizen spouse;

    public Citizen(@NonNull String name,
                   @NonNull String surname,
                   @NonNull String patronymic,
                   Gender gender,
                   FamilyStatus familyStatus) {
        super(name, surname, patronymic, gender);
        this.familyStatus = familyStatus;
    }

    public Citizen(Human children) {
        super(children);
        familyStatus = FamilyStatus.NOT_MARRIED;
    }

    @Override
    public String toString() {
        return getFullName();
    }
}
