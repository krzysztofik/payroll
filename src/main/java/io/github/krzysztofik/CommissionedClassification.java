package io.github.krzysztofik;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static io.github.krzysztofik.ListSeeker.findFirstByDate;

public class CommissionedClassification implements PaymentClassification {

    private final BigDecimal commissionRate;
    private final List<SalesReceipt> salesReceipts = new ArrayList<>();

    public CommissionedClassification(BigDecimal commissionRate) {
        this.commissionRate = commissionRate;
    }

    public void addSalesReceipt(SalesReceipt salesReceipt) {
        salesReceipts.add(salesReceipt);
    }

    public SalesReceipt getSalesReceipt(LocalDate date) {
        return findFirstByDate(salesReceipts, date).get();
    }


}
