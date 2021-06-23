package com.epam;

import org.junit.Test;
import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;



public class TodoServiceMockitoTest {
@Test
public void testTodoService() {
	List<String> stringList = Arrays.asList("Java");
	List<String> invalidStringList = Arrays.asList("test", "test12", "test123");
	TodoService testService=mock(TodoService.class);

	when(testService.retrieveTodos("s1")).thenReturn(stringList);
	assertEquals("Java",testService.retrieveTodos("s1").get(0));
	
	
}
}
