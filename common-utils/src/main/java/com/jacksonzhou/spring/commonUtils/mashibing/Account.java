package com.jacksonzhou.spring.commonUtils.mashibing;

/**
 * <p>功能描述：模拟银行账户，写数据加锁，读数据不加锁是否可以</p>
 * <ul>
 * <li>@param </li>
 * <li>@return </li>
 * <li>@throws </li>
 * <li>@author My</li>
 * <li>@date 2020/2/23 16:56</li>
 * </ul>
 */
public class Account {

    /*账户名称、余额*/
    private String name;
    private Double balance;

    public Account(String name, Double balance) {
        this.name = name;
        this.balance = balance;
    }

    /*为账户加钱*/
    public synchronized void setBalance(Double balance) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
        System.out.println("setting end: "+ balance);
    }

    /*获取账户余额*/
    public void getBalance() {
        System.out.println("balance:==="+balance);
    }

    public static void main(String[] args) {
        Account a = new Account("zhangsan", 0.0);
        /*第一个线程塞数据*/
        new Thread(() -> a.setBalance(100.00)).start();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*第二给线程读数据*/
        new Thread(() -> a.getBalance()).start();
    }
}
