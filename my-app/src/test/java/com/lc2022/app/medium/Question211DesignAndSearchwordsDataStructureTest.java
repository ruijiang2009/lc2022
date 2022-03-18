package com.lc2022.app.medium;

import org.junit.Assert;
import org.junit.Test;

public class Question211DesignAndSearchwordsDataStructureTest {

  @Test
  public void test1() {
    Question211DesignAndSearchwordsDataStructure.WordDictionary solution = new Question211DesignAndSearchwordsDataStructure.WordDictionary();
    solution.addWord("bad");
    solution.addWord("dad");
    solution.addWord("mad");
//    Assert.assertFalse(solution.search("pad"));
//    Assert.assertTrue(solution.search("bad"));
    Assert.assertTrue(solution.search(".ad"));
    Assert.assertTrue(solution.search("b.."));
  }
}
