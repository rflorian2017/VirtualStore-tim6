import model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;


public class VirtualStore {

    public static void main(String[] args) throws SQLException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("Virtual_Store");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

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

                    break;
                case 2:
                    break;
                case 3:

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
