package spittr.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;

/**
 * 使用mock SpringMVC 进行测试
 */

public class HomeControllerTest {

    @Test
    public void testHomePage() throws Exception {
        HomeController controller = new HomeController();
        MockMvc mockMvc = standaloneSetup(controller).build();  // 搭建MockMcv
        mockMvc.perform(get("/")).andExpect(view().name("home"));  // 对 "/" 执行GET请求，预期得到home视图
        mockMvc.perform(get("/homepage")).andExpect(view().name("home"));
    }
}