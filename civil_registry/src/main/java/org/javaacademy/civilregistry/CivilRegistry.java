package org.javaacademy.civilregistry;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.javaacademy.civilregistry.enums.CivilAction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.javaacademy.civilregistry.enums.CivilAction.*;
import static org.javaacademy.civilregistry.enums.FamilyStatus.DIVORCED;
import static org.javaacademy.civilregistry.enums.FamilyStatus.MARRIED;


@RequiredArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CivilRegistry {
    @NonNull
    final String name;
    Map<LocalDate, List<RecordingCivilAction>> civilRegistries = new TreeMap<>(LocalDate::compareTo);

    private void addRecordingCivilAction(LocalDate localDate, RecordingCivilAction recordingCivilAction) {
        if (!civilRegistries.containsKey(localDate)) {
            civilRegistries.put(localDate, new ArrayList<>());
        }
        civilRegistries.get(localDate)
                .add(new RecordingCivilAction(localDate,
                        recordingCivilAction.getCivilAction(),
                        recordingCivilAction.getCitizenList()));
    }

    //3.4.1
    public void childBirth(Citizen children, Citizen citizen1, Citizen citizen2, LocalDate localDate) {
        checkParents(children, citizen1, citizen2);
        addRecordingCivilAction(localDate, new RecordingCivilAction(localDate,
                REGISTRATION_BIRTH, List.of(children, citizen1, citizen2)));
    }

    private void checkParents(Citizen children, Citizen parentOne, Citizen parentTwo) {
        if (!((children.getFather().equals(parentOne) && children.getMother().equals(parentTwo))
                || (children.getFather().equals(parentTwo) && children.getMother().equals(parentOne)))) {
            throw new IllegalArgumentException("Не являются родителями ребенка");
        }
    }

    //3.4.2
    public void weddingRegistration(Citizen citizen1, Citizen citizen2, LocalDate localDate) {
        checkFamilyStatus(citizen1);
        checkFamilyStatus(citizen2);
        checkSpouseStatus(citizen1);
        checkSpouseStatus(citizen2);
        addRecordingCivilAction(localDate, new RecordingCivilAction(localDate,
                REGISTRATION_WEDDING, List.of(citizen1, citizen2)));
        citizen1.setSpouse(citizen2);
        citizen2.setSpouse(citizen1);
        citizen1.setFamilyStatus(MARRIED);
        citizen2.setFamilyStatus(MARRIED);
    }

    private void checkFamilyStatus(Citizen citizen) {
        if (citizen.getFamilyStatus().equals(MARRIED)) {
            throw new IllegalArgumentException(citizen.getFullName() + " в статусе женат(а)");
        }
    }

    private void checkSpouseStatus(Citizen citizen) {
        if (citizen.getSpouse() != null) {
            throw new IllegalArgumentException(citizen.getFullName()
                    + " состоит в отношениях с " + citizen.getSpouse().getFullName());
        }
    }

    //3.4.3
    public void divorce(Citizen citizen1, Citizen citizen2, LocalDate localDate) {
        checkIsMarried(citizen1, citizen2);
        citizen1.setSpouse(null);
        citizen2.setSpouse(null);
        citizen1.setFamilyStatus(DIVORCED);
        citizen2.setFamilyStatus(DIVORCED);
        addRecordingCivilAction(localDate,
                new RecordingCivilAction(localDate, REGISTRATION_DIVORCE, List.of(citizen1, citizen2)));
    }

    private void checkIsMarried(Citizen citizen1, Citizen citizen2) {
        if (!citizen1.getSpouse().equals(citizen2) || !citizen2.getSpouse().equals(citizen1)) {
            throw new IllegalArgumentException("Люди не в отношениях");
        }
    }

    //3.4.4
    public void printStatistic() {
        System.out.printf("Статистика по ЗАГС: %s\n", name);
        for (LocalDate localDate : civilRegistries.keySet()) {
            List<RecordingCivilAction> values = civilRegistries.get(localDate).stream().toList();
            System.out.printf("Дата %s: ", localDate);
            System.out.println(dayStatistic(values));
        }
    }

    private String dayStatistic(List<RecordingCivilAction> values) {
        int wedding = 0;
        int devorce = 0;
        int birth = 0;
        for (RecordingCivilAction value : values) {
            wedding += civilActionCount(value, REGISTRATION_WEDDING);
            devorce += civilActionCount(value, REGISTRATION_DIVORCE);
            birth += civilActionCount(value, REGISTRATION_BIRTH);
        }
        return String.format("количество свадеб - %d, количество разводов - %d, количество рождений - %d",
                wedding, devorce, birth);
    }

    private int civilActionCount(RecordingCivilAction recordingCivilAction, CivilAction civilAction) {
        int count = 0;
        if (recordingCivilAction.getCivilAction().equals(civilAction)) {
            count++;
        }
        return count;
    }
}
