package kernel.spring.DI.javaconfig;

import kernel.spring.DI.model.Book;
import kernel.spring.DI.model.CEO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by kernel on 2016/6/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {ExpressiveConfig.class})
@ContextConfiguration(locations = "classpath:conf/spring/applicationContext-root.xml")
public class ExpressiveConfigTest {

    @Autowired
    private CEO ceo;

    @Autowired
    private Book book;

    @Test
    public void test(){

        Assert.assertNotNull(ceo);
    }

    @Test
    public void testBook(){
        System.out.println("book.name[" + book.getBookName() + "]");
        System.out.println("author.name[" + book.getAuthorName() + "]");
        Assert.assertNotNull(book);
    }
}