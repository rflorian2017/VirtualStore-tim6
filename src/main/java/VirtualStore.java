import db.repository.EmployeeRepository;
import model.Customer;
import model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Optional;


public class VirtualStore {

    public static void main(String[] args) throws SQLException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("Virtual_Store");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EmployeeRepository employeeRepository = new EmployeeRepository(entityManager);

        String menu = "1. Find by id\n" +
                "2. Insert employee\n" +
                "3. Delete by id \n" +
                "4. Show all employees \n" +
                "5. Show employee by name\n" +
                "6. Delete records from table by name \n" +
                "7. Drop table\n";
        System.out.println(menu);
        String option = bufferedReader.readLine();
        while (!option.equals("-1")) {

            int chosenOption = Integer.parseInt(option);

            switch (chosenOption) {
                case 1:
                    System.out.print("Give id to search for: ");
                    String searchId = bufferedReader.readLine();

                    Optional optional = employeeRepository.findById(Integer.parseInt(searchId));
                    Employee search_employee = (Employee) optional.get();

                    System.out.print("Give new name: ");
                    String new_name = bufferedReader.readLine();
                    search_employee.setName(new_name);
                    employeeRepository.save(search_employee);

                    System.out.println(search_employee.getId() + " " + search_employee.getName());
                    break;
                case 2:
//                    System.out.println(entityManager.getClass());
                    Employee employee = new Employee();
                    System.out.println(employee.getClass());
                    System.out.print("Give name: ");
                    String employee_name = bufferedReader.readLine();
                    employee.setName(employee_name);

                    employeeRepository.save(employee);
                    break;
                case 3:
                    System.out.print("Give id to delete: ");
                    String deleteId = bufferedReader.readLine();
                    employeeRepository.deleteById(Integer.parseInt(deleteId));
                    break;
                case 4:
                    for (Employee e : employeeRepository.findAll()) {
                        System.out.println(e.getId() + " " + e.getName());
                    }
                    System.out.println();
                    break;
                case 5:
                    System.out.print("Give name: ");
                    String readName = bufferedReader.readLine();
                    for (Employee e : employeeRepository.findByName(readName)) {
                        System.out.println(e.getId() + " " + e.getName());
                    }
                    System.out.println();
                    break;
                case 6:
                    System.out.print("Give name to delete: ");
                    String deleteName = bufferedReader.readLine();
                    employeeRepository.deleteByName(deleteName);
                    break;
                case 7:

                    break;
                case 8:

                    break;

            }
            System.out.println(menu);
            option = bufferedReader.readLine();
        }
    }
}
