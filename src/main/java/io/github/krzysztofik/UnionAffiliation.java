package io.github.krzysztofik;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static io.github.krzysztofik.ListSeeker.findFirstByDate;

public class UnionAffiliation implements Affiliation {

    private final List<ServiceCharge> serviceCharges = new ArrayList<>();

    public void addServiceCharge(ServiceCharge serviceCharge) {
        serviceCharges.add(serviceCharge);
    }

    public ServiceCharge getServiceCharge(LocalDate date) {
        return findFirstByDate(serviceCharges, date).get();
    }
}
