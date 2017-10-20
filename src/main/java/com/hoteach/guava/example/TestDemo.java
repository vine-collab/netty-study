package com.hoteach.guava.example;

public class TestDemo {
  public static void main(String args[]) throws Exception {
    for (int i = 0; i < 100; i++) {
      new Thread(() -> {
        try {
          System.out.println(Counter.getCounter());
        } catch (Exception e) {
          e.printStackTrace();
        }
      }).start();
    }
  }
}
