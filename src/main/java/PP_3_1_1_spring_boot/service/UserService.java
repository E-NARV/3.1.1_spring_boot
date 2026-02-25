package PP_3_1_1_spring_boot.service;

import PP_3_1_1_spring_boot.models.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getById(Long id);
    void create(User user);
    void update(User user);
    void delete(Long id);
}