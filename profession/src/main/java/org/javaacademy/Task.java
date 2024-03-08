package org.javaacademy;

import lombok.*;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString(includeFieldNames = false)
public class Task {
    final String name;
    final int numberHoursPerTask;
    boolean isDone;
}
