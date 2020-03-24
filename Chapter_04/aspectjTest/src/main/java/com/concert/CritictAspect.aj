package com.concert;

public aspect CritictAspect {
    public CritictAspect() {
    }

    pointcut performance():execution(* perform(..));

    pointcut construct():execution(*.concert.CriticismEngineImpl.new());

    /*afterReturning():performance(){
        System.out.println(criticismEngine.getCriticiam());
    }*/

    // afterReturning():performance()用不了。。。
    // 作为替代方案，使用after():performance()

    after():performance(){
        System.out.println(criticismEngine.getCriticiam());
    }

    after():construct(){
        System.out.println("After Performance constructor");
    }

    before():construct(){
        System.out.println("Before Performance constructor");
    }


    private CriticismEngine criticismEngine;

    // 注入 CriticismEngine
    public void setCriticismEngine(CriticismEngine criticismEngine) {
        this.criticismEngine = criticismEngine;
    }
}
