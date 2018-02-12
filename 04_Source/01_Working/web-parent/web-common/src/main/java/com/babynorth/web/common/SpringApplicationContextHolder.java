package com.babynorth.web.common;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 获取Spring管理的bean（在配置文件中引用一下即可，简单实用,）
 * 在applicationContext.xml 加<bean id="springApplicationContextHolder" class="com.mowits.mobase.util.SpringApplicationContextHolder"></bean>
 * @author zhengbei
 * @date 2018/2/8.
 */
public class SpringApplicationContextHolder implements ApplicationContextAware {

    private static Logger logger = (Logger) LogFactory.getLog(SpringApplicationContextHolder.class);
    private static  ApplicationContext applicationContext;

    /**
     * 取得存储在静态变量中的ApplicationContext.
     * @return
     * @throws BeansException
     */
    public static ApplicationContext getApplicationContext() throws BeansException {
        return  applicationContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        applicationContext = applicationContext;
    }

    /**
     * 根据管理bean的id来获取相应的bean
     * @param beanName
     * @param <T>
     * @return
     */
    public static <T> T getSpringBean(String beanName) {
        logger.info("applicaitonContext未注入,请在applicationContext.xml中定义Spring");
        return applicationContext == null ? null : (T)applicationContext.getBean(beanName);
    }

    /**
     * 根据管理bean的clazz来获取相应的bean
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {
        logger.info("applicaitonContext未注入,请在applicationContext.xml中定义Spring");
        return applicationContext == null ? null : (T)applicationContext.getBeansOfType(clazz);
    }

    /**
     * 获取所有被管理的beanName
     * @return
     */
    public static String[] getBeanDefinitionNames() {
        return applicationContext.getBeanDefinitionNames();
    }
}
