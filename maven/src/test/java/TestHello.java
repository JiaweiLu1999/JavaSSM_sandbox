import com.jiawei.Hello;
import org.junit.Test;

public class TestHello {
    @Test
    public void testHello() {
        System.out.println(new Hello().sayHello("Maven"));
    }
}
