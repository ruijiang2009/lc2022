package com.lc2022.app.medium;

import com.lc2022.app.util.PrintUtil;
import org.junit.Test;

import java.util.List;

public class Question751IPtoCIDRTest {

  Question751IPtoCIDR solution = new Question751IPtoCIDR();

  @Test
  public void test1() {
    String ip = "255.0.0.7";
    int n = 10;
    List<String> result = solution.ipToCIDR(ip, n);
    PrintUtil.printStrList(result);
  }

  @Test
  public void test2() {
    String ip = "117.145.102.62";
    int n = 8;
    List<String> result = solution.ipToCIDR(ip, n);
    PrintUtil.printStrList(result);
  }

  @Test
  public void test3() {
    String ip = "255.0.0.7";
    int n = 10;
    List<String> result = solution.ipToCIDR(ip, n);
    PrintUtil.printStrList(result);
  }

  @Test
  public void test4() {
    String ip = "255.0.0.255";
    int n = 10;
    List<String> result = solution.ipToCIDR(ip, n);
    PrintUtil.printStrList(result);
  }
}
