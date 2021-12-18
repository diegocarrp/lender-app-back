package cl.equipo11.lenderapp.dto;

import cl.equipo11.lenderapp.repository.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
public class UserDto {

    private String id;
    @NotBlank
    private String username;
    @Email @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String rut;

    public User toUser() {
        return User.builder()
                .username(this.username)
                .email(this.email)
                .password(this.password)
                .rut(this.rut)
                .build();
    }

}
