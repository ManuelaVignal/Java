/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.blogapp;

import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import it.tss.blogapp.entity.User;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.text.ParseException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;


/**
 *
 * 
 */
//Generazione token nonn psw

public class JWTManager {

    private static final String PRIVATE_KEY = "/META-INF/private_key.pem";
    private static final String ISS = "it.tss.blogapp";
    
//riceve user e genera token
    
    public String generate(User usr) {

        try {
            // jwt=token deve essere criptato con chiave pubblica e privata
            JSONObject jwt = generateJWT(usr);

            JWSHeader header = new JWSHeader.Builder(JWSAlgorithm.RS256)
                    .keyID(PRIVATE_KEY)
                    .type(JOSEObjectType.JWT)
                    .build();
// metodi libreria per marcare il token
            JWTClaimsSet claimSet = JWTClaimsSet.parse(jwt);

            SignedJWT signedJWT = new SignedJWT(header, claimSet);

            PrivateKey privateKey = readPrivateKey(PRIVATE_KEY);

            RSASSASigner signer = new RSASSASigner(privateKey);

            signedJWT.sign(signer);
//hai un token fatto messo ion serializzazione in stringa
            return signedJWT.serialize();

        } catch (ParseException ex) {
            Logger.getLogger(JWTManager.class.getName()).log(Level.SEVERE, null, ex);
            throw new JwtTokenException("Impossibile generare il JWT token ");
        } catch (Exception ex) {
            Logger.getLogger(JWTManager.class.getName()).log(Level.SEVERE, null, ex);
            throw new JwtTokenException("Impossibile generare il JWT token ");
        }
    }

    private PrivateKey readPrivateKey(String resourceName) throws Exception {
        byte[] byteBuffer = new byte[16384];
        int length = getClass().getResourceAsStream(resourceName)
                .read(byteBuffer);

        String key = new String(byteBuffer, 0, length).replaceAll("-----BEGIN (.*)-----", "")
                .replaceAll("-----END (.*)----", "")
                .replaceAll("\r\n", "")
                .replaceAll("\n", "")
                .trim();

        byte[] decodedKey = Base64.getDecoder().decode(key);
        return KeyFactory.getInstance("RSA")
                .generatePrivate(new PKCS8EncodedKeySpec(decodedKey));
    }

    private JSONObject generateJWT(User usr) {
        long currentTimeInSecs = (System.currentTimeMillis() / 1000);
        long expirationTime = currentTimeInSecs + 1000;

        JSONObject jwt = new JSONObject();
        jwt.put("iss", ISS); // chi fornisce il token
        jwt.put("iat", currentTimeInSecs); // generato il token
        //jwt.put("auth_time", currentTimeInSecs);
        jwt.put("exp", expirationTime);// quando dura il token
        jwt.put("sub", usr.getId().toString());// id utnete
        jwt.put("upn", usr.getEmail());// e-mail utente
        jwt.put("groups", loadGroups(usr));// gruppi di autorizzazione dell'utente
        return jwt;

    }
//genera un array con i gruppi dell'utente
    private JSONArray loadGroups(User user) {
        JSONArray result = new JSONArray();
        result.add("users");
        return result;
    }
}
