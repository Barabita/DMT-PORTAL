package com.dmt.web.util;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;

/**
 * @author mali.sahin
 * @since 10-May-18
 */
@FacesConverter(value = "selectItemConverter", forClass = SelectItem.class)
public class SelectItemConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        try {
            return new SelectItem(value, "");
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(value + " is not a valid Select Item Value"), e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }

        try {
            return (String) new SelectItem(value, "").getValue();
        } catch (Exception e) {
            throw new ConverterException(new FacesMessage(value + " is not a valid Select Item"));
        }
    }

    public Object parseToSelectItem(Object item) {

        return null;
    }
}
