package org.javaacademy.civilregistry.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor
@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum FamilyStatus {
    NOT_MARRIED("не женат(не замужем)"),
    MARRIED("в браке"),
    DIVORCED("разведен(а)");
    @NonNull
    String name;
}
