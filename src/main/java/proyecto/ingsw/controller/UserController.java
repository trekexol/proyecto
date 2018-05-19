package proyecto.ingsw.controller;

import proyecto.ingsw.command.UserChangingAttributesCommand;
import proyecto.ingsw.command.UserSearchCommand;
import proyecto.ingsw.command.UserSignUpCommand;
import proyecto.ingsw.model.User;
import proyecto.ingsw.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import proyecto.ingsw.command.UserLoginCommand;

import java.util.List;

@Slf4j

@CrossOrigin
@RestController
@RequestMapping(value = "/user", produces = "application/json")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/register", consumes = "application/json", method = RequestMethod.POST)
    public ResponseEntity register(@Valid @RequestBody UserSignUpCommand command) {
        return userService.register(command);
    }

    @RequestMapping(value = "/login", consumes = "application/json", method = RequestMethod.POST)
    public ResponseEntity login(@Valid @RequestBody UserLoginCommand command) {
        return userService.login(command);
    }

    @RequestMapping(value = "/update/{id}", consumes = "application/json", method = RequestMethod.PUT)
    public ResponseEntity update(@Valid @RequestBody UserChangingAttributesCommand command, @PathVariable("id") String id) {
        return userService.update(command, id);
    }

    @RequestMapping(value = "/search/{firstname}", consumes = "application/json", method = RequestMethod.GET)
    public List<User> search(@PathVariable("firstname") String firstname) {
        return userService.searchUserByName(firstname);
    }

    @RequestMapping(value = "/delete/{id}", consumes = "application/json", method = RequestMethod.DELETE)
    public ResponseEntity delete (@Valid @RequestBody UserChangingAttributesCommand command, @PathVariable("id") String id) {
        return userService.update(command, id);
    }
}


