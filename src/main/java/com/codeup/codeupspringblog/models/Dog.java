//package com.codeup.codeupspringblog.models;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "dogs")
//public class Dog {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "int(11) UNSIGNED")
//    private long id;
//
//    @Column(columnDefinition = "tinyint(3) UNSIGNED", length = 3, nullable = false)
//    private int age;
//
//    @Column(length = 200, nullable = false)
//    private String name;
//    @Column(name = "reside_state", length = 2)
//    private String resideState;
//
//    public Dog() {
//
//    }
//
//    public Dog(int age, String name, String resideState) {
//        this.age = age;
//        this.name = name;
//        this.resideState = resideState;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getResideState() {
//        return resideState;
//    }
//
//    public void setResideState(String resideState) {
//        this.resideState = resideState;
//    }
//}
