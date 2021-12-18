package cl.equipo11.lenderapp.controller;

import cl.equipo11.lenderapp.dto.UserDto;
import cl.equipo11.lenderapp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("")
    public ResponseEntity<Void> createUser(@RequestBody UserDto userDto) {
      log.info("createUser - Body: {}", userDto);

      service.save(userDto);

      return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable String id) {
        log.info("getUserById - ID: {}", id);

        return ResponseEntity.ok(service.getUser(id));

    }
}
