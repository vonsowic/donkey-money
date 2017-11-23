package com.iobestgroup.donkeymoney.security;

import io.jsonwebtoken.Jwts;
import org.springframework.http.HttpRequest;

import static com.iobestgroup.donkeymoney.security.SecurityConstants.SECRET;
import static com.iobestgroup.donkeymoney.security.SecurityConstants.TOKEN_PREFIX;

/**
 * Helper class for getting information from JSON Web Token.
 *
 * @author Michał Wąsowicz
 * @version 1.0
 * @since 14.11.17
 */
public class TokenDecoder {


    /**
     * @param token send by user.
     * @return Token's subject, for example user's email.
     */
    public static String getSubject(String token){
        return Jwts.parser()
                .setSigningKey(SECRET.getBytes())
                .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                .getBody()
                .getSubject();
    }
}
