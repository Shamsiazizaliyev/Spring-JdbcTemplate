package az.spring.jdbc.dao;

import az.spring.jdbc.model.Employe;

import java.util.List;

public interface EmployeDao {

    void insert(Employe employe);

    void update(Employe employe);

    void delte(int id);

    Employe getEmploye(int id);

    List<Employe> getAllEmployes();

    Long count();
}
