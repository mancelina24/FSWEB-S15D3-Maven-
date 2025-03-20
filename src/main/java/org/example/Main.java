package org.example;
import org.example.entity.Employee;

import java.util.*;

public class Main {


    public static void main(String[] args) {

        List<Employee> employees = new LinkedList<>();

        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(4, "Burak", "Cevizli"));
        employees.add(null);

        System.out.println("All Records Employees: " + employees);
        System.out.println("Duplicate Employees: " + findDuplicates(employees));
        System.out.println("Unique Employees in Map: " + findUniques(employees));
        System.out.println("After Removing Duplicates: " + removeDuplicates(employees));

    }

    public static List<Employee> findDuplicates(List<Employee> employees) {
        Set<Employee> seen = new HashSet<>();
        List<Employee> dublicates = new LinkedList<>();

        for (Employee emp : employees) {
            if (emp == null) continue;
            if (!seen.add(emp)) {             //Görülmemiş bir eleman mı?
                dublicates.add(emp);
            }
        }
        return dublicates;
    }
    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        Map<Integer, Integer> freqMap = new LinkedHashMap<>();
        for (Employee employee : employees) {
            if (employee == null) { // Null kontrolü ekliyoruz
                continue;
            }
            freqMap.put(employee.getId(), freqMap.getOrDefault(employee.getId(), 0) + 1);
        }
        Map<Integer, Employee> uniques = new LinkedHashMap<>();
        for(Employee employee : employees) {
            if (employee == null) { // Null kontrolü burada da olmalı
                continue;
            }
            if (freqMap.get(employee.getId()) >= 1 && !uniques.containsKey(employee.getId())) {
                uniques.put(employee.getId(), employee);
            }
        }

        return uniques;
    }
    public static List<Employee> removeDuplicates(List<Employee> employees) {
        List<Employee> duplicates = findDuplicates(employees);
        Map<Integer, Employee> uniques = findUniques(employees);
        List<Employee> onlyUnique = new LinkedList<>(uniques.values());
        onlyUnique.removeAll(duplicates);
        return onlyUnique;
    }








}
