package com.example.restfuldemo;


import com.example.restfuldemo.common.utils.JsonUtil;
import com.example.restfuldemo.vo.OrderVo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


/**
 * @program: webbase
 * @description:
 * @author: wlp
 * @create: 2019/1/10 10:40
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderFormTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setUp (){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void createOrder () throws Exception{
        OrderVo orderVo = new OrderVo();
        orderVo.setOrderName("kafka");
        orderVo.setPrice(23);
        String requestJson = JsonUtil.object2Json(orderVo);
        mockMvc.perform(MockMvcRequestBuilders.post("/orders")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                 .andReturn().getResponse().getContentAsString();
    }
    @Test
    public void Queryorder () throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/orders/11")
//                .param("orderName","kafka")
//                .param("price","25")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value("3"));//查询的根元素，例如$.length()代表整个传过来的json的文档
    }
    @Test
    public void Updateorder () throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.patch("/orders/11")
                .param("orderName","dado")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value("3"));//查询的根元素，例如$.length()代表整个传过来的json的文档
    }
}

