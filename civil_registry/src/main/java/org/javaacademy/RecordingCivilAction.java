package org.javaacademy;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.javaacademy.enums.CivilAction;

import java.time.LocalDate;
import java.util.List;


@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@ToString(includeFieldNames = false)
public class RecordingCivilAction {
    final LocalDate localDate;
    final CivilAction civilAction;
    List<Citizen> citizenList;
}
