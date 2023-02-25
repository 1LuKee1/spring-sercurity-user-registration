package com.example.springsercurity.message;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class WelcomeMessageService {

    private static final String LANG_ES = "es";
    private static final String LANG_PL = "pl";

    public String getWelcomeMessage(String lang) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        String welcomeMessage = switch (lang) {
            case LANG_ES -> "Hola";
            case LANG_PL -> "Cześć";
            default -> "Hello";
        };
        return welcomeMessage + " " + userName;
    }
}
