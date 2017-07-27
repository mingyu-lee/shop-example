package com.shop.user.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shop.user.domain.security.Authority;
import com.shop.user.domain.security.UserRole;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Mingyu Lee on 2017-07-15.
 * Description:
 */
@Entity
@Data
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="userId", nullable = false, updatable = false)
    private long userId;

    private String username;
    private String password;

    @Column(name = "email", nullable = false, unique = true)
    private String email;
    private String phone;
    private String tel;
    private String address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<UserRole> userRoles = new HashSet<>();

    private boolean enabled = true;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<GrantedAuthority> authorites = new HashSet<>();

        userRoles.forEach(ur -> authorites.add(new Authority(ur.getRole().getName())));

        return authorites;
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
        return enabled;
    }
}
