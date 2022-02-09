package kakin.demo.mybatis.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kakin.demo.mybatis.dto.Menu;
import kakin.demo.mybatis.dto.Role;
import kakin.demo.mybatis.dto.Users;
import kakin.demo.mybatis.repository.model.UserInfo;

@Mapper
public interface UserMapper {

    UserInfo selectUserById(Long userId);

    void deleteUserById(@Param("userId")Long userId);

    UserInfo selectByName(@Param("name")String name);

    void updateAddressById(Long userId, String userAddress);

    List<UserInfo> selectAllUser();

    List<UserInfo> searchUserForManage(@Param("userId")Long userId, @Param("userName")String userName, @Param("userAddress")String userAddress, @Param("userSex")String userSex);

    void addUser(@Param("userName")String userName, @Param("userAddress")String userAddress, @Param("userSex")String userSex, @Param("userHobbyId")String userHobbyId);

    Users selectForLogin(@Param("userName")String userName);

    Role selectRoleByUserId(@Param("id")Integer id);

    Menu selectMenuByUserId(@Param("id")Integer id);
}
