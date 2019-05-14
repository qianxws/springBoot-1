package com.huajiance.springboot.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登陆成功后执行
 * @author hanxu
 */
@Component("authenticationSuccessHandler")
public class AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	private Logger logger = LoggerFactory.getLogger(getClass());

	//@Autowired
	//private ObjectMapper objectMapper;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		logger.info("登录成功");

		//response.setContentType("application/json;charset=UTF-8");
		//response.getWriter().write(objectMapper.writeValueAsString(authentication));
		response.sendRedirect("/index.html");
	}

}
