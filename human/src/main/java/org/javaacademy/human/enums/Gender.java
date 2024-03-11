package org.javaacademy.human.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor
@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum Gender {
    MALE("Мужчина"),
    FEMALE("Женщина");
    @NonNull
    String gender;
}


