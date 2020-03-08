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
                "2. Insert customer\n" +
                "3. Delete by id \n" +
                "4. Populate customers \n" +
                "5. Rename Ion\n" +
                "6. Delete records from table \n" +
                "7. Drop table\n";
        System.out.println(menu);
        String option = bufferedReader.readLine();
        while (!option.equals("-1")) {

            int chosenOption = Integer.parseInt(option);

            switch (chosenOption) {
                case 1:
                    Optional optional = employeeRepository.findById(2);
                    Employee search_employee = (Employee)optional.get();

                    search_employee.setName("Gogu");
                    employeeRepository.save(search_employee);

                    System.out.println(search_employee.getId() + " " + search_employee.getName());
                    break;
                case 2:
                    System.out.println(entityManager.getClass());
                    Employee employee = new Employee();
                    System.out.println(employee.getClass());
                    employee.setName("alex");

                    employeeRepository.save(employee);
                    break;
                case 3:
                    employeeRepository.deleteById(3);
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

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
