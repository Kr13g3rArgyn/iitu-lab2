package org.example.db;

import org.example.models.Student;
import org.example.models.University;

import java.sql.*;
import java.util.ArrayList;

public class DBManagerStudent {
    public static final String url = "jdbc:postgresql://localhost:5432/postgres";
    public static final String user = "postgres";
    public static final String password = "12345678";
    public static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("Successfully connected with DB!");
        } catch (Exception e) {
            System.out.println("Error with connection with DB!");
            e.printStackTrace();
        }
    }
    public static boolean addStudent(Student student){
        int rows = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(""+
                    "INSERT INTO stud_uni(fname,lname,age,university) values (?,?,?,?)" +
                    ""
                    );
            preparedStatement.setString(1,student.getFname());
            preparedStatement.setString(2,student.getLname());
            preparedStatement.setInt(3,student.getAge());
            preparedStatement.setInt(4,student.getUniversity());
            rows = preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows > 0 ;
    }
    public static int getUniversity(String uni_name){
        int id = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT id from university where uni_name = ? LIMIT 1"
            );
            statement.setString(1,uni_name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                id = resultSet.getInt("id");
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return id;
    }
    public static ArrayList<University> getAllUniversity(){
        ArrayList<University> universities = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "select * from university"
            );
            ResultSet resultSet= statement.executeQuery();
            while (resultSet.next()){
                universities.add(new University(
                        resultSet.getInt("id"),
                        resultSet.getString("uni_name")
                ));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return universities;
    }
    public static ArrayList<Student> getAllStudents(){
        ArrayList<Student> students = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "select st.id, st.fname, st.lname, st.age, u.uni_name " +
                    "from stud_uni st " +
                    "INNER JOIN university u on u.id = st.university " +
                    "ORDER BY st.id ");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                students.add(new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("fname"),
                        resultSet.getString("lname"),
                        resultSet.getInt("age"),
                        new University(
                                resultSet.getString("uni_name")).getId()
                ));
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }
    public static boolean addUniversity(University university ){
        int rows = 0;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(""
                    +
                    "INSERT INTO university(uni_name) values (?)" +
                    ""
            );
            preparedStatement.setString(1, university.getUni_name());

            rows = preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows > 0;
    }

}
