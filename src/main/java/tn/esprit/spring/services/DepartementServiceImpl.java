package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;

@Service
public class DepartementServiceImpl implements IDepartementService {

	private static final Logger l = LogManager.getLogger(DepartementServiceImpl.class);
	@Autowired
	DepartementRepository deptRepoistory;


	public List<Departement> getAllDepartements() {
		l.info("In  retrieveAllDepartements : "); 
		List<Departement> deps = (List<Departement>) deptRepoistory.findAll();  
		for (Departement dep : deps) {
			l.debug("user +++ : " + dep);
		}
		l.info("Out of retrieveAllDepartements."); 
		return deps;
	}


	@Override
	public Departement addDepartement(Departement d) {
		l.info("In  addDepartement : " + d); 
		Departement DepSaved =deptRepoistory.save(d);
		l.info("Out of  addDepartement. "); 
		return DepSaved; 
	}


	@Override
	public Departement UpdateDepartement(Departement d) {
		// TODO Auto-generated method stub
		return deptRepoistory.save(d);
	}


	@Override
	public void deleteDepartement(String id) {
		// TODO Auto-generated method stub
		deptRepoistory.deleteById((int)Long.parseLong(id));;
	}


	@Override
	public Departement retreiveDepartement(String id) {
		l.info("in  retrieveUDepartement id = " + id);
		// Optional retrun type - Java 8 (susceptible de retourner des valeurs «vides» et pas null)
		Departement d =  deptRepoistory.findById((int) Long.parseLong(id)).orElse(null);


		//User u =  userRepository.findById(Long.parseLong(id)).get(); 
		l.info("departmenet returned : " + d);
		return d; 
	}

}
