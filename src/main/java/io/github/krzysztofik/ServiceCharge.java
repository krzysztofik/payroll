package io.github.krzysztofik;

import java.math.BigDecimal;
import java.time.LocalDate;


public class ServiceCharge implements Chronable {

    private final LocalDate created;

    public BigDecimal getAmount() {
        return amount;
    }

    private final BigDecimal amount;

    public ServiceCharge(LocalDate time, BigDecimal charge) {
        this.created = time;
        this.amount = charge;
    }

    @Override
    public LocalDate getCreated() {
        return created;
    }
}
