package br.com.caelum.agenda.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.sun.net.httpserver.Filter.Chain;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;


@WebFilter("/*")
public class FIltroTempoDeExecucao implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		long tempoInicial = System.currentTimeMillis();
		
		chain.doFilter(request, response);
		
		long tempoFinal = System.currentTimeMillis();
		String uri = ((HttpServletRequest)request).getRequestURI();
		String parametros = ((HttpServletRequest)request).getParameter("logica");
		System.out.println("Tempo da requisicao de" + uri + "?logica=" + parametros + " demorou (ms): "
				+ (tempoFinal - tempoInicial));
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
