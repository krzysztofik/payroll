package io.github.krzysztofik;


import java.time.LocalDate;

public interface Chronable {

    LocalDate getCreated();

    default boolean isCreated(LocalDate date) {
        return getCreated().isEqual(date);
    }
}
