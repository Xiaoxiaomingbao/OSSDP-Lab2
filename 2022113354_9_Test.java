class TestSolution9 {
    public static void main(String[] args) {
        Solution9 s = new Solution9();
        testCanPartition(s);
        testCannotPartition(s);
        testSinglePerson(s);
        testEmptyDislikes(s);
        testIsolatedNodes(s);
        testDisconnectedGraph(s);
        testLargeDislikes(s);
        System.out.println("测试成功！");
    }

    private static void assertTrue(boolean var) {
        assert var == true;
    }

    private static void assertFalse(boolean var) {
        assert var == false;
    }

    /**
     * 测试目的：验证基本功能，能分组的情况
     */
    private static void testCanPartition(Solution9 s) {
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 4}};
        assertTrue(s.possibleBipartition(4, dislikes));
    }

    /**
     * 测试目的：验证基本功能，不能分组的情况
     */
    private static void testCannotPartition(Solution9 s) {
        int[][] dislikes1 = {{1, 2}, {1, 3}, {2, 3}};
        int[][] dislikes2 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}};
        assertFalse(s.possibleBipartition(3, dislikes1));
        assertFalse(s.possibleBipartition(5, dislikes2));
    }

    /**
     * 测试目的：验证边界值 n = 1
     */
    private static void testSinglePerson(Solution9 s) {
        assertTrue(s.possibleBipartition(1, new int[0][0]));
    }

    /**
     * 测试目的：验证 dislikes 数组为空
     */
    private static void testEmptyDislikes(Solution9 s) {
        assertTrue(s.possibleBipartition(5, new int[0][0]));
    }

    /**
     * 测试目的：验证孤立节点
     */
    private static void testIsolatedNodes(Solution9 s) {
        int[][] dislikes = {{1, 2}};
        assertTrue(s.possibleBipartition(3, dislikes));
    }

    /**
     * 测试目的：验证不连通图
     */
    private static void testDisconnectedGraph(Solution9 s) {
        int[][] dislikes = {{1, 2}, {3, 4}};
        assertTrue(s.possibleBipartition(4, dislikes));
    }

    /**
     * 测试目的：验证 dislikes 长度接近 10⁴ 的情况
     */
    private static void testLargeDislikes(Solution9 s) {
        int n = 10000;
        int[][] dislikes = new int[9999][2];
        for (int i = 0; i < 9999; i++) {
            dislikes[i][0] = i + 1;
            dislikes[i][1] = i + 2;
        }
        assertTrue(s.possibleBipartition(n, dislikes));
    }
}