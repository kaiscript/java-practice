package mock;

import com.google.common.collect.Lists;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

/**
 * BookDAL Tester.
 *
 * @author <Authors name>
 * @version 1.0
 */
public class BookDALTest {

    BookDAL bookDAL;

    @Before
    public void before() throws Exception {
        bookDAL = Mockito.mock(BookDAL.class);
        List<Book> list = Lists.newArrayList();
        list.add(new Book(1, "2"));
        Mockito.when(bookDAL.getBooks()).thenReturn(list);
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getBooks()
     */
    @Test
    public void testGetBooks() throws Exception {
        System.out.println(bookDAL.getBooks().size());
    }


} 
