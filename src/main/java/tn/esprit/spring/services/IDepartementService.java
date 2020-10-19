package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Departement;


public interface IDepartementService {
	
	
	public List<Departement> getAllDepartements();
	public Departement addDepartement (Departement d);
	public Departement UpdateDepartement (Departement d);
	public void deleteDepartement(String id);
	public Departement retreiveDepartement(String id);

	
	
	
	

	
}
