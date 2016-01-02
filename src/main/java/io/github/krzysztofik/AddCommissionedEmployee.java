package io.github.krzysztofik;


import java.math.BigDecimal;

public class AddCommissionedEmployee extends AddEmployeeTransaction {

    private final BigDecimal commissionRate;

    public AddCommissionedEmployee(int empId, String name, String address, BigDecimal commissionRate) {
        super(empId, name, address);
        this.commissionRate = commissionRate;
    }

    @Override
    protected PaymentClassification makeClassification() {
        return new CommissionedClassification(commissionRate);
    }

    @Override
    protected PaymentSchedule makeSchedule() {
        return new BiweeklySchedule();
    }
}
