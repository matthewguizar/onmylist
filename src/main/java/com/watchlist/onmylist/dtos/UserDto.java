package com.watchlist.onmylist.dtos;

import com.watchlist.onmylist.entities.User;
import com.watchlist.onmylist.utils.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;

    public UserDto (User user){
        if (user.getId() != null) {
            this.id = user.getId();
        }
        if (user.getFirstName() != null) {
            this.firstName = user.getFirstName();
        }
        if (user.getLastName() != null) {
            this.lastName = user.getLastName();
        }
        if (user.getEmail() != null) {
            this.email = user.getEmail();
        }
        if (user.getPassword() != null) {
            this.password = user.getPassword();
        }
        if (user.getRole() != null) {
            this.role = user.getRole();
        }
    }
}
