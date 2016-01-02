package io.github.krzysztofik;


class DeleteEmployeeTransaction implements Transaction {

    private final int empId;

    DeleteEmployeeTransaction(int empId) {
        this.empId = empId;
    }

    @Override
    public void execute() {
        PayrollDatabase.deleteEmployee(empId);
    }
}
