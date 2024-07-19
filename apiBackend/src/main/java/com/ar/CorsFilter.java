package com.ar;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class CorsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CorsFilter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        // Permitir acceso desde cualquier origen
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
        System.out.println("Set Access-Control-Allow-Origin header");

        // Métodos permitidos
        httpResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        System.out.println("Set Access-Control-Allow-Methods header");

        // Cabeceras permitidas
        httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        System.out.println("Set Access-Control-Allow-Headers header");

        // Preflight (OPTIONS) cache timeout (10 minutos)
        httpResponse.setHeader("Access-Control-Max-Age", "600");
        System.out.println("Set Access-Control-Max-Age header");

        // Si es una solicitud OPTIONS, simplemente termina la solicitud
        if ("OPTIONS".equalsIgnoreCase(httpRequest.getMethod())) {
            httpResponse.setStatus(HttpServletResponse.SC_OK);
            System.out.println("Handled preflight request");
            return;
        }

        // Continúa con el siguiente filtro en la cadena
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("CorsFilter destroy");
    }
}