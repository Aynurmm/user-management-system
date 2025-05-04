package az.academy.turing.usermanagementsystem.domain.repository;

import az.academy.turing.usermanagementsystem.domain.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Long> {

}
