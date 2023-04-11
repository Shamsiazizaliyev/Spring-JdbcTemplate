package az.spring.jdbc.dao;


import az.spring.jdbc.model.Employe;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public class EmployeDaoIpml implements EmployeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public EmployeDaoIpml(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void insert(Employe employe) {

        String sql = "insert into employe(name,surname,age,salary)\n" +
                "values(?,?,?,?)";

        jdbcTemplate.update(sql, employe.getName(), employe.getSurname(), employe.getAge(), employe.getSalary());

    }

    @Override
    public void update(Employe employe) {

        String sql = "update  employe set name=?, surname=?,age=?,salary=?" +
                "where id=?";

        jdbcTemplate.update(sql, new Object[]{employe.getName(), employe.getSurname(), employe.getAge(), employe.getSalary(), employe.getId()});

    }

    @Override
    public void delte(int id) {

        String sql = "update employe set active=0\n" +
                "where id=?";
        jdbcTemplate.update(sql, new Object[]{id});

    }

    @Override
    public Employe getEmploye(int id) {

        String sql = "SELECT * FROM employe\n" +
                "where  id=?";


        List<Employe> employe = jdbcTemplate.query(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Employe.class));
        if (employe.isEmpty()) {
            return null;
        }
        return employe.get(0);
    }


    @Override
    public List<Employe> getAllEmployes() {


        String sql = "SELECT * FROM employe\n" +
                "where active=1";
        List<Employe> employeList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Employe.class));

        return employeList;
    }

    @Override
    public Long count() {


        return jdbcTemplate.queryForObject("select count(*) from employe", Long.class);
    }


}
