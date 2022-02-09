package kakin.demo.mybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kakin.demo.mybatis.dto.Menu;
import kakin.demo.mybatis.dto.Role;
import kakin.demo.mybatis.dto.Users;
import kakin.demo.mybatis.repository.model.UserInfo;

public interface UserRepository {

    UserInfo getUserInfoById(Long userId);

    void deleteUserInfoById(Long userId);

    UserInfo selectByName(String name);

    void updateAddressById(Long userId, String userAddress);

    List<UserInfo> selectAllUser();

    List<UserInfo> searchUserForManage(Long userId, String userName, String userAddress, String userSex);

    void addUser(String userName, String userAddress, String userSex, String userHobbyId);

    Users selectForLogin(@Param("userName")String userName);

    Role selectRoleByUserId(@Param("Id")Integer Id);

    Menu selectMenuByUserId(@Param("id")Integer id);
}
