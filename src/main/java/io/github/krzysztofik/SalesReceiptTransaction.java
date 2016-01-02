package io.github.krzysztofik;


import java.math.BigDecimal;
import java.time.LocalDate;

public class SalesReceiptTransaction implements Transaction {

    private final LocalDate salesDate;
    private final BigDecimal salesAmount;
    private final int empId;

    public SalesReceiptTransaction(LocalDate salesDate, BigDecimal salesAmount, int empId) {
        this.salesDate = salesDate;
        this.salesAmount = salesAmount;
        this.empId = empId;
    }


    @Override
    public void execute() {
        Employee employee = PayrollDatabase.getEmployee(empId);

        if (employee != null) {
            if (employee.getClassification() instanceof SalariedClassification) {
                CommissionedClassification salariedClassification = (CommissionedClassification) employee.getClassification();
                salariedClassification.addSalesReceipt(new SalesReceipt(salesDate, salesAmount));
            }
            else
                throw new IllegalStateException("Tried to add time card non-salaried employee");
        } else
            throw new IllegalArgumentException("No such employee.");
    }
}
