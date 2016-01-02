package io.github.krzysztofik;

import java.util.HashMap;
import java.util.Map;

public class PayrollDatabase
{
    private static Map<Integer, Employee> employees = new HashMap<>();
    private static Map<Integer, Integer> unionMembers = new HashMap<>();

    public static void addEmployee(int id, Employee employee) {
        employees.put(id, employee);
    }

    public static Employee getEmployee(int id) {
        return employees.get(id);
    }

    public static void deleteEmployee(int id) {
        employees.remove(id);
    }

    public static void addUnionMember(int memberId, Employee employee) {
        unionMembers.put(memberId, employee.getEmpId());
    }

    public static Employee getUnionMember(int memberId) {
        if (unionMembers.get(memberId) != null)
            return employees.get(unionMembers.get(memberId));
        return null;
    }
}
