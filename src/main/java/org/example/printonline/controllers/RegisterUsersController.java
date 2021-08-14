package org.example.printonline.controllers;

import org.example.printonline.services.EmailVerificationService;
import org.example.printonline.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.MessagingException;

@Controller
@RequestMapping("/registerUsers")
public class RegisterUsersController {

    private final EmailVerificationService emailVerificationService;
    private final UserService userService;

    public RegisterUsersController(final EmailVerificationService emailVerificationService, final UserService userService) {
        this.emailVerificationService = emailVerificationService;
        this.userService = userService;
    }

    @PostMapping
    public String registerAsUser() {
        return "registerAsUser";
    }

    @PostMapping("/register")
    public String register(@RequestParam("firstname") final String firstname,
                           @RequestParam("lastname") final String lastname,
                           @RequestParam("email") final String email,
                           @RequestParam("password") final String password) throws MessagingException {

        userService.register(firstname, lastname, email, password);
        emailVerificationService.sendEmail(email);
        return "redirect:/login";
    }

}
