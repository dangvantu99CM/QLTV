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
public class Store {

    private int id;
    private String name;
    private String position;
    private String deleted_at;
    private int status;
    private int st_max_slot;
    private int st_slot_current ;
    private int st_slot_empty ;
    
    public Store(){}

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
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * @return the deleted_at
     */
    public String getDeleted_at() {
        return deleted_at;
    }

    /**
     * @param deleted_at the deleted_at to set
     */
    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the st_max_slot
     */
    public int getSt_max_slot() {
        return st_max_slot;
    }

    /**
     * @param st_max_slot the st_max_slot to set
     */
    public void setSt_max_slot(int st_max_slot) {
        this.st_max_slot = st_max_slot;
    }

    /**
     * @return the st_slot_current
     */
    public int getSt_slot_current() {
        return st_slot_current;
    }

    /**
     * @param st_slot_current the st_slot_current to set
     */
    public void setSt_slot_current(int st_slot_current) {
        this.st_slot_current = st_slot_current;
    }

    /**
     * @return the st_slot_empty
     */
    public int getSt_slot_empty() {
        return st_slot_empty;
    }

    /**
     * @param st_slot_empty the st_slot_empty to set
     */
    public void setSt_slot_empty(int st_slot_empty) {
        this.st_slot_empty = st_slot_empty;
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
    
}
