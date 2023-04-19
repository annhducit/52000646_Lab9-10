package SpringCommerce.com.example6.Repository;

import SpringCommerce.com.example6.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
        User findByUsername(String username);

}
