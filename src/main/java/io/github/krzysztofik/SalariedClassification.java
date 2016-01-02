package io.github.krzysztofik;

import java.math.BigDecimal;

public class SalariedClassification implements PaymentClassification {

    private BigDecimal salary;

    public SalariedClassification(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getSalary() {
        return salary;
    }
}
