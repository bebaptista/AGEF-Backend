package com.tisv.agef.resources.helpers;

public abstract class ExceptionMessages {

    public static String getConstraintViolationExceptionMsg(Exception ex) {
        return "Existe uma constraint associada ao objeto." +
                "\n" + "Causa: " + ex.getCause() +
                "\n" + "Erro: " + ex.getLocalizedMessage();
    }

    public static String getEmptyResultDataAccessExceptionMsg(Exception ex) {
        return "O parâmetro enviado não corresponde a nenhum objeto no servidor." +
                "\n" + "Erro: " + ex.toString();
    }

    public static String getIllegalArgumentExceptionMsg(Exception ex) {
        return "O parâmetro enviado é inválido. Verifique as restrições impostas." +
                "\n" + "Erro: " + ex.toString();
    }

    public static String getObjectNotFoundExceptionMsg(Exception ex) {
        return "O parâmetro enviado não corresponde a nenhum objeto no servidor." +
                "\n" + "Erro: " + ex.toString();
    }

}
