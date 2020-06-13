package com.codegeek.aop.day4.introduction;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 一个简单的引入通知实现
 *
 * @author CodeGeekGao
 * @version Id: SimpleIntroductionInterceptor.java, v 1.0 2020/6/13 11:10 PM CodeGeekGao
 */
public class SimpleIntroductionInterceptor extends DelegatingIntroductionInterceptor implements Check {
    /**
     * 是否修改的标志
     */
    private Boolean isModified;

    private Map<Method, Method> methodCache = new HashMap<>();

    @Override
    public Boolean isModified() {
        return isModified;
    }

    /**
     * 简单实现MethodInterceptor的invoke方法
     *
     * @param mi
     * @return Object
     * @throws Throwable
     */
    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        // 如果未被修改
        if (!isModified) {
            if (mi.getMethod().getName().startsWith("set") && (mi.getArguments().length == 1)) {
                Method getter = getGetter(mi.getMethod());

                if (getter != null) {
                    Object newValue = mi.getArguments()[0];
                    Object oldValue = getter.invoke(mi.getThis(), null);
                    if (newValue != null && oldValue == null) {
                        isModified = true;
                    } else if (newValue == null && oldValue == null) {
                        isModified = false;
                    } else if (newValue == null && oldValue != null) {
                        isModified = true;
                    } else {
                        isModified = !newValue.equals(oldValue);
                    }

                }
            }
        }

        return super.invoke(mi);
    }

    private Method getGetter(Method setter) {
        Method getter = methodCache.get(setter);
        if (getter != null) {
            return getter;
        }

        String s = setter.getName().replaceFirst("set", "get");
        try {
            getter = setter.getDeclaringClass().getMethod(s, null);
            synchronized (methodCache) {
                methodCache.put(setter, getter);
            }
            return getter;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        }
    }
}
