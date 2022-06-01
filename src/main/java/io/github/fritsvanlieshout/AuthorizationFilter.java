package io.github.fritsvanlieshout;

import com.auth0.jwt.interfaces.DecodedJWT;

public interface AuthorizationFilter {

    /**
     * This method verifies and decode the JWT and gives
     * the authenticated user his/her authorities back.
     *
     * @param secretKey secret key for hashing algorithm.
     * @param token Json Web Token to identify the user.
     * @return decoded JWT.
     */
    DecodedJWT verifyToken(String secretKey, String token);
}
