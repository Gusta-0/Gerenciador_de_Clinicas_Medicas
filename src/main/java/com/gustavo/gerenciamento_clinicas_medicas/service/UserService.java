package com.gustavo.gerenciamento_clinicas_medicas.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public boolean sendPasswordResetLink(String email) {
        // Lógica para verificar se o e-mail existe
        // Caso exista, gera um link único de recuperação e envia para o e-mail
        if (emailExistsInDatabase(email)) {
            String resetLink = generatePasswordResetLink(email);
            sendEmail(email, resetLink);
            return true;
        }
        return false;
    }

    private boolean emailExistsInDatabase(String email) {
        // Lógica para verificar se o e-mail está registrado no banco de dados
        return true; // Apenas um exemplo, deveria ser uma consulta ao banco de dados
    }

    private String generatePasswordResetLink(String email) {
        // Gera um link de redefinição de senha único (pode incluir um token)
        return "https://www.seusite.com/resetar-senha?token=uniqueToken123";
    }

    private void sendEmail(String email, String resetLink) {
        // Lógica de envio de e-mail com o link de redefinição de senha
    }

//    public User validateUser(String username, String password) {
////        // Lógica para validar o usuário (pode ser uma consulta ao banco de dados)
////        if ("user".equals(username) && "user123".equals(password)) {
////            return User.withUsername(username)
////                    .password("{noop}" + password)
////                    .roles("USERS")
////                    .build();
////        } else if ("admin".equals(username) && "master123".equals(password)) {
////            return User.withUsername(username)
////                    .password("{noop}" + password)
////                    .roles("MANAGERS")
////                    .build();
////        }
////        return null; // Usuário inválido
//    }
}
