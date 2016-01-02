package io.github.krzysztofik;


import java.math.BigDecimal;
import java.time.LocalDate;

public class ServiceChargeTransaction implements Transaction {

    private final int memberId;
    private final LocalDate time;
    private final BigDecimal charge;

    public ServiceChargeTransaction(int id, LocalDate time, BigDecimal charge)
    {
        this.memberId = id;
        this.time = time;
        this.charge = charge;
    }

    public void execute() {
        Employee employee = PayrollDatabase.getUnionMember(memberId);

        if (employee != null) {
            UnionAffiliation unionAffiliation = null;
            if (employee.affiliation instanceof UnionAffiliation) {
                unionAffiliation = (UnionAffiliation) employee.affiliation;
            }

            if (unionAffiliation != null) {
                unionAffiliation.addServiceCharge(new ServiceCharge(time, charge));
            } else {
                throw new IllegalStateException("Tries to add service charge to union"
                        + "member without a union affiliation");
            }
        } else
            throw new IllegalArgumentException("No such union member.");
    }
}
