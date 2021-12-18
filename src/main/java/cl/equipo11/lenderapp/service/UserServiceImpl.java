package cl.equipo11.lenderapp.service;

import cl.equipo11.lenderapp.dto.UserDto;
import cl.equipo11.lenderapp.exception.UserNotFoundException;
import cl.equipo11.lenderapp.repository.UserRepository;
import cl.equipo11.lenderapp.repository.domain.User;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository repository;
    private final CryptoService cryptoService;

    public UserServiceImpl(UserRepository repository,
                           CryptoService cryptoService) {
        this.repository = repository;
        this.cryptoService = cryptoService;
    }

    @Override
    public boolean save(UserDto user) {

        User userToSave = user.toUser();

        String pwd = encryptPassword(userToSave.getPassword());
        userToSave.setPassword(pwd);

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

    private String encryptPassword(String password) {

//        byte[] decodedBytes = Base64.getDecoder().decode(password);
//        String decodedString = new String(decodedBytes);

//        return cryptoService.encrypt(decodedString, "secret");
        return cryptoService.encrypt(password, "secret");
    }
}
