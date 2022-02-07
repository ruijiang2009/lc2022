package com.lc2022.app.medium;

import java.util.Arrays;

public class Question322CoinChange {
  public int coinChange(int[] coins, int amount) {

    int[] records = new int[amount+1];
    Arrays.fill(records, Integer.MAX_VALUE);
    records[0] = 0;
    for(int i = 1; i <= amount; i++) {
      for(int coin : coins) {
        if (i >= coin && records[i-coin] != Integer.MAX_VALUE) {
          records[i] = Math.min(records[i], records[i-coin] + 1);
        }
      }
    }

    return records[amount] == Integer.MAX_VALUE ? -1 : records[amount];
  }
}
