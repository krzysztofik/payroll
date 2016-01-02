package io.github.krzysztofik;

import java.math.BigDecimal;
import java.time.LocalDate;


public class SalesReceipt implements Chronable {
    private final LocalDate salesDate;
    private final BigDecimal salesAmount;

    public SalesReceipt(LocalDate salesDate, BigDecimal salesAmount) {
        this.salesDate = salesDate;
        this.salesAmount = salesAmount;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || !(object instanceof SalesReceipt))
            return false;
        SalesReceipt anotherSalesReceipt = (SalesReceipt) object;
        return isCreated(anotherSalesReceipt.salesDate)
            && salesAmount.compareTo(anotherSalesReceipt.salesAmount) == 0;
    }

    @Override
    public LocalDate getCreated() {
        return salesDate;
    }
}
