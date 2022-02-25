package com.bulingbuling.admin.server.interceptor;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.bulingbuling.admin.server.common.ResultMap;
import com.bulingbuling.admin.server.tools.JWTUtil;
import com.bulingbuling.admin.server.tools.RedisService;
import com.bulingbuling.admin.server.user.service.UserService;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/** * 判断 redis 中是否存在 user 属性，如果存在就通过，如果不存在就跳转到 login 页面 */
@Service
public class TokenInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisService redisService;

    @Override
    public boolean preHandle (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        final Logger log = LoggerFactory.getLogger(UserService.class);
        ResultMap resultMap = new ResultMap();

        Map userInfo = JSONUtil.parseObj(redisService.get("userInfo"));

        if (HttpMethod.OPTIONS.toString().equals(httpServletRequest.getMethod())) {
            System.out.println("OPTIONS请求，放行");
            return true;
        }
        String token = httpServletRequest.getHeader("token");
        System.out.println(token);
        System.out.println(userInfo.get("token"));

        // 2、判断 token 是否存在
        if (token == null || "".equals(token)) {
            System.out.println("未登录");
            PrintWriter out = null;
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("application/json; charset=utf-8");
            try {
                resultMap.error(402, "请携带token");
                out = httpServletResponse.getWriter();
                out.print(resultMap);
                return false;
            } catch (IOException e) {
                log.error("response error", e);
            } finally {
                if (out != null)
                    out.close();
            }
        }
        // 3、解析token
        if(null == JWTUtil.verifyToken(token)){
            return false;
        }

        return true;
    }
}
