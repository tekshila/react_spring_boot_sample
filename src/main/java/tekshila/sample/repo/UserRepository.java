package tekshila.sample.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tekshila.sample.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
