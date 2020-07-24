package com.jacksonzhou.spring.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class AccessFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(AccessFilter.class);

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
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("send {} request to {}", request.getMethod(), request.getRequestURI());
        Object accessToken = request.getParameter("accessToken");
        if (null == accessToken) {
            log.warn("access token is null!");
            ctx.setSendZuulResponse(false);
            /*用户没有访问权限：401*/
            ctx.setResponseStatusCode(401);
            return null;
        }
        log.info("access is ok!");
        return null;
    }
}
