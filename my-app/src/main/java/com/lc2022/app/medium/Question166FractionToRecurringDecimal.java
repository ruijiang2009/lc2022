package com.lc2022.app.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question166FractionToRecurringDecimal {
  public String fractionToDecimal(int numerator, int denominator) {
    StringBuilder sb = new StringBuilder();

    if ((numerator < 0 && denominator > 0)
        || (numerator > 0 && denominator < 0)) {
      sb.append("-");
    }
    long lnumerator = Math.abs((long)numerator);
    long ldenominator = Math.abs((long)denominator);
    long intPart = (lnumerator/ldenominator);
    lnumerator = lnumerator % ldenominator;
    sb.append(intPart);

    if (lnumerator != 0) {
      sb.append(".");
      sb.append(getFraction(lnumerator*10, ldenominator));
    }

    return sb.toString();
  }

  // numerator is always smaller than denominator
  public String getFraction(long numerator, long denominator) {
    List<Integer> quotients = new ArrayList<>();
    Set<Long> numSet = new HashSet<>();
    List<Long> numHistory = new ArrayList<>();
    long firstNum = -1;
    while(numerator != 0) {
      if(numSet.contains(numerator)) {
        firstNum = numerator;
        break;
      }
      numSet.add(numerator);
      numHistory.add(numerator);
      int quotient = (int)(numerator / denominator);
      quotients.add(quotient);
      numerator = numerator % denominator;
      if (numerator == 0) {
        break;
      }
      numerator *= 10;
    }
    StringBuilder sb = new StringBuilder();
    boolean addedParanthese = false;
    for(int i = 0; i < quotients.size(); i++) {
      if (numHistory.get(i) == firstNum && !addedParanthese) {
        sb.append("(");
        addedParanthese = true;
      }
      sb.append(quotients.get(i));
    }
    if (firstNum != -1) {
      sb.append(")");
    }

    return sb.toString();
  }
}
