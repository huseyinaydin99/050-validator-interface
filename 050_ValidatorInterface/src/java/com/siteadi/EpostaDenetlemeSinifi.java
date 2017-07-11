/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siteadi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author husey
 */
@FacesValidator("epostaValidator")
public class EpostaDenetlemeSinifi implements Validator{

    private static final String EPOSTA_PATTERN = "[\\w\\.-]*[a-zA-Z0-9_]@[\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]";
    private Pattern pattern;
    private Matcher matcher;

    public EpostaDenetlemeSinifi() {
        pattern = Pattern.compile(EPOSTA_PATTERN);
    }
    
    @Override
    public void validate(FacesContext fc, UIComponent uıc, Object o) throws ValidatorException {
        matcher = pattern.matcher(o.toString());
        if(!matcher.matches()){
            FacesMessage facesMessage = new FacesMessage("Hata Geçersiz eposta","Geçersiz eposta");
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(facesMessage);
        }
    }
    
}
