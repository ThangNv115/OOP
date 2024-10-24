package Services;

import Entity.Customer;
import Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String emailOrPhone) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByEmailOrPhone(emailOrPhone);
        if (customer == null) {
            throw new UsernameNotFoundException("Khong tim thay nguoi dung" + emailOrPhone);
        }

        return User.builder()
                .username(customer.getEmail()) // dat username la email
                .password(customer.getPassword())
                .roles("USER")
                .build();
    }

}
