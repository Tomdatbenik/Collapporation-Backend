package com.collapporation.gateway.filter;

import com.auth0.jwt.interfaces.JWTVerifier;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class AuthFilter extends ZuulFilter {
    private final JWTVerifier jwtVerifier;
    @Value("${collapporation.gateway.authfilter.matches}")
    private String regexMatches;

    public AuthFilter(JWTVerifier jwtVerifier) {
        this.jwtVerifier = jwtVerifier;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return RequestContext.getCurrentContext().getRequest().getServletPath().matches(regexMatches);
    }

    @Override
    public Object run() {
        final RequestContext context = RequestContext.getCurrentContext();
        final String jwt = context.getRequest().getHeader("Authorization").replace("Bearer ", "");
        try {
            jwtVerifier.verify(jwt);
        } catch (Exception e) {
            log.error("Exception during verification token: {}", e.getMessage());
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            context.setResponseBody("token is expired");
        }
        return null;
    }
}
