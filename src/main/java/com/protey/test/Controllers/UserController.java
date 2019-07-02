package com.protey.test.Controllers;

import com.protey.test.Controllers.Handlers.ApiResponse;
import com.protey.test.Controllers.Handlers.EntityNotFoundException;
import com.protey.test.Entities.User;
import com.protey.test.Entities.UserStatus;
import com.protey.test.Sevicies.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ApiResponse<List<User>> getAllUser() {
        return new ApiResponse<>(HttpStatus.OK, userService.getAllUser());
    }

    @PostMapping()
    public ApiResponse<Long> addUser(@RequestBody @Valid User user) {
        return new ApiResponse<>(HttpStatus.OK, userService.addUser(user));
    }

    @GetMapping("/{id}")
    public ApiResponse<User> getUser(@PathVariable(value = "id") @Min(1) Long id) throws EntityNotFoundException {
        Optional<User> user = userService.getUser(id);
        return user.map(value -> new ApiResponse<>(HttpStatus.OK, user.get()))
                .orElseThrow(() -> new EntityNotFoundException(User.class, "id", id.toString()));

    }

    @PostMapping("/status")
    public ApiResponse<UserStatus> setStatus(@Valid @RequestBody UserStatus status) throws EntityNotFoundException {
        Optional<UserStatus> changeStatus = userService.changeStatus(status);
        return changeStatus.map(value -> new ApiResponse<>(HttpStatus.OK, changeStatus.get()))
                .orElseThrow(() -> new EntityNotFoundException(UserStatus.class, "Status", status.toString()));
    }
}
