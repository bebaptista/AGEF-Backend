package com.tisv.agef.resources.helpers;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

import com.tisv.agef.services.exceptions.ObjectNotFoundException;

public abstract class ExceptionMessages {
	
	public static String getConstraintViolationExceptionMsg(ConstraintViolationException ex) {
		return "Existe uma constraint associada ao objeto." + 
			   "\n" + "Causa: '" + ex.getCause() + "'." +
			   "\n" + "Erro: '" + ex.toString() + "'." ;
	}
	
	public static String getEmptyResultDataAccessExceptionMsg(EmptyResultDataAccessException ex) {
		return "O parâmetro enviado não corresponde a nenhum objeto no servidor." + 
			   "\n" + "Erro: '" + ex.toString() + "'.";
	}
	
	public static String getIllegalArgumentExceptionMsg(IllegalArgumentException ex) {
		return "O parâmetro enviado é inválido. Verifique as restrições impostas." + 
			   "\n" + "Erro: '" + ex.toString() + "'.";
	}
	
	public static String getObjectNotFoundExceptionMsg(ObjectNotFoundException ex) {
		return "O parâmetro enviado não corresponde a nenhum objeto no servidor." + 
			   "\n" + "Erro: '" + ex.toString() + "'.";
	}
	
}
