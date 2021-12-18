package cl.equipo11.lenderapp.repository.domain;

import cl.equipo11.lenderapp.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("users")
public class User {

    @Id
    private String id;
    private String username;
    private String email;
    private String password;

    public UserDto toUserDto() {
        return UserDto.builder()
                .id(this.id)
                .username(this.username)
                .email(this.email)
                .build();
    }

}
