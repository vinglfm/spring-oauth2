package com.users.oauth2.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Collections;
import java.util.Map;

@RestController
public class UserController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_CLIENT')")
    public Map<String, String> base() {
        return Collections.singletonMap("message", "Authentication passed");
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_TRUSTED_CLIENT')")
    public Map<String, String> user(Principal user) {
        return Collections.singletonMap("message", "user is: " + user.toString());
    }
}
