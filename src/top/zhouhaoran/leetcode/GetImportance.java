package top.zhouhaoran.leetcode;

import java.util.*;

public class GetImportance {
    public static void main(String[] args) {
        GetImportance getImportance = new GetImportance();
        Employee employee1 = new Employee(); employee1.id = 1; employee1.importance = 5;
        Employee employee2 = new Employee(); employee2.id = 2; employee2.importance = 3;
        Employee employee3 = new Employee(); employee3.id = 3; employee3.importance = 3;
        employee1.subordinates = Arrays.asList(2, 3);
        List<Employee> employees = Arrays.asList(employee1, employee2, employee3);
        System.out.println(getImportance.getImportance(employees, 1));
    }

    private int sum = 0;
    public int getImportance(List<Employee> employees, int id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).id == id) {
                sum += employees.get(i).importance;
                if (employees.get(i).subordinates != null && employees.size() != 0) {
                    for (int j = 0; j < employees.get(i).subordinates.size(); j++) {
                        getImportance(employees, employees.get(i).subordinates.get(j));
                    }
                }
            }
        }

        return sum;
    }

    Map<Integer, Employee> map;
    public int getImportance2(List<Employee> employees, int id) {
        map = new HashMap<>();

        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }

        return getImportanceDFS(id);
    }

    private int getImportanceDFS(int queryid) {
        Employee employee = map.get(queryid);
        int sum = employee.importance;

        for (int subId : employee.subordinates) {
            sum += getImportanceDFS(subId);
        }

        return sum;
    }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}