package com.example.comp1011st1178551test1;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeSet;
public class DBUtility {
    private static String user = "Spencerlaksrclough";
    private static String password = "cHZFbQmpR4";
    private static String connectUrl = "jdbc:mysql://172.31.22.43:3306/Spencerlaksrclough";

    public static ArrayList<Employee> getEmployees(){
        ArrayList<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        String responseMsg;
        try(
                Connection conn = DriverManager.getConnection(connectUrl, user,password);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                LocalDate birthday = resultSet.getDate("birthday").toLocalDate();
                String department = resultSet.getString("department");
                String email = resultSet.getString("email");
                double salary = resultSet.getDouble("salary");
                try{
                    Employee employee = new Employee(id,firstName,lastName,birthday,department,email,salary);
                    employees.add(employee);
                }
                catch (IllegalArgumentException e){
                    e.printStackTrace();
                    System.out.println("Employee was not valid");
                }
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return employees;
    }

}
