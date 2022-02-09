package kakin.demo.mybatis.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kakin.demo.mybatis.dto.Menu;
import kakin.demo.mybatis.dto.Role;
import kakin.demo.mybatis.dto.Users;
import kakin.demo.mybatis.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Users users = this.userRepository.selectForLogin(userName);
        if(users == null) {
            throw new UsernameNotFoundException("用户名不存在！");
        }
        
        System.out.println(users.toString());
        
        Role role = this.userRepository.selectRoleByUserId(users.getId());
        Menu menu = this.userRepository.selectMenuByUserId(users.getId());
        
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
                //AuthorityUtils.commaSeparatedStringToAuthorityList(role.getName());
        grantedAuthorityList.add(new SimpleGrantedAuthority(role.getName()));
        grantedAuthorityList.add(new SimpleGrantedAuthority(menu.getPermission()));
        
        return new User(users.getUsername(),new BCryptPasswordEncoder().encode(users.getPassword()),grantedAuthorityList);
    }

}
