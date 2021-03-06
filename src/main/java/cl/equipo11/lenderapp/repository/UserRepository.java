package cl.equipo11.lenderapp.repository;

import cl.equipo11.lenderapp.repository.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByRut(String rut);
}
