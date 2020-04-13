package com.soft1851.springboot.aop.controller;

import com.soft1851.springboot.aop.annotation.ControllerWebLog;
import com.soft1851.springboot.aop.entity.User;
import com.soft1851.springboot.aop.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/4/7 14:12
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "/api/user/")
@Slf4j
public class UserSoft1851Controller {
    @Resource
    private UserMapper userMapper;

    @RequestMapping(value = "all/{name}")
    @ControllerWebLog(name = "all", isSaved = true)
    public List<User> selectAll(@PathVariable String name) {
        System.out.println(name);
        return userMapper.selectAll();
    }

    @RequestMapping(value = "hello1")
    @ControllerWebLog(name="getHello1",isSaved = true)
    public String getHello1(String arg1,int arg2) {
        log.info("控制层获取参数：" + arg1);
        log.info("控制层获取参数：" + arg2);

        //休眠，模拟接口耗时
        // sleep  在未来的多少毫秒内我不参与CPU竞争
        //  Thread.sleep(0)  触发操作系统立刻重新进行一次 CPU竞争
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello spring boot";
    }

    @PostMapping(value = "/hello")
    @ControllerWebLog(name="getHello",isSaved = true)
    public ResponseEntity<Object> getHello(String arg1,int arg2) {
        log.info("控制层获取参数：" + arg1);
        log.info("控制层获取参数：" + arg2);

        //休眠，模拟接口耗时
        // sleep  在未来的多少毫秒内我不参与CPU竞争
        //  Thread.sleep(0)  触发操作系统立刻重新进行一次 CPU竞争
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        HttpHeaders headers = new HttpHeaders();
        //根据自己的需要动态添加你想要的
        headers.add(HttpHeaders.USER_AGENT,"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.163 Safari/537.36");
        headers.add(HttpHeaders.CONTENT_TYPE,"text/plain;charset=UTF-8");
        return new ResponseEntity<Object>("hello spring boot",headers, HttpStatus.OK);
    }
}


/**
 * 条件：前置增强，后置增强，后置执行成功增强，抛出异常增强，环绕增强        手动制造异常并抛出，控制台打印，有返回值
 * 执行结果：只有环绕增强，后置增强，后置执行成功增强， 不执行前置增强，控制台不输出，也不报错，Response无返回值
 *
 * 条件：前置增强，后置增强，后置执行成功增强，环绕增强
 * 执行结果：只有环绕增强，后置增强，后置执行成功增强， 不执行前置增强，控制台不输出，Response无返回值
 *
 * 条件：前置增强，后置增强，后置执行成功增强，注释环绕增强      控制台打印，Response有返回值
 * 执行结果：前置增强，后置增强，后置执行成功增强      控制台有打印，Response有返回值
 *
 * 条件：前置增强，后置增强，后置执行成功增强，抛出异常增强 ，注释环绕增强       手动制造异常并抛出，控制台打印，有返回值
 * 执行结果：前置增强，后置增强，后置执行成功增强，抛出异常后增强，控制台不输出，但报错，Response返回报错信息
 *
 * 总结：环绕增强：会消除前置增强 控制台不输出，Response无返回值
 *      抛出异常增强：抛出异常后增强，控制台不输出，且报错，Response返回报错信息
 *      环绕增强+抛出异常增强：不执行前置增强，控制台不输出，也不报错，Response无返回值
 *
 */


