package com.udemy.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {

	private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// este metodo se va a ejecutar antes de entrar al controlador
		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// este metodo se va a ejecutar antes de sacar la vista
		long startTime = (long) request.getAttribute("startTime");
		LOG.info("--REQUEST URL: '" + request.getRequestURL().toString() + "' -- TOTAL TIME: '"
				+ (System.currentTimeMillis() - startTime) + "' ms");
	}

}
