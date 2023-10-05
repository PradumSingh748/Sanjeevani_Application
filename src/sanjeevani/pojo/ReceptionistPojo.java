/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanjeevani.pojo;

/**
 *
 * @author PRADUM SINGH
 */
public class ReceptionistPojo {

    public ReceptionistPojo(){
        
    }
    public ReceptionistPojo(String id,String name,String gender){
        this.id=id;
        this.name=name;
        this.gender=gender;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
 private String id;
 private String name;
 private String gender;
}
