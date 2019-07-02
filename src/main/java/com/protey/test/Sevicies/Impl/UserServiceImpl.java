package com.protey.test.Sevicies.Impl;

import com.protey.test.Entities.User;
import com.protey.test.Entities.UserStatus;
import com.protey.test.Repositories.UserRepository;
import com.protey.test.Sevicies.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public long addUser(User user) {
        return userRepository.saveAndFlush(user).getId();
    }

    @Override
    public Optional<User> getUser(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserStatus> changeStatus(UserStatus userStatus) {
        Optional<User> opt = userRepository.findById(userStatus.getId());
        Optional<UserStatus> status = Optional.empty();
        if (opt.isPresent()) {
            User user = opt.get();
            status = Optional.of(new UserStatus(user.getId(), user.getStatus(), userStatus.getNewStatus()));
            user.setStatus(userStatus.getNewStatus());
            userRepository.saveAndFlush(user);
        }
        return status;
    }
}
