package tn.esprit.spring.serviceTest;


import static org.junit.Assert.assertEquals;


import java.text.ParseException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.IEmployeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployesServiceTest {

	@Autowired 
	IEmployeService es; 

/*Ajout*/
	@Test
	public void testAddEmploye() throws ParseException {
		
		Employe e = new Employe(0, "Wiem", "Taleb", null, null, false, Role.CHEF_DEPARTEMENT); 
		Employe emplyeAdded = es.addOrUpdateEmploye(e);
		assertEquals(e.getNom(), emplyeAdded.getNom());
	}

/*affichage*/
	@Test       
	public void testRetrieveAllEmployes() {
		List<Employe> listEmployes = es.getAllEmployes(); 
		// if there are 3 employes in DB : 
		assertEquals(4, listEmployes.size());
	}
	
	
	 /*update*/
@Test      
	public void testModifyUser() throws ParseException   {
		Employe e = new Employe(2, "Mayssa", "Mayssa", null, null, false, Role.ADMINISTRATEUR); 
		Employe employeUpdated  = es.mettreAjourEmploye(e); 
		assertEquals(e.getNom(), employeUpdated.getNom());
	}
       
       /*delete*/
	@Test     
	public void deleteEmployeId() {
		Employe employeDeleted= es.deleteEmployeById( 3);; 
		assertEquals(3, employeDeleted.getId());
	}


}








