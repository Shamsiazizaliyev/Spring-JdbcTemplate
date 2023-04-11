package az.spring.jdbc.model;


import lombok.Data;

@Data
public class Employe {

    private int id;
    private String name;
    private String surname;
    private int age;
    private double salary;
}
