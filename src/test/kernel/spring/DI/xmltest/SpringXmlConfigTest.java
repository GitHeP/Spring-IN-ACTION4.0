package kernel.spring.DI.xmltest;

import kernel.spring.DI.implemation.Company;
import kernel.spring.DI.model.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by kernel on 2016/6/10.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:conf/spring/applicationContext-*"})
public class SpringXmlConfigTest {

    @Autowired
    private Book book;

    @Autowired
    private Company company;

    @Value("${book.name}")
    private String bookName;

    @Value("${author.name}")
    private String authorName;

    @Test
    public void testConstructorAutowired(){

        System.out.println(company.getCeo().getCompanyName());
        System.out.println(company.getCeo().getCeoName());
        Assert.assertNotNull(company);
    }

    @Test
    public void testBook(){
        System.out.println("book.name[" + book.getBookName() + "]");
        System.out.println("author.name[" + book.getAuthorName() + "]");
        Assert.assertNotNull(book);
    }
}

