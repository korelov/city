package org.javaacademy.human;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.StringUtils;
import org.javaacademy.human.enums.Gender;

import java.util.LinkedList;
import java.util.Locale;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(exclude = {"father", "mother", "children"})
public class Human {
    final String name;
    final String surname;
    final String patronymic;
    final Gender gender;
    Human father;
    Human mother;
    LinkedList<Human> children = new LinkedList<>();

    public Human(@NonNull String name,
                 @NonNull String surname,
                 @NonNull
                 String patronymic,
                 Gender gender) {
        this.name = StringUtils.capitalize(name.toLowerCase(Locale.ROOT));
        this.surname = StringUtils.capitalize(surname.toLowerCase(Locale.ROOT));
        this.patronymic = StringUtils.capitalize(patronymic.toLowerCase(Locale.ROOT));
        this.gender = gender;
    }

    public Human(Human children) {
        this.name = children.getName();
        this.surname = children.getSurname();
        this.patronymic = children.getPatronymic();
        this.gender = children.getGender();
        this.father = children.getFather();
        this.mother = children.getMother();
    }

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
