package com.jpmonroy.app.service;

import com.jpmonroy.app.model.User;
import com.jpmonroy.app.repository.UserRepository;

public class AuthService {

    private UserRepository userRepository = new UserRepository();

    public String register(String email, String password) {
        User existingUser = userRepository.findByEmail(email);

        if (existingUser != null) {
            return "El usuario ya existe";
        }

        User newUser = new User(email, password);
        userRepository.save(newUser);

        return "Usuario registrado correctamente";
    }

    public String login(String email, String password) {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            return "Credenciales inválidas";
        }

        if (!user.getPasswordHash().equals(password)) {
            return "Credenciales inválidas";
        }

        return "Login exitoso";
    }
}
