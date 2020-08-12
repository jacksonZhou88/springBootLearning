package com.jacksonzhou.spring.serviceprovider1.DesignPattern;

public class Tank {

    public void shoot(BulletInterface bulletInterface){
        bulletInterface.shoot();
    }

    public static void main(String[] args) {
        NomalBullet nb = new NomalBullet();
        Tank tank = new Tank();
        tank.shoot(nb);
    }
}
