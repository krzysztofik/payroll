package io.github.krzysztofik;


public class Employee {

    private final int empId;

    private String name;
    private String address;
    private PaymentMethod method;
    private PaymentSchedule schedule;
    private PaymentClassification classification;
    public Affiliation affiliation;
    public Employee(int empId, String name, String address) {
        this.empId = empId;
        this.name = name;
        this.address = address;
    }

    public int getEmpId() {
        return empId;
    }

    public void setClassification(PaymentClassification classification) {
        this.classification = classification;
    }

    public void setSchedule(PaymentSchedule schedule) {
        this.schedule = schedule;
    }

    public void setMethod(PaymentMethod method) {
        this.method = method;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public PaymentClassification getClassification() {
        return classification;
    }

    public PaymentSchedule getSchedule() {
        return schedule;
    }

    public PaymentMethod getMethod() {
        return method;
    }
}
