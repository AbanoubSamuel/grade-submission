package com.ltp.gradesubmission.security.manager;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Component;

import javax.naming.AuthenticationException;

@Component
public class CustomAuthenticationManager implements AuthenticationManager {
    public Authentication authenticate(Authentication authentication) throws AuthenticationException
    {
        return null;

    }

    @Override
    public org.springframework.security.core.Authentication authenticate(org.springframework.security.core.Authentication authentication) throws org.springframework.security.core.AuthenticationException {
        return null;
    }
}
