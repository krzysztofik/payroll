package io.github.krzysztofik;

import java.math.BigDecimal;

public class AddSalariedEmployee extends AddEmployeeTransaction {

    private final BigDecimal salary;

    public AddSalariedEmployee(int id, String name, String address, BigDecimal salary) {
        super(id, name, address);
        this.salary = salary;
    }

    @Override
    protected PaymentClassification makeClassification() {
        return new SalariedClassification(salary);
    }

    @Override
    protected PaymentSchedule makeSchedule() {
        return new MonthlySchedule();
    }
}
