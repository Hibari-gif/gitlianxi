package kakin.demo.mybatis.service;

import java.util.List;

import kakin.demo.mybatis.dto.User;

public interface UserService {

    User selectUserById(Long userId);

    void deleteUserById(Long userId);

    User selectByName(String name);

    void updateAddressById(Long userId, String userAddress);

    List<User> selectAllUser();

    List<User> searchUserForManage(Long userId, String userName, String userAddress, String userSex);

    void addUser(String userName, String userAddress, String userSex, String userHobbyId);

}
