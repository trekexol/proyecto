package cdbm.ucab.ingsw.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import cdbm.ucab.ingsw.model.User;

import java.util.List;

@Repository("UserRepository")
public interface UserRepository extends CrudRepository<User, Long>{
    List<User> findByFirstName(String firstName);
    User findByEmail(String email);
    boolean  existsByEmail(String email);
}
