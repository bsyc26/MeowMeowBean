package org.csalign.mmb.service;

import org.csalign.mmb.model.Comment;
import org.csalign.mmb.model.Post;
import org.csalign.mmb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private final Map<String, User> userDB = new HashMap<>() {
        { put("5", new User("5", "Level 5 User", "", 50, 5)); }
        { put("2", new User("2", "Level 2 User", "", 1, 2)); }
        { put("1", new User("1", "Level 1 User", "", -1, 1)); }
    };

    public Iterable<User> get() {
        List<User> users = new ArrayList<>(userDB.values());
        Collections.sort(users);
        return users;
    }

    public User get(String userId) {
        return userDB.get(userId);
    }

    public User save(User user) {
        user.setUserId(UUID.randomUUID().toString());
        user.setBeans(1);
        user.setLevel(2);
        userDB.put(user.getUserId(), user);
        return user;
    }

    public User remove(String userId) {
        User user = userDB.get(userId);
        return userDB.remove(userId);
    }

    public void takeBeans(String userId, int beans) {
        userDB.get(userId).takeBeans(beans);
    }

    public int castBeans(String userId, int beans) {
        return userDB.get(userId).castBeans(beans);
    }

}
