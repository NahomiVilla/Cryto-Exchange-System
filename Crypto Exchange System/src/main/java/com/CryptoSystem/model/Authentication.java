package com.CryptoSystem.model;

import com.CryptoSystem.vistas.AuthenticationView;
import lombok.Data;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
@Data
public class Authentication {
    private AuthenticationView authenticationView;
    private Map<String,Users> usuariosRegristrados=new HashMap<>();
    private Users user;

    //@Getter
    private boolean sesionIniciada=false;

    public void registerUser(String email,Users newUser){

        usuariosRegristrados.put(email,newUser);
    }

    public boolean login(String email,String password){
        Users usuarioRegistrado=usuariosRegristrados.get(email);
        if (usuarioRegistrado!=null && usuarioRegistrado.getPassword().equals(password)){
            sesionIniciada=true;
            user=usuariosRegristrados.get(email);
            return true;
        }
        return false;
    }
    public void  singOut(){
        sesionIniciada=false;
        user=null;
    }


}
