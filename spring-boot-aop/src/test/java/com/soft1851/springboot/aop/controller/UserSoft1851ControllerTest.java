package com.soft1851.springboot.aop.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@WebAppConfiguration
@ComponentScan(basePackages = "com.soft1851.springboot.aop")
class UserSoft1851ControllerTest {
    //用于模拟调用Controller的接口发起请求
    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    //预加载内容，用来初始化对UserController的
    @BeforeEach
    public void setUp() throws Exception {
        mockMvc=MockMvcBuilders.webAppContextSetup(this.context).build();
        System.out.println(mockMvc);
    }

    @Test
    public void hello() throws Exception {
        /**
         * 1.mockMvc.perform执行一个请求
         * 2.MockMvcRequestsBuilders.get("xxx")构造一个请求
         * 3.ResultActions.param添加请求传值
         * 4.ResultActions.andExpect添加执行完成后的断言
         * 5.ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情
         *  比如此处使用MockMvcResultHandlers.print()输出整个响应结果信息
         * 6.ResultActions.accept(MediaType.TEXT_HTML_VALUE))设置返回类型
         * 7.ResultActions.andReturn表示执行完成后返回的相应的结果
         */
        mockMvc.perform(MockMvcRequestBuilders
//                .get("http://localhost:8081/api/user/all/tt")
//                .param("all", "涛涛"))
//                .andExpect(MockMvcResultMatchers.header().string("Content-Type", "application/json"))

                .post("http://localhost:8081/api/user/hello")
                .param("arg1", "涛涛")
                .param("arg2","2"))
                .andExpect(MockMvcResultMatchers.header().string("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.163 Safari/537.36"))
                .andExpect(MockMvcResultMatchers.header().string("Content-Type", "text/plain;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

}

//        1.测试普通控制器
//        mockMvc.perform(get("/user/{id}", 1)) //执行请求
//                .andExpect(model().attributeExists("user")) //验证存储模型数据
//                .andExpect(view().name("user/view")) //验证viewName
//                .andExpect(forwardedUrl("/WEB-INF/jsp/user/view.jsp"))//验证视图渲染时forward到的jsp
//                .andExpect(status().isOk())//验证状态码
//                .andDo(print()); //输出MvcResult到控制台
//        2.得到MvcResult自定义验证
//        MvcResult result = mockMvc.perform(get("/user/{id}", 1))//执行请求
//                .andReturn(); //返回MvcResult
//        Assert.assertNotNull(result.getModelAndView().getModel().get("user")); //自定义断言
//        3.验证请求参数绑定到模型数据及Flash属性
//        mockMvc.perform(post("/user").param("name", "zhang")) //执行传递参数的POST请求(也可以post("/user?
//        name=zhang"))
//                .andExpect(handler().handlerType(UserController.class)) //验证执行的控制器类型
//                .andExpect(handler().methodName("create")) //验证执行的控制器方法名
//                .andExpect(model().hasNoErrors()) //验证页面没有错误
//                .andExpect(flash().attributeExists("success")) //验证存在flash属性
//                .andExpect(view().name("redirect:/user")); //验证视图
//        4.文件上传
//        byte[] bytes = new byte[] {1, 2};
//        mockMvc.perform(fileUpload("/user/{id}/icon", 1L).file("icon", bytes)) //执行文件上传
//                .andExpect(model().attribute("icon", bytes)) //验证属性相等性
//                .andExpect(view().name("success")); //验证视图
//        5.JSON请求/响应验证
//        String requestBody = "{\"id\":1, \"name\":\"zhang\"}";
//        mockMvc.perform(post("/user")
//                .contentType(MediaType.APPLICATION_JSON).content(requestBody)
//                .accept(MediaType.APPLICATION_JSON)) //执行请求
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) //验证响应contentType
//                .andExpect(jsonPath("$.id").value(1)); //使用Json path验证JSON 请参考
//        http://goessner.net/articles/JsonPath/
//        String errorBody = "{id:1, name:zhang}";
//        MvcResult result = mockMvc.perform(post("/user")
//                .contentType(MediaType.APPLICATION_JSON).content(errorBody)
//                .accept(MediaType.APPLICATION_JSON)) //执行请求
//                .andExpect(status().isBadRequest()) //400错误请求
//                .andReturn();
//        Assert.assertTrue(HttpMessageNotReadableException.class.isAssignableFrom(result.getResolvedException().getClass()));//
//        错误的请求内容体
//        6.异步测试
////Callable
//        MvcResult result = mockMvc.perform(get("/user/async1?id=1&name=zhang")) //执行请求
//                .andExpect(request().asyncStarted())
//                .andExpect(request().asyncResult(CoreMatchers.instanceOf(User.class))) //默认会等10秒超时
//                .andReturn();
//        mockMvc.perform(asyncDispatch(result))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.id").value(1));
//        7.全局配置
//                mockMvc = webAppContextSetup(wac)
//                .defaultRequest(get("/user/1").requestAttr("default", true)) //默认请求如果其是Mergeable类型的，会自动合
//        并的哦mockMvc.perform中的RequestBuilder
//                .alwaysDo(print()) //默认每次执行请求后都做的动作
//                .alwaysExpect(request().attribute("default", true)) //默认每次执行后进行验证的断言
//                .build();
//        mockMvc.perform(get("/user/1"))
//                .andExpect(model().attributeExists("user"));




