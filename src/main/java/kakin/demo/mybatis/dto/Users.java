package kakin.demo.mybatis.dto;



import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import kakin.demo.mybatis.repository.UserRepository;

public class Users implements UserDetails{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String userName;
    private String password;
    private Integer role;
    
    @Autowired
    private UserRepository userRepository;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Integer getRole() {
        return role;
    }
    public void setRole(Integer role) {
        this.role = role;
    }
    
    @Override
    public String toString() {
        return "Users [id=" + id + ", userName=" + userName + ", password=" + password + ", role=" + role + "]";
    }
    
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Role role = this.userRepository.selectRoleByUserId(id);
        return Collections.singleton(new SimpleGrantedAuthority(role.getName()));
    }
    @Override
    public String getUsername() {
        return userName;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return false;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}
