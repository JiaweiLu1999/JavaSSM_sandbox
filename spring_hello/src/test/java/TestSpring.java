import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.jiawei.spring.config.SpringConfig;
import com.jiawei.spring.pojo.Department;
import com.jiawei.spring.pojo.Employee;
import com.jiawei.spring.pojo.Student;
import com.jiawei.spring.service.impl.DepartmentServiceImpl;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;


public class TestSpring {
    @Test
    public void testStudent() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
        Student student = context.getBean("student-02", Student.class);
        System.out.println(student);
    }

    @Test
    public void testEmployee() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Employee empLu = context.getBean("empLu", Employee.class);
        System.out.println(empLu);
        Department deptPython = context.getBean("deptPython", Department.class);
        System.out.println(deptPython);
    }

    @Test
    public void testDruid() throws SQLException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DruidDataSource dataSource = context.getBean("dataSource", DruidDataSource.class);
        DruidPooledConnection connection = dataSource.getConnection();
        System.out.println(connection );

        Department factoryBean = context.getBean("factoryBean", Department.class);
        System.out.println(factoryBean);
    }

    @Test
    public void testAutowire() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appContextAutowire.xml");
        DepartmentServiceImpl service = context.getBean("deptService", DepartmentServiceImpl.class);
        service.saveDepartment(new Department());
    }

    @Test
    public void testAnnotation() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appContextAnnotation.xml");
        DepartmentServiceImpl departmentService = context.getBean("departmentServiceImpl", DepartmentServiceImpl.class);
        departmentService.saveDepartment(new Department());
    }

    @Test
    public void testNoXml() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        DepartmentServiceImpl departmentServiceImpl = context.getBean("departmentServiceImpl", DepartmentServiceImpl.class);
        departmentServiceImpl.saveDepartment(new Department());
    }
}
