package com.restfun;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 本例中，我们需要创建Condition的实现并根据环境中是否存在magic属性来做出决策。
 * MagicExistsCondition是实现看Condition接口的类型
 */

public class MagicExistsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment env = context.getEnvironment();
        return env.containsProperty("magic");  // 检查magic属性
    }
}
