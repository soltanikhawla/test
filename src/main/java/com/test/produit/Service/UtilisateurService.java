package com.test.produit.Service;

import java.util.List;

import com.test.produit.model.Utilisateur;

public interface UtilisateurService {
	
	Utilisateur saveUtilisateur(Utilisateur u);
	Utilisateur updateUtilisateur(Utilisateur u);
	void deleteUtilisateur(Utilisateur u);
	void deleteUtilisateurById(Long id);
	Utilisateur getUtilisateur(Long id);
	List<Utilisateur> getAllUtilisateur();
	
}
