package cl.equipo11.lenderapp.service;

import cl.equipo11.lenderapp.dto.UserDto;

public interface UserService {

    boolean save(UserDto user);
    UserDto getUser(String id);
    boolean update(UserDto user);

}
