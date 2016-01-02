package io.github.krzysztofik;


import java.time.LocalDate;

public class TimeCard implements Chronable {

    private final int hours;

    private final LocalDate date;

    public TimeCard(LocalDate date, int hours) {
        this.hours = hours;
        this.date = date;
    }

    public int getHours() {
        return hours;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || !(object instanceof TimeCard))
            return false;
        TimeCard anotherTimeCard = (TimeCard) object;
        return isCreated(anotherTimeCard.date)
            && hours == anotherTimeCard.getHours();
    }

    @Override
    public LocalDate getCreated() {
        return date;
    }
}
