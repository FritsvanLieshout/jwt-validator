package io.github.fritsvanlieshout;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit test for authorization filter.
 */
public class AuthorizationFilterTest
{
    private final AuthorizationFilterImpl authorizationFilter = new AuthorizationFilterImpl();

    private final static String TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJmcml0c3ZhbmxpZXNob3V0X2p3dC52ZXJpZmllciIsInJvbGVzIjpbIkFETUlOIiwiU1VQRVJfQURNSU4iXSwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDEwL2FwaS9wdWJsaWMvc2lnbmluIiwiZXhwIjoxNjg0NTg5MjM5fQ.UkJbXzvMn_kll8F0uaxWWQQzeAukNKW_UurFWEn2U5o";
    private final static String SECRET_KEY = "secure";

    /**
     * Verify token failed.
     */
    @Test
    public void verifyTokenFailed() {
        var decodedJWT = authorizationFilter.verifyToken(SECRET_KEY, "");
        assertThat(decodedJWT).isNull();
    }

    /**
     * Verify token successful.
     */
    @Test
    public void verifyTokenSuccess() {
        var decodedJWT = authorizationFilter.verifyToken(SECRET_KEY, TOKEN);
        var roles = decodedJWT.getClaim("roles").asArray(String.class);
        assertThat(roles.length).isGreaterThan(0);
        assertThat(roles.length).isEqualTo(2);
    }

    /**
     * Get the subject (username) of a token.
     */
    @Test
    public void getSubjectFromVerifiedToken() {
        var decodedJWT = authorizationFilter.verifyToken(SECRET_KEY, TOKEN);
        var subject = decodedJWT.getSubject();
        assertThat(subject).isNotNull();
        assertThat(subject).isEqualTo("fritsvanlieshout_jwt.verifier");
    }

    /**
     * Get role(s) of a token.
     */
    @Test
    public void getRolesFromVerifiedToken() {
        var decodedJWT = authorizationFilter.verifyToken(SECRET_KEY, TOKEN);
        var roles = decodedJWT.getClaim("roles").asArray(String.class);
        assertThat(roles).contains("ADMIN");
        assertThat(roles).contains("SUPER_ADMIN");
    }
}
