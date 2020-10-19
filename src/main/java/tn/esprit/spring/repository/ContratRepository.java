package tn.esprit.spring.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Contrat;

@Repository
public interface ContratRepository extends CrudRepository<Contrat, Integer>{

	@Transactional
	@Modifying
	@Query(value="update Contrat c set c.date_debut=:date, c.salaire=:salaire, c.type_contrat=:type where c.reference=:id",nativeQuery = true )
	public void MettreajourContrat(@Param("date") Date d, @Param("salaire") float s,@Param("type") String type, @Param("id")int id );
	
} 
