import Entity.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GroupEmployeeByEmailDomain {
    public List<Employee> initializeEmployee() {

        return Arrays.asList(
                new Employee.Builder().id(1).name("Alice").email("alice@gmail.com").build(),
                new Employee.Builder().id(2).name("Bob").email("bob@yahoo.com").build(),
                new Employee.Builder().id(3).name("Charlie").email("charlie@gmail.com").build(),
                new Employee.Builder().id(4).name("David").email("david@outlook.com").build(),
                new Employee.Builder().id(5).name("Eve").email("eve@yahoo.com").build()
        );

    }

    public String getDomain(String email) {
        return email.substring(email.lastIndexOf("@") + 1);
    }

    public void groupEmployeeByDomain(List<Employee> employees) {
        employees.stream()
                .collect(Collectors.groupingBy(e -> getDomain(e.getEmail())))
                .forEach((domain, list) -> System.out.println(domain + ":" + list));
    }
}
