/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingeditingsaving;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author SUSHMA
 */
public class patient {
    private  SimpleIntegerProperty id; 
    private  SimpleStringProperty name;
    private  SimpleIntegerProperty age;
    private  SimpleIntegerProperty weight;
    private SimpleDoubleProperty height;
    private SimpleStringProperty bloodType;
    
    patient(Integer id, String name, Integer age, Integer weight, Double height, String bloodType){
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.age = new SimpleIntegerProperty(age);
        this.weight = new SimpleIntegerProperty(weight);
        this.height = new SimpleDoubleProperty(height);
        this.bloodType = new SimpleStringProperty(bloodType);
    }
    public Integer getId(){
    return id.get();
    }
    public void setId(SimpleIntegerProperty id){
    this.id = id;
    }
    
    public String getName(){
    return name.get();
    }
    public void setName(SimpleStringProperty name){
    this.name = name;
    }
    
    public Integer getAge(){
    return age.get();
    }
    public void setAge(SimpleIntegerProperty age){
    this.age = age;
    }
    
    public Integer getWeight(){
    return weight.get();
    }
    public void setWeight(SimpleIntegerProperty weight){
    this.weight = weight;
    }
    
    public Double getHeight(){
    return height.get();
    }
    public void setHeight(SimpleDoubleProperty height){
    this.height = height;
    }
    
    public String getBloodType(){
    return bloodType.get();
    }
    public void setBloodType(SimpleStringProperty bloodType){
    this.bloodType = bloodType;
    }
    
}
