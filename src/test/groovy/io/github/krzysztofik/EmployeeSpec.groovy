package io.github.krzysztofik

import spock.lang.Specification

import java.time.LocalDate

import static java.math.BigDecimal.valueOf
import static java.time.LocalDate.of
import static java.time.Month.JANUARY

class EmployeeSpec extends Specification {

    final static int EMPLOYEE_ID = 1
    final static String employeeName = 'Tonny'
    final static String employeeAddress = 'Warsaw'
    final static BigDecimal salary = valueOf(1000.00)
    final static LocalDate TIME_CARD_DATE = of(1015, JANUARY, 1)
    final static int WORKED_HOURS = 8

    def "add new salaried employee"() {
        given: "new candidate for salaried employee"
            Transaction transaction = new AddSalariedEmployee(EMPLOYEE_ID, employeeName, employeeAddress, salary)

        when: "successfully add new salaried employee"
            transaction.execute()

        then: "system contains new employee with following details"
            Employee employee = PayrollDatabase.getEmployee(EMPLOYEE_ID);
            assert employee.name == employeeName
            assert employee.address == employeeAddress

        and: "employee is classified as salaried"
            PaymentClassification paymentClassification = employee.classification
            assert paymentClassification instanceof SalariedClassification
            assert (paymentClassification as SalariedClassification).salary == salary

        and: "has monthly payment schedule"
            PaymentSchedule paymentSchedule = employee.schedule
            assert paymentSchedule instanceof MonthlySchedule

        and: "has method payment of type Hold"
            PaymentMethod paymentMethod = employee.method
            assert paymentMethod instanceof HoldMethod
    }


    def "delete existing employee"() {
        given: "employee exists in system"
            Transaction transaction = new AddSalariedEmployee(EMPLOYEE_ID, employeeName, employeeAddress, salary)
            transaction.execute()
            assert PayrollDatabase.getEmployee(EMPLOYEE_ID) != null

        when: "submit delete operation on employee"
            DeleteEmployeeTransaction deleteEmployeeTransaction = new DeleteEmployeeTransaction(EMPLOYEE_ID)
            deleteEmployeeTransaction.execute()

        then: "system should not contain employee"
            assert PayrollDatabase.getEmployee(EMPLOYEE_ID) == null
    }

    def "add time card for hourly employee"() {
        given: "hourly employee exists in system"
            Transaction transaction = new AddHourlyEmployee(EMPLOYEE_ID, employeeName, employeeAddress, salary)
            transaction.execute()

        when: "add time card for hourly employee"
            TimeCardTransaction timeCardTransaction = new TimeCardTransaction(TIME_CARD_DATE, WORKED_HOURS, EMPLOYEE_ID)
            timeCardTransaction.execute()

        then: "system should not contain employee"
            Employee employee = PayrollDatabase.getEmployee(EMPLOYEE_ID)
            HourlyClassification hourlyClassification = employee.classification as HourlyClassification
            TimeCard timeCard = hourlyClassification.getTimeCard(TIME_CARD_DATE)
            assert timeCard.hours == 8
    }
}