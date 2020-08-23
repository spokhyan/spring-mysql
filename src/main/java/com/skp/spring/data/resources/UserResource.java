package com.skp.spring.data.resources;

import com.skp.spring.data.model.User;
import com.skp.spring.data.repos.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mysql/")
public class UserResource {

    private UserRepository usersRepository;

    public UserResource(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    @GetMapping("/")
    public List<User> all() {


        return usersRepository.findAll();
    }


    @GetMapping("/create")
    public List<User> users() {
        User users = new User();
        users.setId(1);
        users.setName("Sam");
        users.setSalary(3400);
        users.setTeamName("Development");

        usersRepository.save(users);

        return usersRepository.findAll();
    }
}
