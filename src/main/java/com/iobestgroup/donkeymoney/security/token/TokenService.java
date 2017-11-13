package com.iobestgroup.donkeymoney.security.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Michał Wąsowicz
 * @version 1.0
 * @since 13.11.17
 */
@Service
public class TokenService {

    private TokenRepository tokenDao;

    @Autowired
    public TokenService(TokenRepository tokenDao) {
        this.tokenDao = tokenDao;
    }

    public Token save(Token token){
        return tokenDao.save(token);
    }
}
