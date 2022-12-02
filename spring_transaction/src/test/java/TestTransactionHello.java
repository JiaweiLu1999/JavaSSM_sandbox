import com.jiawei.spring_transaction.service.BookshopService;
import com.jiawei.spring_transaction.service.CashierService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
@ExtendWith(SpringExtension.class)
public class TestTransactionHello {
    @Autowired
    private BookshopService bookshopService;
    @Autowired
    private CashierService cashierService;
    @Test
    public void testTransaction() {
        bookshopService.purchase("chenhao", "1001");
    }

    @Test
    public void testTransactionTwo() {
        List<String> isbnList = new ArrayList<>();
        isbnList.add("1001");
        isbnList.add("1002");
        cashierService.checkout("jiawei", isbnList);
    }
}
