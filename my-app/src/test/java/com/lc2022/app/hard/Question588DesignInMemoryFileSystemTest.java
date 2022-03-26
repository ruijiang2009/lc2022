package com.lc2022.app.hard;

import com.lc2022.app.util.PrintUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question588DesignInMemoryFileSystemTest {


  @Test
  public void test1() {
    Question588DesignInMemoryFileSystem.FileSystem solution = new Question588DesignInMemoryFileSystem.FileSystem();
    solution.ls("/");
    solution.mkdir("/a/b/c");
    solution.addContentToFile("/a/b/c/d", "hello");
    List<String> result = solution.ls("/");
    Assert.assertEquals(1, result.size());
    Assert.assertEquals("a", result.get(0));
    Assert.assertEquals("hello", solution.readContentFromFile("/a/b/c/d"));
  }

  @Test
  public void test2() {
    Question588DesignInMemoryFileSystem.FileSystem solution = new Question588DesignInMemoryFileSystem.FileSystem();
    solution.ls("/");
    solution.mkdir("/a/b/c");
    Assert.assertEquals("c", solution.ls("/a/b/").get(0));
  }

 @Test
 public void test3() {
   Question588DesignInMemoryFileSystem.FileSystem solution = new Question588DesignInMemoryFileSystem.FileSystem();
   solution.mkdir("/goowmfn");
   solution.ls("/goowmfn");
   solution.ls("/");
   solution.mkdir("/z");
   solution.ls("/");
   solution.ls("/");
   solution.addContentToFile("/goowmfn/c","shetopcy");
   solution.ls("/z");
   solution.ls("/goowmfn/c");
   solution.ls("/goowmfn");

 }
}
