package proyecto.ingsw.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import proyecto.ingsw.model.User;

import java.util.List;

@Repository("UserRepository")
public interface UserRepository extends CrudRepository<User, Long>{

    User findByEmail(String email);
    boolean  existsByEmail(String email);
    List<User> findFirst3ByEmailIgnoreCaseContaining(String partialEmailAddress);
    List<User> findByFirstNameIgnoreCaseContaining(String partialFirstName);
}
