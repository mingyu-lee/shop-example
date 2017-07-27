package com.shop.user.domain.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Mingyu Lee on 2017-07-15.
 * Description:
 */
public class Authority implements GrantedAuthority {

    private final String authority;

    public Authority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
