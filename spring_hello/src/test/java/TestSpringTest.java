import com.jiawei.spring.config.SpringConfig;
import com.jiawei.spring.pojo.Department;
import com.jiawei.spring.service.DepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = SpringConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestSpringTest {
    @Autowired
    private DepartmentService departmentServiceImpl;

    @Test
    public void testSpringTest() {
        departmentServiceImpl.saveDepartment(new Department());
    }
}
