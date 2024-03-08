package org.javaacademy.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor
@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum CivilAction {
    REGISTRATION_BIRTH("Регистрация рождения"),
    REGISTRATION_WEDDING("Регистрация свадьбы"),
    REGISTRATION_DIVORCE("Регистрация развода");
    String name;
}
