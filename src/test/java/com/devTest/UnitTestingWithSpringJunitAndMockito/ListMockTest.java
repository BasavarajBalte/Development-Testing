package com.devTest.UnitTestingWithSpringJunitAndMockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.List;


public class ListMockTest {

    List<String> mockList = Mockito.mock(List.class);

    @Test
    public void list_size_test() {
       Mockito.when(mockList.size()).thenReturn(5);
        Assertions.assertEquals(5, mockList.size());
    }

    @Test
    public void returnDiffValueOnCallTest() {
        Mockito.when(mockList.size()).thenReturn(5).thenReturn(10);
        Assertions.assertEquals(5, mockList.size());
        Assertions.assertEquals(10, mockList.size());
    }

    @Test
    public void returnValueOfListIndex() {
        Mockito.when(mockList.get(0)).thenReturn("First");
        Assertions.assertEquals("First",mockList.get(0));
        //Assertions.assertEquals("First",mockList.get(1)); //Test fails
        Assertions.assertEquals(null,mockList.get(1));
    }

    @Test
    public void returnValueOfListAnyIndex() {
        Mockito.when(mockList.get(Mockito.anyInt())).thenReturn("First");
        Assertions.assertEquals("First",mockList.get(0));
        //Assertions.assertEquals("First",mockList.get(1)); //Test fails
        Assertions.assertEquals("First",mockList.get(1));
    }

    @Test
    public void verificationFunctionCall() {
        String firstValue = mockList.get(0);
        String secondValue = mockList.get(1);
        Mockito.verify(mockList).get(0);
        //verify get(1) method called 2 time on mocklist
     //   Mockito.verify(mockList,Mockito.times(2)).get(1);
        Mockito.verify(mockList, Mockito.atLeast(1)).get(0);
        Mockito.verify(mockList, Mockito.atLeastOnce()).get(1);
        Mockito.verify(mockList, Mockito.atLeastOnce()).get(Mockito.anyInt());
    }

    @Test
    public void argumentCapturing() {
        mockList.add("newValue");
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        Mockito.verify(mockList).add(captor.capture());
        Assertions.assertEquals("newValue", captor.getValue());
    }

    @Test
    public void multiArgumentCapturing() {
        mockList.add("newValue1");
        mockList.add("newValue2");
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        Mockito.verify(mockList, Mockito.times(2)).add(captor.capture());
        List<String> argList = captor.getAllValues();
        Assertions.assertEquals("newValue1", argList.get(0));
        Assertions.assertEquals("newValue2", argList.get(1));
    }
}
