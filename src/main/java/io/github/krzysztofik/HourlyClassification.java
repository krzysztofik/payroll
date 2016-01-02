package io.github.krzysztofik;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static io.github.krzysztofik.ListSeeker.findFirstByDate;


public class HourlyClassification implements PaymentClassification {

    private final List<TimeCard> timeCards = new ArrayList<>();
    private BigDecimal salary;

    public void addTimeCard(TimeCard timeCard) {
         this.timeCards.add(timeCard);
    }

    public HourlyClassification(BigDecimal salaryPerHour) {
        this.salary = salaryPerHour;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public TimeCard getTimeCard(LocalDate date) {
        return findFirstByDate(timeCards, date).get();
    }
}
