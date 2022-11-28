import com.jiawei.mybatis.mapper.DepartmentMapper;
import com.jiawei.mybatis.mapper.EmployeeMapper;
import com.jiawei.mybatis.pojo.Department;
import com.jiawei.mybatis.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class TestMybatis {
    String resource = "mybatis-config.xml";
    @Test
    public void testMybatisSelect() {
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream(resource);
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            System.out.println(employeeMapper.getClass().getName());

            Employee employee = employeeMapper.selectEmployeeById(1);
            System.out.println(employee);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testMybatisInsert() throws IOException {
        try (InputStream inputStream = Resources.getResourceAsStream(resource)) {
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(inputStream);
            SqlSession sqlSession = factory.openSession();
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = new Employee(null, "wu", "didi@gmail.com", 5555.0);
            mapper.insertEmployee(employee);
            System.out.println(employee);
            sqlSession.commit();
        }
    }

    @Test
    public void testMybatisDelete() throws IOException {
        try (InputStream inputStream = Resources.getResourceAsStream(resource)) {
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(inputStream);
            SqlSession sqlSession = factory.openSession();
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = new Employee(null, "wang", "cw3355@gmail.com", 8888.0);
            mapper.deleteEmployeeById(4);
            System.out.println(employee);
            sqlSession.commit();
        }
    }

    @Test
    public void testMybatisUpdate() throws IOException {
        try (InputStream inputStream = Resources.getResourceAsStream(resource)) {
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(inputStream);
            SqlSession sqlSession = factory.openSession();
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = new Employee(2, "wang", "cw3355@gmail.com", 8888.0);
            int i = mapper.updateEmployee(employee);
            System.out.println(i);
            sqlSession.commit();
        }
    }

    @Test
    public void testMybatisSelectAll() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        List<Employee> employees = mapper.selectAllEmployee();
        System.out.println(employees);
    }

    @Test
    public void testMybatisSelectAllToMap() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Map<Integer, Employee> integerEmployeeMap = mapper.selectAllEmployeeToMap();
        System.out.println(integerEmployeeMap);
    }

    @Test
    public void testMybatisSelectEmpAndDeptById() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = mapper.selectEmployeeAndDeptById(2);
        System.out.println(employee);
    }

    @Test
    public void testMybatisSelectEmpAndDeptByIdStep() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = mapper.selectEmployeeAndDeptByIdStep(5);
        System.out.println(employee.getLastName());
    }

    @Test
    public void testMybatisSelectDeptAndEmpByIdStep() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
        Department department = mapper.selectDeptAndEmpByDeptId(1);
        System.out.println(department);
    }
}
