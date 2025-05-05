package az.academy.turing.usermanagementsystem.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponse {

    @Column(name="username",nullable = false,unique = true)
    @NotBlank(message = "user name cannot be null")
    @Pattern(regexp ="^[A-Za-zÀ-ÿ'\\-]+$",message = "The name can only contain letters, apostrophes, and hyphens")
    private String username;
    @Column(name = "email",nullable = false,unique = true)
    @Email(message = "Please provide a valid email address")
    private String email;
    @Column(name = "phone_number",nullable = false,unique = true)
    @NotBlank(message = "phone number cannot be null")
    private String phone_number;
}
