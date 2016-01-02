package io.github.krzysztofik;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class ListSeeker {

    static <T extends Chronable> Optional<T> findFirstByDate(List<T> list, LocalDate date) {
        return list.stream().filter(it -> it.isCreated(date)).findFirst();
    }

    static <T> Optional<T> findFirstByCondition(List<T> list, Predicate<T> predicate) {
        return list.stream().filter(predicate).findFirst();
    }
}
