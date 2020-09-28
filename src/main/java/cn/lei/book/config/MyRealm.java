package cn.lei.book.config;

import cn.lei.book.pojo.User;
import cn.lei.book.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName Realm
 * @Description TODO
 * @Author lei
 * @Date 2020/9/5 21:29
 * @Version 1.0
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权");
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken userInfo = (UsernamePasswordToken) authenticationToken;
        User dbuser = userService.findByName(userInfo.getUsername());
        //用户不存在
        if (dbuser == null) {
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(dbuser,dbuser.getUserPassword(),getName());
        return authenticationInfo;
    }
}
