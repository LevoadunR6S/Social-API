package com.example.soc.controller;

import com.example.soc.dto.UserDto;
import com.example.soc.exception.InvalidUserException;
import com.example.soc.model.User;
import com.example.soc.response.ResponseHandler;
import com.example.soc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@RestController
@RequestMapping("/soc/api/v1")
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<Object> getAllUsers() {
        return ResponseHandler.responseBuilder(HttpStatus.OK, userService.getAll(), "user");
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<Object> getUser(@PathVariable Integer userId) {
        UserDto user = userService.userToUserDto(userService.getUserById(userId));
        if (user != null) {
            return ResponseHandler.responseBuilder(HttpStatus.OK, user, "user with id " + userId);
        } else {
            return ResponseHandler.responseBuilder(HttpStatus.NOT_FOUND, new InvalidUserException("There is no user with id=" + userId), "error cause");
        }
    }

    @GetMapping("/users/{userId}/friends")
    public ResponseEntity<Object> getFriends(@PathVariable Integer userId) {
        User user = userService.getUserById(userId);
        return ResponseHandler.responseBuilder(HttpStatus.OK, user.getFriends(), "friends list");
    }


    @PostMapping("/users/{userId}/friends/add/{friendId}")
    public ResponseEntity<Object> getFriends(@PathVariable Integer userId,
                                             @PathVariable Integer friendId,
                                             Principal principal) {
        User user = userService.getUserById(userId);
        User friend = userService.getUserById(friendId);
        if (principal.getName().equals(user.getUsername()))   //user.getUsername is redundant
        {
            if (userService.getUserById(friendId)!=null){
                user.getFriends().add(friend);
                friend.getFriends().add(user);
                return ResponseHandler.responseBuilder(HttpStatus.OK,"friend was added", "response");
            }
        }
        return ResponseHandler.responseBuilder(HttpStatus.NOT_FOUND,"incorrect url","response");
    }




    //todo add massaging
}
