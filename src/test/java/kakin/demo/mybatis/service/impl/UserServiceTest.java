package kakin.demo.mybatis.service.impl;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import junit.framework.TestCase;
import kakin.demo.mybatis.dto.User;
import kakin.demo.mybatis.repository.UserRepository;
import kakin.demo.mybatis.repository.model.UserInfo;
import kakin.demo.mybatis.service.UserService;

@SpringBootTest
//@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest extends TestCase{

    //@InjectMocks
    private UserService userService;
    
    @MockBean
    private UserRepository mockUserRepository;

    @BeforeEach
    public void setUp() throws Exception {
        //mockUserRepository = mock(UserRepositoryImpl.class);
        userService = new UserServiceImpl(mockUserRepository);
    }
    
    @Test
    public void testSelectUserById() throws Exception {
        UserInfo userInfo = new UserInfo(11L, "张三", "北京", "男", "羽毛球");
        System.out.print("#############################################################");
        System.out.print(mockUserRepository == null);
        when(mockUserRepository.getUserInfoById(11l)).thenReturn(userInfo);
        
        User userTest = new User(11L, "张三", "北京", "男", "羽毛球");
        User user = userService.selectUserById(11L);
        assertTrue(userTest.equals(user));
    }
    
    @Test
    public void testSearchUserForManage() throws Exception {
        
        List<UserInfo> userInfos = new ArrayList<UserInfo>();
        UserInfo userInfo = new UserInfo (11L, "张三", "北京", "男", "羽毛球");
        userInfos.add(userInfo);
        
        when(mockUserRepository.searchUserForManage(11l, "张三", "北京", "男")).thenReturn(userInfos);

        User userTest = new User(11L, "张三", "北京", "男", "羽毛球");
        List<User> users = userService.searchUserForManage(11L, "张三", "北京", "男");
        User user = users.get(0);
        assertTrue(userTest.equals(user));
    }
    
    @Test
    public void testSelectByName() throws Exception {
        
        when(mockUserRepository.selectByName("张三")).thenReturn(new UserInfo(11L, "张三", "北京", "男", "羽毛球"));
        
        User userTest = new User(11L, "张三", "北京", "男", "羽毛球");
        User user = userService.selectByName("张三");
        
        assertTrue(userTest.equals(user));
    }
    
    @Test
    public void testSelectAllUser() throws Exception {
        List<UserInfo> userInfos = new ArrayList<UserInfo>();
        UserInfo userInfo = new UserInfo (11L, "张三", "北京", "男", "羽毛球");
        userInfos.add(userInfo);
        
        when(mockUserRepository.selectAllUser()).thenReturn(userInfos);

        User userTest = new User(11L, "张三", "北京", "男", "羽毛球");
        List<User> users = userService.selectAllUser();
        User user = users.get(0);
        assertTrue(userTest.equals(user));
    }
}
