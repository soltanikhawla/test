package com.test.produit.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.produit.model.Utilisateur;
import com.test.produit.Service.InscriptionService;


@CrossOrigin("http://localhost:8080/")
@RestController
@RequestMapping("/api")
public class InscriptionController {
	
	final private InscriptionService inscriptionService;

	public InscriptionController(InscriptionService inscriptionService) {
		this.inscriptionService = inscriptionService;
	}
	
	//Inscription
    @PostMapping("/inscription")
    public ResponseEntity<?> inscription(@RequestBody Utilisateur utilisateur, BindingResult bindingResult) { 
    	if(inscriptionService.userExists(utilisateur.getLogin())) {
			bindingResult.addError(new FieldError("utilisateur", "login", "Login already in use"));
			return new ResponseEntity<>("Email address already in use",HttpStatus.BAD_REQUEST);
		}
    	
    	if(bindingResult.hasErrors()) {
			return new ResponseEntity<>("register echec",HttpStatus.BAD_REQUEST);
		}

    	inscriptionService.inscription(utilisateur);
        return ResponseEntity.ok().body( utilisateur);
    }


}
