package com.concert;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * EncoreableIntroducer是一个切面，通过@DeclareParents注解，将Encoreable接口引入到Performance bean中
 * 借助于AOP的引入功能，我们可以不必在设计上妥协或者侵入式地改变现有的实现。
 */

@Aspect
public class EncoreableIntroducer {
    // value属性指定了哪种类型的bean要引入该接口,标记符后面的加号表示是Performance的所有子类型，而不是Performance本身
    // defaultImpl属性指定了为引入功能提供实现的类
    @DeclareParents(value = "com.concert.Performance+", defaultImpl = DefaultEncoreable.class)
    // @DeclareParents注解所标注的静态属性指明了要引入的接口，在这里我们所引入的是Encoreable接口
    public static Encoreable encoreable;

}
