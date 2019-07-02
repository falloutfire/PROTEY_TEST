package com.protey.test.Sevicies;

import com.protey.test.Entities.User;
import com.protey.test.Entities.UserStatus;

import java.util.List;
import java.util.Optional;

public interface UserService {

    long addUser(User user);

    Optional<User> getUser(long id);

    void deleteUser(long id);

    List<User> getAllUser();

    Optional<UserStatus> changeStatus(UserStatus userStatus);

    void updateStatus();
}
