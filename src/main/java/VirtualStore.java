import db.DatabaseWrapper;
import model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;


public class VirtualStore {

    public static void main(String[] args) throws SQLException, IOException {
        DatabaseWrapper databaseWrapper = new DatabaseWrapper();

//        databaseWrapper.connect();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String menu = "1. Create table customer\n" +
                "2. Insert customer\n" +
                "3. Show all customers \n" +
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
                    databaseWrapper.createCustomerTable();
                    break;
                case 2:
                    break;
                case 3:
                    for (Customer customer : databaseWrapper.showAllCustomers()) {
                        System.out.println(customer.getName());
                    }
                    break;
                case 4:
                    for (int i = 0; i < 5; i++) {
                        Customer customer = new Customer();
                        customer.setName("Customer_" + i);
                        databaseWrapper.insertIntoCustomer(customer);
                    }
                    break;
                case 5:
                    databaseWrapper.updateCustomerName(1,"Ion");
                    break;
                case 6:
                    databaseWrapper.deleteAll("customer");
                    break;
                case 7:
                    databaseWrapper.dropTable("customer");
                    break;
                case 8:
                    EntityManagerFactory entityManagerFactory =
                            Persistence.createEntityManagerFactory("Virtual_Store");
                    EntityManager entityManager = entityManagerFactory.createEntityManager();
                    break;

            }
            System.out.println(menu);
            option = bufferedReader.readLine();
        }
    }
}
