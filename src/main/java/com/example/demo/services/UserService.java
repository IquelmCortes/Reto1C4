package com.example.demo.services;

import com.example.demo.persistence.entities.Usuarios;
import com.example.demo.persistence.repository.UserRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService implements EntityService<Usuarios>{

    @Autowired
    UserRepository userRepository;

    @Override
    public Usuarios saveEntity(Usuarios user) {
        boolean cumple = user.getEmail().length() <= 50 && user.getName().length()<= 80 && user.getPassword().length() <=50;
        if(cumple){
            Usuarios users = userRepository.save(user);
            return users;
        }

        return new Usuarios(null,null, null);
    }

    @Override
    public List<Usuarios> getEntity() {
        return userRepository.findAll();
    }
    
    public boolean existeEmail(String email){
            List<Usuarios> users = userRepository.findAll();
            ArrayList<String> valida = new ArrayList<>();
            boolean respuesta = false;
            users.forEach(
                    user ->{
                        if(user.getEmail().equals(email)){
                            valida.add(email);
                        }
                    }
            );
            if (valida.isEmpty()){
                respuesta = false;
            }else{
                respuesta = true;
            }
            return respuesta;
    }
    
    public List<Usuarios> ExisteUsuario(String email, String password){
        List<Usuarios> users = userRepository.findAll();
        ArrayList<Usuarios> usersToSend = new ArrayList<>();
        users.forEach(
                user ->{
                    if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                        usersToSend.add(user);
                    }else{
                        Usuarios usuarionuevo = new Usuarios("NO DEFINIDO", email, password);
                        usersToSend.add(usuarionuevo);
                    }
                }
        );
        return usersToSend;
    }
}
