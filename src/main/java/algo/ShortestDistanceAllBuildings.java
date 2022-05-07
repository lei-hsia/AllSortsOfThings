package algo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lei
 * @date 03/23/2022 2:51 PM
 */
public class ShortestDistanceAllBuildings {
    // sum of distance from 0 to all 1
    int[][] distance;
    // number of buildings each 0 can reach
    int[][] reach;
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        distance = new int[m][n];
        reach = new int[m][n];
        int buildingNum = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    buildingNum++;
                    bfs(grid, i, j);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0 && reach[i][j] == buildingNum) {
                    res = Math.min(res, distance[i][j]);
                }
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void bfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});

        // for this building: one-time bfs: each would new a visited array
        boolean[][] visited = new boolean[m][n];
        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; ++i) {
                int[] cur = q.poll();
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x < 0 || y < 0 || x >= m || y >= n) continue;
                    if (visited[x][y] || grid[x][y] != 0) continue;
                    distance[x][y] += level;
                    reach[x][y]++;
                    visited[x][y] = true;
                    q.offer(new int[]{x, y});
                }
            }
            level++;
        }
    }
}
