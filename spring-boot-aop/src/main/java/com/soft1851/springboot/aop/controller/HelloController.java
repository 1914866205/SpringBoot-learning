package com.soft1851.springboot.aop.controller;

import com.soft1851.springboot.aop.annotation.ControllerWebLog;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/4/10 12:59
 * @Version 1.0
 **/
// api开头表示接口
@RestController
@RequestMapping(value = "/api/")
public class HelloController {
    @RequestMapping(value = "hello/{name}")
    @ControllerWebLog(name="hello",isSaved = true)
    public String getHello(@PathVariable  String name) throws Exception{
        System.out.println("啊啊啊啊啊啊啊啊啊啊");
        return "Hello"+name;
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

