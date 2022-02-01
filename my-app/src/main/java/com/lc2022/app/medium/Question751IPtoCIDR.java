package com.lc2022.app.medium;

import java.util.ArrayList;
import java.util.List;

public class Question751IPtoCIDR {
  /**
   * 1. convert ip to long
   * 2. check whether n increased
   *
   * */

  public List<String> ipToCIDR(String ip, int n) {
    Long ipLong = convertToLong(ip);
    List<String> result = new ArrayList<>();
    while(n != 0) {
      int numberOfTrailingZeros = Long.numberOfTrailingZeros(ipLong);
      int bits = 0;
      int cur = 1;
      while(cur < n && bits < numberOfTrailingZeros) {
        cur = cur << 1;
        bits++;
      }
      if (cur > n) {
        bits--;
        cur = cur >> 1;
      }
      result.add(convertToStringWithMask(ipLong, 32-bits));
      ipLong += cur;
      n -= cur;
    }
    return result;
  }

  public Long convertToLong(String ip) {
    String[] sections = ip.split("\\.");
    Long result = 0L;
    for(int i = 0; i <= 3; i++) {
      Long tmp = Long.parseLong(sections[i]);
      result = (result << 8) + tmp;
    }
    return result;
  }

  public String convertIpToString(Long ip) {
    StringBuilder sb = new StringBuilder();

    for(int i = 3; i >= 0; i--) {
      Long mask = (long)(0B11111111<<(8*i));
      Long newNum = ip & mask;
      newNum = newNum >> (8*i);
      sb.append(newNum);
      if(i != 0) {
        sb.append(".");
      }
    }
    return sb.toString();
  }

  public String convertToStringWithMask(long ip, int maskLength) {
    return String.format("%s/%d", convertIpToString(ip), maskLength);
  }
}
