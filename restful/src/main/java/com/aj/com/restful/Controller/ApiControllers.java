package com.aj.com.restful.Controller;

import com.aj.com.restful.Models.User;
import com.aj.com.restful.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {
    @Autowired
    private UserRepo userRepo;

    @GetMapping(value="/")
    public String getPage(){
        return "Welcome";
    }

    @GetMapping(value="/users")
    public List<User> getUsers(){
        return userRepo.findAll();
    }

    @PostMapping(value = "/save")
    public String saveUser(@RequestBody User user) {
        userRepo.save(user);

        return "saved...";
    }

    @PutMapping(value ="/update/{id}")
    public  String updateUser(@PathVariable long id,@RequestBody User user){
        User updatedUser=userRepo.findById(id).get();
        updatedUser.setName(user.getName());
        updatedUser.setPhone(user.getPhone());
        updatedUser.setEmail(user.getEmail());
        userRepo.save(updatedUser);
        return "updated...";

    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteuser(@PathVariable long id){
        User deleteUser=userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "delete user id"+id;
    }






}
