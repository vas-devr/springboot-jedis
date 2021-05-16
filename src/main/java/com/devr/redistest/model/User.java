package com.devr.redistest.model;

import java.io.Serializable;

/**
 * Description about this classs......
 *
 * @author : vasudev
 * @created : 5/16/21
 * @since : v1.0.0-00
 */

public class User implements Serializable {
    
    private String id;
    private String name;
    private Long Salary;
    
    public User(String id, String name, Long salary) {
        this.id = id;
        this.name = name;
        Salary = salary;
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
    
    public Long getSalary() {
        return Salary;
    }
    
    public void setSalary(Long salary) {
        Salary = salary;
    }
}
