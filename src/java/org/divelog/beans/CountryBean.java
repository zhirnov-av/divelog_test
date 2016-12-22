/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.divelog.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.CustomScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

/**
 *
 * @author Zhirnov.AV
 */
@ManagedBean(name= CountryBean.BEAN_NAME)
@CustomScoped(value = "#{window}")
public class CountryBean implements Serializable 
{
    public static final String BEAN_NAME = "countryBean";
    public String getBeanName() { return BEAN_NAME; }

    public List<SelectItem> countries;
    public SelectItem country;
    
    public SelectItem getCountry(){
        return country;
    }

    public void setCountry(SelectItem counry){
        this.country = counry; 
    }

    public List<SelectItem> getCountries(){
        if (countries == null) {
            countries = new ArrayList<SelectItem>();
            for (String country : readCountries()) {
                countries.add(new SelectItem(country));
            }
        }
        return countries;
    }
    
    private String selectedText = null; // Text the user is typing in
    public String getSelectedText() { return selectedText; }
    public void setSelectedText(String selectedText) { this.selectedText = selectedText; }
    
    /**
     * Method to read the list of cities from the file CITIES_FILENAME
     *  (which should be a text file with one city per line)
     * The read list will be stored as cities and can be referenced by any Autocomplete demo
     */
    private static List<String> readCountries() {
        List<String> countries = new ArrayList<String>();
        countries.add("Россия");
        countries.add("Египтосия");
        countries.add("Тайщина");
        
        return countries;
    }
}