package cl.equipo11.lenderapp.service;

import cl.equipo11.lenderapp.dto.UserDto;
import cl.equipo11.lenderapp.exception.InvalidRequestException;
import cl.equipo11.lenderapp.exception.LenderAlreadyRegisteredException;
import cl.equipo11.lenderapp.exception.UserNotFoundException;
import cl.equipo11.lenderapp.repository.UserRepository;
import cl.equipo11.lenderapp.repository.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@Slf4j
public class UserServiceImpl implements UserService{

    private final UserRepository repository;
    private final CryptoService cryptoService;
    private final Validator validator;

    public UserServiceImpl(UserRepository repository,
                           CryptoService cryptoService) {
        this.repository = repository;
        this.cryptoService = cryptoService;

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    @Override
    public boolean save(UserDto user) {

        validateRequestUserDto(user);
        validateExistence(user.getRut());

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

    private void validateRequestUserDto(UserDto user) {
        Set<ConstraintViolation<UserDto>> violations = validator.validate(user);
        List<String> descriptions = violations.stream()
                .map(v -> v.getPropertyPath() + " - " + v.getMessage()).collect(Collectors.toList());

        if(!descriptions.isEmpty()) {
            for (String description :
                    descriptions) {
                log.error(description);
            }
            throw new InvalidRequestException();
        }
    }

    private void validateExistence(String rut) {
        User userFound = repository.findByRut(rut);
        if(null != userFound) throw new LenderAlreadyRegisteredException(rut);
    }
}
