package com.cloud.gateway;

public class mainTest {
    public static void main(String[] args) {
        MyBloomFilter myBloomFilter = new MyBloomFilter();
        myBloomFilter.add("~~");
        boolean contains = myBloomFilter.contains("~~");

        System.out.println(contains);
    }

}
