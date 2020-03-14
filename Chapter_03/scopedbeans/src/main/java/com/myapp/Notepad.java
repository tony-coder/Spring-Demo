package com.myapp;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 单例(Singleton):在整个应用中，只创建bean的一个实例
 * 原型(Prototype):每次注入或者通过Spring应用上下文获取的时候，都会创建一个新的bean实例
 */

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)  // 设置原型作用域
public class Notepad {
    // the details of this class are inconsequential to this example
}
