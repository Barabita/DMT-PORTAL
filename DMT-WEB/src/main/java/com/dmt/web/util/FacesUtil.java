package com.dmt.web.util;

import javax.el.ValueExpression;
import javax.faces.application.Application;
import javax.faces.context.FacesContext;

/**
 * @author mali.sahin
 * @date 21-Mar-18
 */
public class FacesUtil {
    public static Object getBean(String name) {
        //return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(name);
        FacesContext context = FacesContext.getCurrentInstance();
        Application app = context.getApplication();
        ValueExpression expression = app.getExpressionFactory().createValueExpression(context.getELContext(),
                String.format("#{%s}", name), Object.class);
        return expression.getValue(context.getELContext());
    }
}
