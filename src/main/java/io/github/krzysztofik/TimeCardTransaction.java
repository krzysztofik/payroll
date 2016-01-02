package io.github.krzysztofik;

import java.time.LocalDate;

public class TimeCardTransaction implements Transaction {

    private final LocalDate submissionDate;
    private final int numberOfHours;
    private final int empId;

    public TimeCardTransaction(LocalDate submissionDate, int numberOfHours, int empId) {
        this.submissionDate = submissionDate;
        this.numberOfHours = numberOfHours;
        this.empId = empId;
    }

    @Override
    public void execute() {
        Employee employee = PayrollDatabase.getEmployee(empId);

        if (employee != null) {
            if (employee.getClassification() instanceof HourlyClassification) {
                HourlyClassification hourlyClassification = (HourlyClassification) employee.getClassification();
                hourlyClassification.addTimeCard(new TimeCard(submissionDate, numberOfHours));
            }
            else
                throw new IllegalStateException("Tried to add time card non-hourly employee");
        } else
            throw new IllegalArgumentException("No such employee.");
    }
}
