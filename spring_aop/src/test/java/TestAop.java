import com.jiawei.spring_aop.example.Calc;
import com.jiawei.spring_aop.config.MyConfig;
import com.jiawei.spring_aop.example.impl.CalcImpl;
import com.jiawei.spring_aop.proxy.MyProxy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


public class TestAop {

    @Test
    public void testAop() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Calc calc = context.getBean("calc", Calc.class);
        calc.add(1, 2);
        calc.sub(1, 2);
    }
}
