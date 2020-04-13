package com.soft1851.springboot.aop.aspect;

import com.soft1851.springboot.aop.annotation.AuthToken;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/4/13 15:42
 * @Version 1.0
 **/
@Aspect
@Component
@Slf4j
public class AuthTokenAspect {

    /**
     * 配置加上自定义注解的方法为切点
     *只有方法标注了这个注解的，都会被切
     * @param authToken
     */
    @Pointcut("@annotation(authToken)")
    public void doAuthToken(AuthToken authToken) {
    }

    @Around(value ="doAuthToken(authToken)",argNames="pjp,authToken")
    public Object doAround(ProceedingJoinPoint pjp, AuthToken authToken) throws Throwable {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert sra != null;
        HttpServletRequest request = sra.getRequest();
        //取得注解中的role_name的值
        String[] roleNames = authToken.role_name();
        //没有role的值
        if (roleNames.length <=1){
            //只需要认证（登录）
            String id = request.getHeader("id");
            //如果id为空，证明用户没有登录
            //如果id不空，就可以调用目标方法
            if (id != null) {
                //这个方法是调用连接点的目标方法
                return pjp.proceed();
            }
            return "请先登录";
        }else {
            //验证身份
            String role = request.getHeader("role");
            log.info(role);
            //遍历roleNames数组，匹配role
            for (String roleName:roleNames) {
                if (roleName.equals(role)) {
                    //身份匹配成功，调用目标方法
                    return pjp.proceed();
                }
            }
            return "权限不足，无法访问";
        }

    }
}
