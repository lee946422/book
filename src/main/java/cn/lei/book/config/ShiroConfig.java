package cn.lei.book.config;

import org.apache.commons.collections.map.LinkedMap;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName ShiroConfig
 * @Description TODO
 * @Author lei
 * @Date 2020/9/5 21:28
 * @Version 1.0
 */
@Configuration
public class ShiroConfig {
    //    shiro过滤器工厂
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager getDefaultWebSecurityManager) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(getDefaultWebSecurityManager);
        factoryBean.setLoginUrl("/toLogin");
        //设置登陆成功后跳转的路径
        factoryBean.setSuccessUrl("/toIndex");
        //设置认证失败会访问的页面
        factoryBean.setUnauthorizedUrl("/toLogin");
        LinkedMap map = new LinkedMap();

        //设置过滤路径

        factoryBean.setFilterChainDefinitionMap(map);
        return factoryBean;
    }
    //安全管理器DefaultWebSecurityManager
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Param("getMyRealm") MyRealm getMyRealm){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(getMyRealm);
        return manager;
    }

    //realm
    @Bean
    public MyRealm getMyRealm(){
        return new MyRealm();
    }
}
