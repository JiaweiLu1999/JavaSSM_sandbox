import com.jiawei.spring_jdbc.pojo.Department;
import com.jiawei.spring_jdbc.service.DeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestJdbcTemplateService {
    @Autowired
    private DeptService deptService;

    @Test
    public void testService() {
        List<Department> allDept = deptService.getAllDept();
        for (Department department : allDept) {
            System.out.println(department);
        }
    }
}
