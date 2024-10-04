package com.qima.challenge.security;

import javax.crypto.SecretKey;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class KeyGenerator {
    public static void main(String[] args) {
        // Gera uma chave secreta de 256 bits para HS256
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        
        // Obtém os bytes da chave
        byte[] keyBytes = key.getEncoded();
        
        // Calcula o tamanho em bits
        int keySizeInBits = keyBytes.length * 8;

        // Imprime a chave secreta e seu tamanho
        System.out.println("Generated Secret Key: " + java.util.Base64.getEncoder().encodeToString(keyBytes));
        System.out.println("Key Size: " + keySizeInBits + " bits");
    }
}
