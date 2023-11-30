package com.example.spproject.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;



@Component
@Order(1)
public class TransactionFilter implements Filter {

    private static final Logger LOG = LogManager.getLogger(RequestLoggingFilter.class);
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        LOG.info(
                "Starting a transaction for req : {}",
                req.getRequestURI());

        chain.doFilter(request, response);
        LOG.info(
                "Committing a transaction for req : {}",
                req.getRequestURI());
    }

    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }

    // other methods
}


