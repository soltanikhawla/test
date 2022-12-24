package com.test.produit;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.produit.model.Utilisateur;
import com.test.produit.repository.UtilisateurRepository;

@SpringBootTest
class UtilisateurApplicationTests {

	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Test
	public void testCreateUtilisateur() {
	Utilisateur utili = new Utilisateur("soltani","khawla",23,58135019,"khawla58","khawla123",50,"soltanikhawla@gmail.com");
	utilisateurRepository.save(utili);
	}
	
	@Test
	public void testFindUtilisateur()
	{
		Utilisateur p = utilisateurRepository.findById(1L).get();
	System.out.println(p);
	}
	
	@Test
	public void testUpdateUtilisateur()
	{
		Utilisateur p = utilisateurRepository.findById(1L).get();
	p.setTel(26337836);
	utilisateurRepository.save(p);
	
	System.out.println(p);
	}
	
	@Test
	public void testDeleteUtilisateur()
	{
		utilisateurRepository.deleteById(1L);
	}

	@Test
	public void testFindAllUtilisateur()
	{
		List<Utilisateur> prods = utilisateurRepository.findAll();
		
		for (Utilisateur p:prods)
			 System.out.println(p);
		
	}
	
}
