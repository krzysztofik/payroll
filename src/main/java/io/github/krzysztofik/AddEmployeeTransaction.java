package io.github.krzysztofik;

public abstract class AddEmployeeTransaction implements Transaction {
    private final int empId;
    private final String name;
    private final String address;

    public AddEmployeeTransaction(int empId, String name, String address) {
        this.empId = empId;
        this.name = name;
        this.address = address;
    }

    protected abstract PaymentClassification makeClassification();

    protected abstract PaymentSchedule makeSchedule();

    public void execute() {
        PaymentClassification paymentClassification = makeClassification();
        PaymentSchedule paymentSchedule = makeSchedule();
        PaymentMethod paymentMethod = new HoldMethod();

        Employee employee = new Employee(empId, name, address);
        employee.setClassification(paymentClassification);
        employee.setSchedule(paymentSchedule);
        employee.setMethod(paymentMethod);
        PayrollDatabase.addEmployee(empId, employee);
    }
}
