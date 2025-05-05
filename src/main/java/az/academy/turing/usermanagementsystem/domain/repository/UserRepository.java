package az.academy.turing.usermanagementsystem.domain.repository;

import az.academy.turing.usermanagementsystem.domain.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users,Long> {
    @NotBlank(message = "user name cannot be null")
    @Pattern(regexp ="^[A-Za-zÀ-ÿ'\\-]+$",message = "The name can only contain letters, apostrophes, and hyphens")
    Optional<Users>findByUsername( String username);

    boolean existsByEmail(@Email(message = "Please provide a valid email address") String email);

    boolean existsByUsername(@NotBlank(message = "user name cannot be null") @Pattern(regexp ="^[A-Za-zÀ-ÿ'\\-]+$",message = "The name can only contain letters, apostrophes, and hyphens") String username);
}
