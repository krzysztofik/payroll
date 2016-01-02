package io.github.krzysztofik

import spock.lang.Specification

import static java.time.LocalDate.of


class ServiceChargeSpec extends Specification {

    final static int EMPLOYEE_ID = 1
    final static int MEMBER_ID = 86

    def "Add service charge"() {
        given: "employee affiliated with union"
            Employee employee = createEmployee()
            UnionAffiliation unionAffiliation = new UnionAffiliation()
            employee.affiliation = unionAffiliation
            PayrollDatabase.addUnionMember(MEMBER_ID, employee)

        when: "charge employee for service"
            ServiceChargeTransaction serviceChargeTransaction = new ServiceChargeTransaction(
                                                                MEMBER_ID, of(2005, 8, 8), 12.95)
            serviceChargeTransaction.execute()

        then: "union member has service charge record with correct amount"
            ServiceCharge serviceCharge = unionAffiliation.getServiceCharge(of(2005, 8, 8))
            serviceCharge.amount == 12.95
    }

    private Employee createEmployee() {
        AddHourlyEmployee addHourlyEmployee = new AddHourlyEmployee(EMPLOYEE_ID, "Bill", "Home", 15.25)
        addHourlyEmployee.execute()
        return PayrollDatabase.getEmployee(EMPLOYEE_ID)
    }
}
