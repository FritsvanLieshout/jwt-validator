package io.github.fritsvanlieshout;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class AuthorizationFilterImpl implements AuthorizationFilter {

    public AuthorizationFilterImpl() {
    }

    @Override
    public String[] verifyToken(String secretKey, String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = verifier.verify(token);
            return decodedJWT.getClaim("roles").asArray(String.class);
        } catch (JWTVerificationException exception) {
            return new String[0];
        }
    }
}
