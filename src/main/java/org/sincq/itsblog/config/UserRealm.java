package org.sincq.itsblog.config;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.sincq.itsblog.entity.Authorization;
import org.sincq.itsblog.service.AuthorizationService;
import org.sincq.itsblog.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private ChallengeService challengeService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // System.out.println("执行了=>授权doGetAuthorizationInfo");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(Collections.singleton("user:admin"));

        // 获取当前登陆的对象
        // 那么如何设置登陆的对象呢?
        Subject subject = SecurityUtils.getSubject();
        Authorization currentUser = (Authorization) subject.getPrincipal();
        info.addStringPermission(currentUser.getPrams());

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // System.out.println("执行了=>认证doGetAuthenticationInfo");
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;

        String md5 = challengeService.getMD5ByUsername(usernamePasswordToken.getUsername());
        if(md5 == null)
            return null;
        String parms = authorizationService.getPramsByUsername(usernamePasswordToken.getUsername());

        Authorization authorization = new Authorization();
        authorization.setMd5(md5);
        authorization.setPrams(parms);
        authorization.setName(usernamePasswordToken.getUsername());

        Subject currentSubject = SecurityUtils.getSubject();
        Session session = (Session) currentSubject.getSession();
        // loginUser 设置的是authorization
        session.setAttribute("loginUser", authorization);

        return new SimpleAuthenticationInfo(authorization, md5, "");
    }
}
