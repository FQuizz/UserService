package fquizz.fpt.user_service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    @GetMapping
    public Map<Long,User> getUsers(@RequestParam List<Long> userIds){
        return userRepository.findAllByIdIn(userIds).stream().collect(Collectors.toMap(User::getId,user -> user));
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found"));
    }
}
