package org.example.models;

public class Student {
    private int id;
    private String fname;
    private String lname;
    private int age;
    private int university;

    public Student (String fname, String lname, int age, int university){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = Integer.parseInt(university);
    }

    public Student(int id, String fname, String lname, int age, int university) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.university = university;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", age=" + age +
                ", University='" + university + '\'' +
                '}';
        }
}
