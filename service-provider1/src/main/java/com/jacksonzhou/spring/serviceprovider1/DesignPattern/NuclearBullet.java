package com.jacksonzhou.spring.serviceprovider1.DesignPattern;

public class NuclearBullet implements BulletInterface {
    @Override
    public void shoot() {
        System.out.println("boom~~~");
    }
}
