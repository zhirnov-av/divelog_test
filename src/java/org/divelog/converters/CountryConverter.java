/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.divelog.converters;

import javax.enterprise.inject.spi.Bean;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;
import org.divelog.base.SiteItem;
import org.divelog.beans.DivesitesBean;

/**
 *
 * @author Zhirnov.AV
 */

@FacesConverter("CountryConverter")
public class CountryConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value){

        DivesitesBean bean = context.getApplication().evaluateExpressionGet(context, "#{divesitesBean}", DivesitesBean.class);
        if ( bean != null ){
            for(int i = 0; i < bean.countries.size(); i++){
                SiteItem si = (SiteItem)bean.countries.get(i);
                if (si.getName().equalsIgnoreCase(value)){
                    return si;
                }
            }
        }
        throw new ConverterException(new FacesMessage("Unknown operation ID: " + value));
    };

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value){
        
        DivesitesBean bean = context.getApplication().evaluateExpressionGet(context, "#{divesitesBean}", DivesitesBean.class);
        
        if (value.getClass().getCanonicalName().equalsIgnoreCase("org.divelog.base.SiteItem")){
            if ( bean != null ){
                for(int i = 0; i < bean.countries.size(); i++){
                    SiteItem si = (SiteItem)bean.countries.get(i);
                    if (si.getId() == ((SiteItem)value).getId()){
                        return si.getName();
                    }
                }
            }else{
                return "";
            }
        }else{
        
            if ( bean != null && value.toString() != "" ){
                for(int i = 0; i < bean.countries.size(); i++){
                    SiteItem si = (SiteItem)bean.countries.get(i);
                    if (si.getId() == Integer.parseInt(value.toString())){
                        return si.getName();
                    }
                }
            }else{
                return "";
            }
        }
        
        throw new ConverterException(new FacesMessage("Unknown operation ID: " + value));
        
//        
//        
//        
//        try{
//            String ss = ((SiteItem)value).getName();
//            return ss;
//        }catch(Exception e){
//            return "";
//        }
    };
}
