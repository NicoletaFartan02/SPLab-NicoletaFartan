package com.example.spproject.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;



@Component
@Order(2)
public class RequestLoggingFilter implements Filter {

    private static final Logger LOG = LogManager.getLogger(RequestLoggingFilter.class);
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        LOG.info(
                "Logging Request  {} : {}", req.getMethod(),
                req.getRequestURI());
        chain.doFilter(request, response);
        LOG.info(
                "Logging Response :{}",
                res.getContentType());
    }

    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }

    // other methods
}
