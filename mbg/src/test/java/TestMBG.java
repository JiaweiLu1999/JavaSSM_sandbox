import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiawei.mybatis.mapper.EmployeeMapper;
import com.jiawei.mybatis.pojo.Employee;
import com.jiawei.mybatis.pojo.EmployeeExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMBG {
    String resource = "mybatis-config.xml";
    @Test
    public void testMBG() throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("src/main/resources/mbg.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }

    @Test
    public void testCURD() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSession session = new SqlSessionFactoryBuilder().build(inputStream).openSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        EmployeeExample ee = new EmployeeExample();
//        EmployeeExample.Criteria criteria = ee.createCriteria();
//        Integer[] arr = new Integer[]{1, 5};
//        ArrayList<Integer> ids = new ArrayList<>(Arrays.asList(arr));
//        criteria.andIdIn(ids);
//
        Page<Object> page = PageHelper.startPage(1, 3);
        List<Employee> employees = mapper.selectByExample(ee);

        PageInfo<Employee> info = new PageInfo<>(employees, 5);
        System.out.println(info.getPageNum() + "/" + info.getPages());
        for (Employee employee : info.getList()) {
            System.out.println(employee);
        }

        for (int navigatepageNum : info.getNavigatepageNums()) {
            System.out.println(navigatepageNum);
        }


    }
}
