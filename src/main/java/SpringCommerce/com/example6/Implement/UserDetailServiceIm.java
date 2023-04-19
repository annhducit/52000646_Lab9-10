package SpringCommerce.com.example6.Implement;

import SpringCommerce.com.example6.Repository.UserRepository;
import SpringCommerce.com.example6.User.CustomUserDetails;
import SpringCommerce.com.example6.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


// Find user by username to implement spring security
public class UserDetailServiceIm implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user!!");
        }
        return new CustomUserDetails(user);
    }

}
