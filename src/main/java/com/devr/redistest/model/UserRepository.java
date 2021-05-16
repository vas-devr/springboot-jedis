package com.devr.redistest.model;

import java.util.List;
import java.util.Map;

/**
 * Description about this classs......
 *
 * @author : vasudev
 * @created : 5/16/21
 * @since : v1.0.0-00
 */

public interface UserRepository {
    
    void save(User user);
    Map<String,User> findAll();
    User findById(String id);
    void delete(String id);
    void update(User user);
}
