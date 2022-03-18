package com.lc2022.app.medium;

import org.junit.Assert;
import org.junit.Test;

public class Question1166DesignFileSystemTest {
  @Test
  public void test1() {
    Question1166DesignFileSystem.FileSystem fileSystem = new Question1166DesignFileSystem.FileSystem();
    fileSystem.createPath("/a", 1);
    Assert.assertEquals(1, fileSystem.get("/a"));
  }
}
