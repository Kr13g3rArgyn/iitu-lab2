package org.example.models;

public class University {
    private int id;
    private String uni_name;

    public University(){

    }
    public University(String uniName){
        this.uni_name = uniName;
    }


    public University(int university, String uni_name) {
        this.id = university;
        this.uni_name = uni_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUni_name() {
        return uni_name;
    }

    public void setUni_name(String uni_name) {
        this.uni_name = uni_name;
    }
}
