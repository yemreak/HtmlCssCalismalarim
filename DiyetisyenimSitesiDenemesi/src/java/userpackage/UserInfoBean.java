/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userpackage;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author YEmre
 */
@ManagedBean(name = "userinfo")
public class UserInfoBean {

    int weight;
    int height;
    int years;
    int body_mass_index; // Vücud kitle indeksi

    
    public void calculateBMI() {
        if (weight != 0 && height != 0) {
            body_mass_index = weight / height * height;
        }
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public int getBody_mass_index() {
        return body_mass_index;
    }

    public void setBody_mass_index(int body_mass_index) {
        this.body_mass_index = body_mass_index;
    }

}
