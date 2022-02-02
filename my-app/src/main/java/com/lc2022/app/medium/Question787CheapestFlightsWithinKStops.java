package com.lc2022.app.medium;

import java.util.*;

public class Question787CheapestFlightsWithinKStops {
  class Point implements Comparable<Point>{
    int destination;
    int cost;
    int stops = 0;
    public Point(int destination, int distance) {
      new Point(destination, distance, 0);
    }

    public Point(int destination, int distance, int stops) {
      this.destination = destination;
      this.cost = distance;
      this.stops = stops;
    }

    @Override
    public int compareTo(Point other) {
      return Integer.compare(this.cost, other.cost);
    }
  }

  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    int[][] graph = new int[n][n];

    for(int[] flight : flights) {
      graph[flight[0]][flight[1]] = flight[2];
    }

    int[] destinationCosts = new int[n];
    Arrays.fill(destinationCosts, Integer.MAX_VALUE);
    int[] stops = new int[n];
    Arrays.fill(stops, Integer.MAX_VALUE);

    PriorityQueue<Point> pq = new PriorityQueue<>();
    pq.add(new Point(src, 0, -1));

    while(!pq.isEmpty()) {
      Point p = pq.poll();
      if (p.destination == dst) {
        return p.cost;
      }
      if (p.stops == k) {
        continue;
      }
      for(int neighbour = 0; neighbour < n; neighbour++) {
        int neighbourCost = graph[p.destination][neighbour];
        if (neighbourCost > 0) {
          int newNeighbourCost = p.cost + neighbourCost;

          if (destinationCosts[neighbour] > newNeighbourCost) {
            pq.add(new Point(neighbour, newNeighbourCost, p.stops+1));
            destinationCosts[neighbour] = newNeighbourCost;
          } else if (p.stops < stops[neighbour]) {
            pq.add(new Point(neighbour, newNeighbourCost, p.stops+1));
          }
          stops[neighbour] = p.stops;
        }
      }
    }
    return destinationCosts[dst] == Integer.MAX_VALUE ? -1 : destinationCosts[dst];
  }

}
