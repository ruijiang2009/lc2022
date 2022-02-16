package com.lc2022.app.hard;

import java.util.ArrayList;
import java.util.List;

public class Question68TextJustification {

  public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> result = new ArrayList<>();
    int startIdx = 0;
    int endIdx = 0;
    int counter = 0;

    while(startIdx < words.length && endIdx < words.length) {
      if (counter + 1 + words[endIdx].length() <= maxWidth) {
        counter += 1 + words[endIdx].length();
      } else {
        result.add(getOneLine(words, startIdx, endIdx-1, maxWidth));
        startIdx = endIdx;
        counter = words[startIdx].length();
      }
      endIdx++;
    }
    // last line
    result.add(getLastLine(words, startIdx, words.length -1, maxWidth));
    return result;
  }


  private String getOneLine(String[] words, int startIdx, int endIdx, int maxWidth) {
    if (endIdx == words.length-1) {
      return getLastLine(words, startIdx, endIdx, maxWidth);
    }
    int numberOfWords = endIdx - startIdx + 1;
    StringBuilder sb = new StringBuilder();
    if (numberOfWords == 1) {
      sb.append(words[startIdx]);
      for(int i = 1; i <= (maxWidth - words[startIdx].length()); i++ ) {
        sb.append(" ");
      }
      return sb.toString();
    }
    int numberOfSpace = 0;
    int wordsLength = 0;
    for(int i = startIdx; i <= endIdx; i++) {
      wordsLength += words[i].length();
    }
    numberOfSpace = maxWidth - wordsLength;

    int normalSpace = numberOfSpace / (numberOfWords-1);
    int remainedSpace = numberOfSpace % (numberOfWords-1);
    int spaceCount = 0;
    for(int i = 0; i <= (endIdx-startIdx); i++) {
      spaceCount = normalSpace;
      if (i != 0) {
        // add the space before
        if (i <= remainedSpace) {
          spaceCount++;
        }
        for(int j = 0; j < spaceCount; j++) {
          sb.append(" ");
        }
      }
      sb.append(words[i + startIdx]);
    }
    return sb.toString();
  }

  private String getLastLine(String[] words, int startIdx, int endIdx, int maxWidth) {
    StringBuilder sb = new StringBuilder();
    int lineLength = 0;
    for(int i = startIdx;i <= endIdx; i++) {
      if (i != startIdx) {
        sb.append(" ");
        lineLength++;
      }
      sb.append(words[i]);
      lineLength += words[i].length();
    }
    for(int i = 0; i < (maxWidth-lineLength); i++) {
      sb.append(" ");
    }
    return sb.toString();
  }

}
