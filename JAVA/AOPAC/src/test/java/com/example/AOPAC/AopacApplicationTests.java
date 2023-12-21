package com.example.AOPAC;

import com.example.AOPAC.javaJDBC.entitymanager.PersonEntityManager;
import com.example.AOPAC.javaJDBC.Entity.person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = AopacApplication.class)
class AopacApplicationTests {


	public int getsum(int a, int b){
		return a*b;
	}
	@Test
	void contextLoads() {
		assertEquals(6,getsum(3,2),"something went wrong");
	}

	@Autowired
	PersonEntityManager personEntityManager;

@Test
	public void findByid(){
		person Person= personEntityManager.personDetails(2);
		assertEquals("E",Person.getName());
		System.out.println("found");

}

@Test
@DirtiesContext
//this annotation used to reset the data after testing the function
	public void deletebyid(){
	personEntityManager.deleteDetails(5);
	assertNull(personEntityManager.personDetails(5));
}


}
