package org.javaacademy;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Human {
    final String name;
    final String surname;
    final String patronymic;
    final Gender gender;
    Human father;
    Human mother;
    @EqualsAndHashCode.Exclude
    final LinkedList<Human> children = new LinkedList<>();

    public Human(@NonNull String name,
                 @NonNull String surname,
                 @NonNull String patronymic,
                 Gender gender) {
        this.name = StringUtils.capitalize(name);
        this.surname = StringUtils.capitalize(surname);
        this.patronymic = StringUtils.capitalize(patronymic);
        this.gender = gender;
    }

    @NonNull
    public String getFullName() {
        return String.format("%s %s %s", surname, name, patronymic);
    }

    public Human makeChildren(String name, String surname, String patronymic, Gender gender, Human human) {
        if (!this.gender.equals(human.gender)) {
            Human children = new Human(name, surname, patronymic, gender);
            children.addParents(this, human);
            this.addChildren(children);
            human.addChildren(children);
            return children;
        }
        throw new IllegalArgumentException("У родителей одинаковый пол");
    }

    private void addParents(Human human1, Human human2) {
        if (human1.gender.equals(Gender.FEMALE)) {
            this.mother = human1;
            this.father = human2;
        } else {
            this.mother = human2;
            this.father = human1;
        }
    }

    private void addChildren(Human children) {
        this.children.add(children);
    }
}
