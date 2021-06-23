package com.epam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@RunWith(MockitoJUnitRunner.class)  

public class MockAnnotationTestService {

	@InjectMocks  
	TodoBusinessImpl mockimplementation;   
	@Mock  
	TodoService mockservice;  	      
	@Captor  
	ArgumentCaptor<String> CaptorService;  
	@Spy  
	ArrayList<String> SpyArrayList;  


	@Test   
	public void deleteTodoService() {  

		// Given   
		List<String> combinedlist = Arrays.asList("Java",  
				"Python", "AWS", "Azure");  

		when(mockservice.retrieveTodos("dummy")).thenReturn(combinedlist) ;

		SpyArrayList.add("Testmyservice");  
		SpyArrayList.add("TestJava");  

		mockimplementation.deleteTodosNotRelated("dummy");  
		verify(SpyArrayList).add("Testmyservice");  
		verify(mockservice, times(1)).deleteTodo("Python");  
		verify(mockservice, never()).deleteTodo("Java");  


		assertEquals(2, SpyArrayList.size());  

	}  

	@Test   
	public void deleteTodoCaptor() {  

		List<String> combinedlist = Arrays.asList("Java6",  
				"Java7", "Java8", "Azure"); 
		when(mockservice.retrieveTodos("dummy")).thenReturn(combinedlist) ; 

		mockimplementation.deleteTodosNotRelated("dummy");  

		verify(mockservice).deleteTodo(CaptorService.capture());  
		assertEquals(CaptorService.getValue(),"Azure");  

	}  
}  