package kakin.demo.mybatis.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kakin.demo.mybatis.dto.User;
import kakin.demo.mybatis.service.UserService;

@Controller
public class UserManageController {

    private UserService userService;
    
    public UserManageController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping("/getUser")
    public String selectUserById(ModelMap map, @RequestParam("userId")Long userId) {
        User user = this.userService.selectUserById(userId);
        List<User> userList = new ArrayList<User>();
        userList.add(user);
        map.addAttribute("users", userList);
        return "User";
    }
    
    @PostMapping("/deleteUserById")
    public String deleteUserById(@RequestParam("userId")Long userId) {
        this.userService.deleteUserById(userId);
        return "redirect:/manage";
    }
    
    @GetMapping("/getUserByName")
    public String selectUserByName(@RequestParam("userName")String userName) {
        @SuppressWarnings("unused")
        User user = this.userService.selectByName(userName);
        return "redirect:/manage";
    }
    
    @PostMapping("/updateAddressById")
    public String updateAddressById(@RequestParam("userId")Long userId, @RequestParam("userAddress")String userAddress) {
        this.userService.updateAddressById(userId, userAddress);
        return "redirect:/manage";
    }
    
    @GetMapping(value = "manage")
    public String manageUser(ModelMap map) {
        List<User> userList = this.userService.selectAllUser();
        map.addAttribute("users", userList);
        return "User";
    }
    
    @GetMapping(value = "searchUserForManage")
    public String searchUser(ModelMap map, Long userId, String userName, String userAddress, String userSex) {
        List<User> userList = this.userService.searchUserForManage(userId, userName, userAddress, userSex);
//        userList.stream().forEach(user -> {
//            System.out.println(user.toString());
//        });
        map.addAttribute("users", userList);
        return "User";
    }
    
    @PostMapping(value = "addUserForManage")
    public String addUser(@RequestParam("userName")String userName, @RequestParam("userAddress")String userAddress, @RequestParam("userSex")String userSex, @RequestParam("userHobbyId")String userHobbyId) {
        this.userService.addUser(userName, userAddress, userSex, userHobbyId);
        return "redirect:/manage";
    }
    
//    @GetMapping("/index")
//    public String login() {
//        return "login";
//     }
}
