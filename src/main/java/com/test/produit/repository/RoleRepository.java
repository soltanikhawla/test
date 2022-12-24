package com.test.produit.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.produit.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	Role findByLibelle(String libelle);
	

}
