package PP_3_1_1_spring_boot.dao;

import PP_3_1_1_spring_boot.models.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    User findById(Long id);
    void save(User user);
    void update(User user);
    void deleteById(Long id);
}