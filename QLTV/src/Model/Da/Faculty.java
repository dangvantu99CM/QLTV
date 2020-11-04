/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Da;

/**
 *
 * @author tudv
 */
public class Faculty {

    private String name;
    private int id;
    private int sch_id;
    private String created_at;
    private String updated_at;
    public Faculty(){}
    public Faculty(int id, String name, int sch_id) {
        this.id = id;
        this.name = name;
        this.sch_id = sch_id;
    }

    public Faculty(int id,String name, int sch_id,  String created_at, String updated_at) {
        this.id = id;
        this.name = name;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.sch_id=sch_id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the sch_id
     */
    public int getSch_id() {
        return sch_id;
    }

    /**
     * @param sch_id the sch_id to set
     */
    public void setSch_id(int sch_id) {
        this.sch_id = sch_id;
    }

    /**
     * @return the created_at
     */
    public String getCreated_at() {
        return created_at;
    }

    /**
     * @param created_at the created_at to set
     */
    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    /**
     * @return the updated_at
     */
    public String getUpdated_at() {
        return updated_at;
    }

    /**
     * @param updated_at the updated_at to set
     */
    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
