package spittr.controller;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import spittr.data.SpittleRepository;
import spittr.domain.Spittle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class SpittleControllerTest {
    private List<Spittle> createSpittleList(int count) {
        List<Spittle> spittles = new ArrayList<Spittle>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittles;
    }

    @Test
    public void shouldShowRecentSpittles() throws Exception {

        List<Spittle> expectedSpittles = createSpittleList(20);  // 创建20个Spittle对象
        // 首先创建SpittleRepository接口的mock实现
        SpittleRepository mockRepository = mock(SpittleRepository.class);  // Mock Repository
        // 这个实现会从它的findSpittles()方法中返回20个Spittle对象
        when(mockRepository.findSpittles(Long.MAX_VALUE, 20))
                .thenReturn(expectedSpittles);
        // 然后，它将这个mockRepository注入到一个新的SpittleController实例中
        SpittleController controller = new SpittleController(mockRepository);
        // 然后创建MockMvc并使用这个控制器
        // 这个测试在MockMvc构造器上调用了setSingleView()。这样的话，mock框架就不用解析控制器中的视图名了。
        // 对于这个控制器方法，视图名与请求路径十分相似，这样按照默认的视图解析规则时，MockMvc就会发生失败，因此无法区分视图路径和控制器的路径
        MockMvc mockMvc = standaloneSetup(controller)  // Mock Spring MVC
                .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
                .build();

        mockMvc.perform(get("/spittles"))  // 对"/spittles"发起GET请求
                .andExpect(view().name("spittles"))  // 断言视图名称为spittles
                .andExpect(model().attributeExists("spittleList"))  // 断言模型中包含名为spittleList的属性
                .andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));  // 断言期望的值 在spittleList中包含预期的内容
    }
}