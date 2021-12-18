package cl.equipo11.lenderapp.service;

import cl.equipo11.lenderapp.dto.UserDto;
import cl.equipo11.lenderapp.exception.UserNotFoundException;
import cl.equipo11.lenderapp.repository.UserRepository;
import cl.equipo11.lenderapp.repository.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean save(UserDto user) {

        User userToSave = user.toUser();

        repository.save(userToSave);

        return true;
    }

    @Override
    public UserDto getUser(String id) {

        User userFound = repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));

        return userFound.toUserDto();
    }

    @Override
    public boolean update(UserDto user) {
        return false;
    }
}
