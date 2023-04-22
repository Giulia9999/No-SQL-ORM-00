package com.example.nosqlorm00;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @PostMapping
    public User createUser(@RequestBody User user){
        user.setId(null);
        return userRepository.save(user);
    }
    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }else {
            throw new Exception();
        }
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id,@RequestBody User user) throws Exception {
        Optional<User> userId = userRepository.findById(id);
        if(userId.isPresent()){
            return userRepository.save(user);
        }else {
            throw new Exception();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id){
        userRepository.deleteById(id);
    }
}
