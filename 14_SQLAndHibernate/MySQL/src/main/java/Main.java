import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "testtest";
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery("SELECT distinct course_name,\n" +
                    "count(course_name) / (month(max(subscription_date)) - month(min(subscription_date)) + 1)  AS number_purchases\n" +
                    "FROM PurchaseList \n" +
                    "group by course_name; ");
            while (result.next()){
                System.out.println(result.getString("course_name") + " - " + result.getString("number_purchases"));
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
