package com.luciggl.webservice.resources;


import com.luciggl.webservice.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "users")
public class UserResource {
    @GetMapping
    public ResponseEntity<User>findAll(){
        User u = new User(1L,"pedro","pedro@gmail.com","99999","12345678");
        return ResponseEntity.ok().body(u);
    }
}
