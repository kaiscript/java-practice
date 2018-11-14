package com.kaiscript;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

/**
 * Created by kaiscript on 2017/10/14.
 */
public class MockitoTest{

    @Test
    public void test() {
        List mock = Mockito.mock(List.class);
        Mockito.when(mock.get(0)).thenReturn("one");
        System.out.println(mock.get(0));
        mock.add("123");
        Mockito.verify(mock).add("123");
    }

}
