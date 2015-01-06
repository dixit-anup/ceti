package com.ixi.ceti.core.logger;

import java.lang.reflect.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.FieldCallback;

/**
 * AppLogger BeanPostProcessor.
 * Created by Anup Dixit on July 15, 2015.
 */

@Component
public class AppLoggerPostProcessor implements BeanPostProcessor, Ordered  {

    public final String APP_PACKAGE = "com.ixi.ceti";

    public Object postProcessBeforeInitialization(final Object bean, String beanName) throws BeansException {

        ReflectionUtils.doWithFields(bean.getClass(), new FieldCallback() {

            public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {

                if (field.isAnnotationPresent(AppLogger.class) && bean.getClass().getPackage().toString().contains(APP_PACKAGE)) {

                    if (!field.isAccessible()) {
                        ReflectionUtils.makeAccessible(field);
                    }

                    Logger log = LoggerFactory.getLogger(bean.getClass());

                    field.set(bean, log);
                }
            }
        });

        return bean;
    }

    @Override
    public int getOrder() {
        return 10;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

}
