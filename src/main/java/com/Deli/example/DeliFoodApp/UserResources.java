package com.Deli.example.DeliFoodApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserResources {

    private final UserDaoService service;
    private final userDaoDataJPA userDaoRepo;

    @Autowired
    public UserResources(UserDaoService service, userDaoDataJPA userDaoRepo) {
        this.service = service;
        this.userDaoRepo = userDaoRepo;
    }

    @GetMapping
    public List<Users> retrieveAllUsers() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Users retrieveUser(@PathVariable int id) {
        Optional<Users> user = Optional.ofNullable(service.findById(id));
        return user.orElse(null);
    }

    @PostMapping
    public ResponseEntity<Users> createUser(@Valid @RequestBody Users user) {
        Users savedUser = service.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getUserEmail()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        service.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable int id, @Valid @RequestBody Users user) {
        Users savedUser = service.update(id, user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getUserEmail()).toUri();
        return ResponseEntity.created(location).build();
    }
}
