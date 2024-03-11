package org.javaacademy.profession;

import lombok.Data;
import lombok.NonNull;

@Data
public class Task {
    @NonNull
    final String name;
    final int numberHoursPerTask;
    boolean isDone;
}
