import com.jiawei.spring_jdbc.pojo.Employee;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class TestJdbcTemplate {

    @Test
    public void testJdbcTemplateHello() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);

        String sqlInsert = "insert into department(dept_name) values(?)";
        template.update(sqlInsert, "c#");


    }
    @Test
    public void testJdbcTemplateNew() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);

        BeanPropertyRowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        String sqlQuery = "select * from employee";
        List<Employee> employees = template.query(sqlQuery, rowMapper);
        for (Employee employee : employees) {
            System.out.println(employee);
        }


    }


}
