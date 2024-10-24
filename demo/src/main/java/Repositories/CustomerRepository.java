package Repositories;

import Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    //Tim customer dua vao email hoac sdt
    Customer findByEmailOrPhone(String emailOrPhone);

}
