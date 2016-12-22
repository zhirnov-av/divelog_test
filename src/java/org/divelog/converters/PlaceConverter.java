/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.divelog.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import org.divelog.base.SiteItem;
import org.divelog.beans.DivesitesBean;

/**
 *
 * @author Zhirnov.AV
 */
@FacesConverter("PlaceConverter")
public class PlaceConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value){

        DivesitesBean bean = context.getApplication().evaluateExpressionGet(context, "#{divesitesBean}", DivesitesBean.class);
        if ( bean != null ){
            for(int i = 0; i < bean.places.size(); i++){
                SiteItem si = (SiteItem)bean.places.get(i);
                if (si.getName().equalsIgnoreCase(value)){
                    return si;
                }
            }
            bean.setNewSite(true);
        }
        return new SiteItem(-1, value);
        
    };

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value){
        
        DivesitesBean bean = context.getApplication().evaluateExpressionGet(context, "#{divesitesBean}", DivesitesBean.class);
        

        if ( bean != null && !value.toString().isEmpty()  ){
            for(int i = 0; i < bean.places.size(); i++){
                SiteItem si = (SiteItem)bean.places.get(i);
                if (si == (SiteItem)value){
                    return si.getName();
                }
            }
        }
        return "";
    };
}
