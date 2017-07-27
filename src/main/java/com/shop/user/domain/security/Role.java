package com.shop.user.domain.security;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Mingyu Lee on 2017-07-15.
 * Description:
 */
@Entity
public class Role {

    @Id
    @Getter
    private long id;

    @Getter
    @Setter
    private String name;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Getter
    @Setter
    private Set<UserRole> userRoles = new HashSet<>();


}
