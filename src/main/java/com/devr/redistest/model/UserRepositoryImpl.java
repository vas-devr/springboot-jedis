package com.devr.redistest.model;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Description about this classs......
 *
 * @author : vasudev
 * @created : 5/16/21
 * @since : v1.0.0-00
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
    
    private RedisTemplate<String, User> redisTemplate;
    private HashOperations hashOperations;
    
    public UserRepositoryImpl(RedisTemplate<String, User> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }
    
    @Override public void save(User user) {
        hashOperations.put("USERS", user.getId(), user );
    }
    
    @Override public Map<String,User> findAll() {
        return hashOperations.entries("USERS");
    }
    
    @Override public User findById(String id) {
        return (User) hashOperations.get("USERS",id);
    }
    
    @Override public void delete(String id) {
        hashOperations.delete("USERS",id);
    }
    
    @Override public void update(User user) {
        save(user);
    }
}
