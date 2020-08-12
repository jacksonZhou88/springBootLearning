package com.jacksonzhou.spring.serviceprovider1.DesignPattern;

public class NomalBullet implements BulletInterface {
    @Override
    public void shoot() {
        System.out.println("咻咻！");
    }
}
