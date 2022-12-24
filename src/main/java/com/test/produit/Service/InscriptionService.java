package com.test.produit.Service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.test.produit.model.Utilisateur;
import com.test.produit.repository.RoleRepository;
import com.test.produit.repository.UtilisateurRepository;
import com.test.produit.model.Role;

@Service
public class InscriptionService {
	
	final private UtilisateurRepository utilisateurRepository;
	@Autowired
	private final BCryptPasswordEncoder passwordEncoder;
	private final RoleRepository roleRepository;
	
	
	public InscriptionService(UtilisateurRepository utilisateurRepository, BCryptPasswordEncoder passwordEncoder,
			RoleRepository roleRepository) {
		this.utilisateurRepository = utilisateurRepository;
		this.passwordEncoder = passwordEncoder;
		this.roleRepository = roleRepository;
	}

	@Transactional
	public Optional<Utilisateur> findUserByLogin(String login){
		return utilisateurRepository.findUserByLogin(login);
	}
	
	public boolean userExists(String login) {
		return findUserByLogin(login).isPresent();
	}
	
	@Transactional
	public Utilisateur save(Utilisateur utilisateur) {
		utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
		return utilisateurRepository.save(utilisateur);
	}


	public Utilisateur inscription(Utilisateur utilisateur) { 
		//password encryption
		String password = passwordEncoder.encode(utilisateur.getPassword());
		utilisateur.setPassword(password);
		Role role = roleRepository.findByLibelle("Admin");
		utilisateur.setRole(role);
		return utilisateurRepository.save(utilisateur);
	}



}