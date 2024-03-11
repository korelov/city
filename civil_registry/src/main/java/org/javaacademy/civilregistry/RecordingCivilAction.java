package org.javaacademy.civilregistry;

import lombok.Value;
import org.javaacademy.civilregistry.enums.CivilAction;

import java.time.LocalDate;
import java.util.List;

@Value
public class RecordingCivilAction {
    LocalDate localDate;
    CivilAction civilAction;
    List<Citizen> citizenList;
}
