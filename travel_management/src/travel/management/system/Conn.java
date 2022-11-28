package travel.management.system;
import java.sql.*;

public class Conn {
    //MySQL is an external entity not belonging to this project
    //JDBC is a JAVA API that is responsible for connecting to databases
    //1.Register the driver class
    //2.Creating the connection string
    //3.Creating the statement
    //4.Executing MySQL queries


    //In the DB, create database TravelManagement;
    //show databases;
    //use TravelManagement;
    Connection c;
    Statement s;
    Conn(){
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/TravelManagement","root","mysqlpassword");
            s = c.createStatement();
            //We are executing MySQL queries via JAVA Code
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
