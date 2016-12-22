/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.divelog.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.CustomScoped;
import javax.faces.bean.ManagedBean;
import org.divelog.base.SiteItem;

/**
 *
 * @author Zhirnov.AV
 */
@ManagedBean(name= DivesitesBean.BEAN_NAME)
@CustomScoped(value = "#{window}")
public class DivesitesBean implements Serializable 
{
    public static final String BEAN_NAME = "divesitesBean";
    public String getBeanName() { return BEAN_NAME; }

    public List<SiteItem> countries;
    public SiteItem country;

    public List<SiteItem> places;
    public SiteItem place;
    
    private Map<String, String> availableItems;    

    private boolean newSite;

    public boolean isNewSite() {
        return newSite;
    }

    public void setNewSite(boolean newSite) {
        this.newSite = newSite;
    }
    
    

    public SiteItem getPlace(){
        return place;
        
    }

    public void setPlace(SiteItem place){
        this.place = place; 
    }
    
    
    public SiteItem getCountry(){
        return country;
    }

    public void setCountry(SiteItem counry){
        this.country = counry; 
    }

    public List<SiteItem> getCountries(){
        if (countries == null) {
            countries = new ArrayList<SiteItem>();
            for (SiteItem country : readCountries()) {
                countries.add(country);
            }
        }
        
        return countries;
    }
    
    public List<SiteItem> getPlaces(){
        places = new ArrayList<SiteItem>();
        int iCountry = 0;
        if (country != null){
            iCountry = (int)country.getId();
        }
        for (SiteItem place : readPlaces(iCountry)) {
            places.add(place);
        }
        return places;
    }    
    
    private String selectedText = null; // Text the user is typing in
    public String getSelectedText() { return selectedText; }
    public void setSelectedText(String selectedText) { this.selectedText = selectedText; }
    
    /**
     * Method to read the list of cities from the file CITIES_FILENAME
     *  (which should be a text file with one city per line)
     * The read list will be stored as cities and can be referenced by any Autocomplete demo
     */
    private static List<SiteItem> readCountries() {
        List<SiteItem> countries = new ArrayList<SiteItem>();
        
        countries.add(new SiteItem(1, "Россия"));
        countries.add(new SiteItem(2, "Египтосия"));
        countries.add(new SiteItem(3, "Таиланд"));
        
        return countries;
    }
    
    private static List<SiteItem> readPlaces(int iCountry) {
        List<SiteItem> places = new ArrayList<SiteItem>();
        
        if (iCountry == 1 || iCountry == 0){
            places.add(new SiteItem(4, "Озеро 1"));
            places.add(new SiteItem(5, "Сочи"));
        };
        if (iCountry == 3 || iCountry == 0){
            places.add(new SiteItem(6, "Koh Thao"));
        }
        
        return places;
    }
   
}