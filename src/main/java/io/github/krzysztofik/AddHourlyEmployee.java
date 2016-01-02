package io.github.krzysztofik;

import java.math.BigDecimal;

public class AddHourlyEmployee extends AddEmployeeTransaction {

    private final BigDecimal salaryPerHour;

    public AddHourlyEmployee(int empId, String name, String address, BigDecimal salaryPerHour) {
        super(empId, name, address);
        this.salaryPerHour = salaryPerHour;
    }

    @Override
    protected PaymentClassification makeClassification() {
        return new HourlyClassification(salaryPerHour);
    }

    @Override
    protected PaymentSchedule makeSchedule() {
        return new WeeklySchedule();
    }
}
