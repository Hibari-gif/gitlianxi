package kakin.demo.mybatis.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import kakin.demo.mybatis.dto.User;
import kakin.demo.mybatis.repository.UserRepository;
import kakin.demo.mybatis.repository.model.UserInfo;
import kakin.demo.mybatis.service.UserService;

@Service
@CacheConfig(cacheNames = {"select-result", "demo"})
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User selectUserById(Long userId) {

        UserInfo userInfo = this.userRepository.getUserInfoById(userId);

        User user = new User();
        if (userInfo != null) {
            BeanUtils.copyProperties(userInfo, user);
        }
        return user;
    }
    
    @Override
    public void deleteUserById(Long userId) {
        this.userRepository.deleteUserInfoById(userId);
    }

    @Override
    public User selectByName(String name) {

        UserInfo userInfo = this.userRepository.selectByName(name);
        User user = new User();
        if (userInfo != null) {
            BeanUtils.copyProperties(userInfo, user);
        }
        return user;
    }

    @Override
    public void updateAddressById(Long userId, String userAddress) {
        this.userRepository.updateAddressById(userId, userAddress);
    }

    @Override
    public List<User> selectAllUser() {

        List<UserInfo> userInfoList = this.userRepository.selectAllUser();
        List<User> userList = new ArrayList<User>();
        for(UserInfo userInfo : userInfoList){
            User user = new User();
            BeanUtils.copyProperties(userInfo, user);
            userList.add(user);
        }
        return userList;
    }

    @Override
    @Cacheable
    public List<User> searchUserForManage(Long userId, String userName, String userAddress, String userSex) {

        List<UserInfo> userInfoList = this.userRepository.searchUserForManage(userId, userName, userAddress, userSex);
        List<User> userList = new ArrayList<User>();
        for(UserInfo userInfo : userInfoList){
            User user = new User();
            BeanUtils.copyProperties(userInfo, user);
            userList.add(user);
        }
        return userList;
    }

    @Override
    public void addUser(String userName, String userAddress, String userSex, String userHobbyId) {
        this.userRepository.addUser(userName, userAddress, userSex, userHobbyId);
    }
}
