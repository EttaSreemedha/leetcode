class Solution {
    public static int minSessions(int[] tasks, int sessionTime) {
        for (int k = 1; k <= tasks.length; k++) {
            int[] sessions = new int[k]; // each session stores total time used
            if (canAssign(tasks, sessions, 0, sessionTime)) {
                return k; // found minimum number of sessions needed
            }
        }
        return tasks.length; // worst case: one task per session
    }

    // Try to assign tasks[taskIdx] to any session
    static boolean canAssign(int[] tasks, int[] sessions, int taskIdx, int limit) {
        if (taskIdx == tasks.length) return true;

        for (int i = 0; i < sessions.length; i++) {
            if (sessions[i] + tasks[taskIdx] > limit) continue;

            sessions[i] += tasks[taskIdx];
            if (canAssign(tasks, sessions, taskIdx + 1, limit)) return true;
            sessions[i] -= tasks[taskIdx]; // backtrack

            if (sessions[i] == 0) break; // pruning: don’t try other empty slots
        }
        return false;
    }
}
