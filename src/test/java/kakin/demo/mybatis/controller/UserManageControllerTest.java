package kakin.demo.mybatis.controller;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import kakin.demo.mybatis.dto.User;
import kakin.demo.mybatis.service.UserService;

//@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
@SpringBootTest
public class UserManageControllerTest {

    private UserManageController userManageController;
    
    @MockBean
    private UserService userService;

    private MockMvc mockMvc;
    
    @BeforeEach
    public void setUp() throws Exception {
        userManageController = new UserManageController(userService);
        mockMvc = MockMvcBuilders.standaloneSetup(userManageController).build();
    }
    
    @Test
    public void testManage() throws Exception {

//        List<User> users = new ArrayList<User>();
//        User user = new User (11L, "张三", "北京", "男", "羽毛球");
//        users.add(user);
//        when(userService.selectAllUser()).thenReturn(users);
        System.out.println("=====manage测试开始=====");
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/manage"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals(200, status);
        System.out.println("=====manage测试结束=====");
    }
    
    @Test
    public void testGetUser() throws Exception {
        
        System.out.println("=====getUser测试开始=====");
        User user = new User (11L, "张三", "北京", "男", "羽毛球");
        when(userService.selectUserById(11L)).thenReturn(user);
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/getUser").param("userId", "11"));
        MvcResult mvcResult = resultActions.andReturn();
        System.out.println(mvcResult.getResponse().getStatus());
        System.out.println("=====getUser测试结束=====");
    }
    
    @Test
    public void testGetUserByName() throws Exception {
        System.out.println("=====GetUserByName测试开始=====");

        User user = new User (11L, "张三", "北京", "男", "羽毛球");
        when(userService.selectUserById(11L)).thenReturn(user);
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/getUser").param("userId", "11"));
        MvcResult mvcResult = resultActions.andReturn();
        System.out.println(mvcResult.getResponse().getStatus());
        System.out.println("=====GetUserByName测试结束=====");

    }
}

