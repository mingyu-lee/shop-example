package com.shop.user.domain.security;

import com.shop.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Mingyu Lee on 2017-07-15.
 * Description:
 */
@Entity
@Table(name="user_role")
@AllArgsConstructor
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @Getter
    @Setter
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    @Getter
    @Setter
    private Role role;


}
