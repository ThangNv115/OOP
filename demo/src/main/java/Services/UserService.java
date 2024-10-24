package Services;

import Entity.Customer;
import Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    //Dang ky nguoi dung
    public Customer registerCustomer(Customer customer) {
        //ma hoa mat khau truoc khi luu vao database
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return customerRepository.save(customer);
    }

    //Tim nguoi dung theo email va sdt
    public Customer findByEmailOrPhone(String emailOrPhone) {
        return customerRepository.findByEmailOrPhone(emailOrPhone);
    }

}
