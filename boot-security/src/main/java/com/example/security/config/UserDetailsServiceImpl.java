package com.example.security.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("userDetailService")
public class UserDetailsServiceImpl implements UserDetailsService {
//    @Autowired
//    private AdminMapper adminMapper;
//    @Autowired
//    private RoleMapper roleMapper;
//    @Autowired
//    private PermissionMapper permissionMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
//            Admin user = adminMapper.getAdmin(username);
//            if (user == null) return null;
//            List<Role> roles = roleMapper.getRoles(user.getId());
//            if (roles.size() == 0) return null;
//            List<Permission> permissions = permissionMapper.getPermissions(roles);
            Set<String> authoritys = new HashSet<>();
//            for (Role role : roles) {
//                authoritys.add(String.format("ROLE_%s", role.getRoleName()));
//            }
//            for (Permission permission : permissions) {
//                if (permission.getType() == 2) {
//                    authoritys.add(permission.getPermission());
//                }
//            }
            List<GrantedAuthority> auths = AuthorityUtils.createAuthorityList(authoritys.toArray(new String[]{}));
            return new User(username, null, auths);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }
}
