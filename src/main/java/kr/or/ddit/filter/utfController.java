package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(filterName = "utfController", initParams = { @WebInitParam(name = "enc", value = "UTF-8") })
public class utfController implements Filter {
	String charset;
	private static final Logger logger = LoggerFactory.getLogger(utfController.class);
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.debug("utf필터 시작");
		charset = filterConfig.getInitParameter("encoding"); // web.xml에 initParam으로 설정된 utf값을 가져온다
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(charset);
		chain.doFilter(request, response);
		logger.debug("utf필터 설정 완료");
	}

	@Override
	public void destroy() {

	}

}
