package class272.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter // 보호된 url에만 이 필터를 적용하도록 설정
public class AuthenticationFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 초기화 코드, 단순히 로그인만 할거라 X
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		// 세션에서 사용자 정보 가져오기
		HttpSession session = httpRequest.getSession(false); // defalut 값 false
		boolean isLoggerIn = (session != null && session.getAttribute("user") != null); // 로그인이 되면

		if(isLoggerIn) {
			// 사용자가 로그인을 요청한 경우 허용
			chain.doFilter(request, response);
		} else {

			// 로그인 하지 않은 경우 로그인 페이지로 리다이렉션
			httpResponse.sendRedirect(httpRequest.getContextPath()+"/login.jsp");
		}
		
		
	}

	@Override
	public void destroy() {
		// 필터 종료시의 정리 코드, 단순히 로그인만 할거라 X
		
	}

}
