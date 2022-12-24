package com.test.produit.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.test.produit.model.Utilisateur;


public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	Utilisateur findByLogin(String login);
	public Optional<Utilisateur> findUserByLogin(String login);
	Boolean existsByLogin(String login);
	
	List <Utilisateur> findByNom(String nom);
}