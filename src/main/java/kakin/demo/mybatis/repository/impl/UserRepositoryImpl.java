package kakin.demo.mybatis.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import kakin.demo.mybatis.dto.Menu;
import kakin.demo.mybatis.dto.Role;
import kakin.demo.mybatis.dto.Users;
import kakin.demo.mybatis.repository.UserRepository;
import kakin.demo.mybatis.repository.mapper.UserMapper;
import kakin.demo.mybatis.repository.model.UserInfo;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private UserMapper userMapper;

    public UserRepositoryImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserInfo getUserInfoById(Long userId) {
        return this.userMapper.selectUserById(userId);
    }

    @Override
    public void deleteUserInfoById(Long userId) {
        this.userMapper.deleteUserById(userId);
    }

    @Override
    public UserInfo selectByName(String name) {
        return this.userMapper.selectByName(name);
    }

    @Override
    public void updateAddressById(Long userId, String userAddress) {
        this.userMapper.updateAddressById(userId, userAddress);
    }

    @Override
    public List<UserInfo> selectAllUser() {
        return this.userMapper.selectAllUser();
    }

    @Override
    public List<UserInfo> searchUserForManage(Long userId, String userName, String userAddress, String userSex) {
        List<UserInfo> userInfoList = this.userMapper.searchUserForManage(userId, userName, userAddress, userSex);
        userInfoList.stream().forEach(user -> {
        System.out.println(user.toString());
        });
        return userInfoList;
    }

    @Override
    public void addUser(String userName, String userAddress, String userSex, String userHobbyId) {
        this.userMapper.addUser(userName, userAddress, userSex, userHobbyId);
    }

    @Override
    public Users selectForLogin(String userName) {
        return this.userMapper.selectForLogin(userName);
    }

    @Override
    public Role selectRoleByUserId(Integer Id) {
        return this.userMapper.selectRoleByUserId(Id);
    }

    @Override
    public Menu selectMenuByUserId(Integer id) {
        return this.userMapper.selectMenuByUserId(id);
    }

}
