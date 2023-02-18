package com.watchlist.onmylist.entities;

import com.watchlist.onmylist.dtos.UserDto;
import com.watchlist.onmylist.utils.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    private Boolean locked;
    private Boolean enabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public User(UserDto userDto) {
        if (userDto.getEmail() !=null){
            this.email = userDto.getEmail();
        }
        if (userDto.getFirstName() !=null){
            this.firstName = userDto.getFirstName();
        }
        if (userDto.getLastName() !=null){
            this.lastName = userDto.getLastName();
        }
        if (userDto.getPassword() !=null){
            this.password = userDto.getPassword();
        }
        if (userDto.getRole() !=null){
            this.role = userDto.getRole();
        }

    }
}
