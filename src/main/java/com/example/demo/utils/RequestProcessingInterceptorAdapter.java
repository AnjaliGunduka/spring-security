package com.example.demo.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.demo.common.Constants;
import com.example.demo.exception.UnauthorizedException;
import com.example.demo.service.JwtAuthenticationService;

@Configuration
public class RequestProcessingInterceptorAdapter implements HandlerInterceptor {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private JwtAuthenticationService jwtAuthenticationService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (handler instanceof HandlerMethod) {
			HandlerMethod method = (HandlerMethod) handler;
			EnableTokenAuthorisation methodAnnotation = method.getMethodAnnotation(EnableTokenAuthorisation.class);
			if (methodAnnotation != null) {
				logger.info("Getting Authorisation token from headers");
				String jwt = request.getHeader("Authorization");
				logger.info("Checking if token is valid or not");
				if (StringUtils.hasText(jwt) && jwtAuthenticationService.validateToken(jwt)) {
					logger.info("token is valid getting token payload details");
					TokenPayLoadDetails tokenPayLoadDetails = jwtAuthenticationService.getTokenPayLoadDetails(jwt);
					request.setAttribute("tokenPayLoadDetails", tokenPayLoadDetails);
				} else {
					logger.info("token is Invalid");
					throw new UnauthorizedException(Constants.ACCESS_FORBIDDEN);
				}
			}
		}
		return true;
	}

}
