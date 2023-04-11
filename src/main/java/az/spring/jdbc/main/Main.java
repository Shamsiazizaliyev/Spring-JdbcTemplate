package az.spring.jdbc.main;

import az.spring.jdbc.config.JdbcConfig;
import az.spring.jdbc.dao.EmployeDao;
import az.spring.jdbc.model.Employe;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {


    public static void main(String[] args) {


        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);


        EmployeDao bean = context.getBean(EmployeDao.class);
        Employe e = new Employe();
        e.setAge(20);
        e.setName("asif");
        e.setSurname("qasimov");
        e.setSalary(3000);
        System.out.println(bean.getAllEmployes());


    }
}
