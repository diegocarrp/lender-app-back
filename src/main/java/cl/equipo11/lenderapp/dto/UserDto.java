package cl.equipo11.lenderapp.dto;

import cl.equipo11.lenderapp.repository.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserDto {

    private String id;
    private String username;
    private String email;
    private String password;

    public User toUser() {
        return User.builder()
                .username(this.username)
                .email(this.email)
                .password(this.password)
                .build();
    }

}
