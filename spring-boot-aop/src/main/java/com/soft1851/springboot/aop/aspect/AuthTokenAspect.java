package com.soft1851.springboot.aop.aspect;

import com.soft1851.springboot.aop.annotation.AuthToken;
import com.soft1851.springboot.aop.mapper.StudentMapper;
import com.soft1851.springboot.aop.common.ResponseBean;
import com.soft1851.springboot.aop.common.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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
    @Resource
    private StudentMapper studentMapper;


    /**
     * 配置加上自定义注解的方法为切点
     * 只有方法标注了这个注解的，都会被切
     *
     * @param authToken
     */
    @Pointcut("@annotation(authToken)")
    public void doAuthToken(AuthToken authToken) {
    }

    /**
     * object是指controller方法返回的类型
     *
     * @param pjp
     * @param authToken
     * @return
     * @throws Throwable
     */
    @Around(value = "doAuthToken(authToken)", argNames = "pjp,authToken")
    public Object doAround(ProceedingJoinPoint pjp, AuthToken authToken) throws Throwable {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert sra != null;
        HttpServletRequest request = sra.getRequest();
        //取得注解中的role_name的值
        String[] roleNames = authToken.role_name();
        //没有role的值
        if (roleNames.length <= 1) {
            //只需要认证（登录）
            String id = request.getHeader("id");

//            String token = request.getHeader("token");
//            String id=request.getParameter("id");
//            Map<String,Object> map=mapper.getUserById(id);
//            //如果id为空，证明用户没有登录
//            if (token != null && roleNames[0].equals(map.get("role_name"))) {
//                //返回controller方法的值
//                return pjp.proceed();
//            }


//            //如果id为空，证明用户没有登录
//            //如果id不空，就可以调用目标方法
//            if (studentMapper.getStudentById(id) != null) {
//                //这个方法是调用连接点的目标方法
//                return pjp.proceed();
//            }


            //id为空，需要登录，返回错误信息
//            return "请先登录";
            return ResponseBean.failure(ResultCode.USER_NOT_SIGN_IN);
        } else {

//           //请求头中取出role,验证身份
//            String id = request.getParameter("id");
//            Map<String, Object> map = mapper.getUserById(id);
//            for (String roleName : roleNames) {
//                if (roleName.equals(map.get("role_name"))) {
//                    //身份匹配成功
//                    return pjp.proceed();
//                }
//            }


            //验证身份
            String role = studentMapper.getStudentById(request.getHeader("id")).getRole();
            log.info("权限级别" + role);
            //遍历roleNames数组，匹配role
            for (String roleName : roleNames) {
                if (roleName.equals(role)) {
                    //身份匹配成功，调用目标方法
                    return pjp.proceed();
                }
            }

//            return "权限不足，无法访问";
            //匹配失败，没有目标方法gg
            // 授权
            return ResponseBean.failure(ResultCode.USER_NO_AUTO);
        }

    }
}
