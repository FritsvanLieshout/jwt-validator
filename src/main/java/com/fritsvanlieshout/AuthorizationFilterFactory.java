package com.fritsvanlieshout;

/**
 * Factory for creating instances of {@link AuthorizationFilter}.
 * @author Frits van Lieshout
 */
public final class AuthorizationFilterFactory {

    private AuthorizationFilterFactory() {
    }

    /**
     * Create an instance of {@link AuthorizationFilter}.
     * @return new instance.
     */
    public static AuthorizationFilter createAuthorizationFilter() {
        return new AuthorizationFilterImpl();
    }
}
