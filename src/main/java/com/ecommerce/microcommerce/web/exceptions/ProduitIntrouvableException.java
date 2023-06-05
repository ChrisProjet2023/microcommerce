package com.ecommerce.microcommerce.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//définit le code de statut associé à l'exception
//L'annotation désigne le code d'erreur à renvoyer parmi la liste de tous les codes possibles
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProduitIntrouvableException extends RuntimeException {

	public ProduitIntrouvableException(String s) {
		super(s);
	}
}
