package com.role.implementation.DTO;

public class StudentDegreeDTO {

    private String dname;
    private int age;
    private Long phone_no;
    private String location;
    private String gender;

public StudentDegreeDTO() {
    }
      

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Long getPhone_no() {
        return phone_no;
    }
    public void setPhone_no(Long phone_no) {
        this.phone_no = phone_no;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getDname() {
        return dname;
    }


    public void setDname(String dname) {
        this.dname = dname;
    }
    

    
}
