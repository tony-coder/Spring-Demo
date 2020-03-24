package com.concert;

public class CriticismEngineImpl implements CriticismEngine {
    public CriticismEngineImpl() {
    }

    @Override
    public String getCriticiam() {
        int i = (int) (Math.random() * criticismPool.length);
        return criticismPool[i];
    }

    // injected
    private String[] criticismPool;
    public void setCriticismPool(String[] criticismPool) {
        this.criticismPool = criticismPool;
    }
}
