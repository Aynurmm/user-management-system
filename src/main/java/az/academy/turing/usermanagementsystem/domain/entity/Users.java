package az.academy.turing.usermanagementsystem.domain.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.UUID;

@Data
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @Column(name="username",nullable = false,unique = true)
    @NotBlank(message = "user name cannot be null")
    @Pattern(regexp ="^[A-Za-zÀ-ÿ'\\-]+$",message = "The name can only contain letters, apostrophes, and hyphens")
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "email",nullable = false,unique = true)
    @Email(message = "Please provide a valid email address")
    private String email;
    @Column(name = "phone_number",nullable = false,unique = true)
    @NotBlank(message = "phone number cannot be null")
    private String phone_number;

}
