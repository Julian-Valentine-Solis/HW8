
/******************************************************************
 *
 *   Julian Solis / 001
 *
 *   This java file contains the problem solutions of canFinish and
 *   numGroups methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method canFinish
     *
     * You are building a course curriculum along with required intermediate
     * exams certifications that must be taken by programmers in order to obtain
     * a new certification called 'master programmer'. In doing so, you are placing
     * prerequisites on intermediate exam certifications that must be taken first.
     *
     * Unfortunately, in the past, your predecessors have accidentally published
     * curriculums and exam schedules that were not possible to complete due to
     * cycles
     * in prerequisites. You want to avoid this embarrassment by making sure you
     * define
     * a curriculum and exam schedule that can be completed.
     *
     * You goal is to ensure that any student pursuing the certificate of 'master
     * programmer', can complete 'n' certification exams, each being specific to a
     * topic. Some exams have prerequisites of needing to take and pass earlier
     * certificate exams. You do not want to force any order of taking the exams,
     * but
     * you want to make sure that at least one order is possible.
     *
     * This method will save your embarrassment by returning true or false if
     * there is at least one order that can taken of exams.
     *
     * You wrote this method, and in doing so, you represent these 'n' exams as
     * nodes in a graph, numbered from 0 to n-1. And you represent the prerequisite
     * between taking exams as directed edges between two nodes which represent
     * those two exams.
     *
     * Your method expects a 2-dimensional array of exam prerequisites, where
     * prerequisites[i] = [ai, bi] indicating that you must take exam 'bi' first
     * if you want to take exam 'ai'. For example, the pair [0, 1], indicates that
     * to take exam certification '0', you have to first have the certification for
     * exam '1'.
     *
     * The method will return true if you can finish all certification exams.
     * Otherwise, return false (e.g., meaning it is a cyclic or cycle graph).
     *
     * Example 1:
     * Input: numExams = 2, prerequisites = [[1,0]]
     * Output: true
     * Explanation: There are a total of 2 exams to take.
     * To take exam 1 you should have completed the
     * certification of exam 0. So, it is possible (no
     * cyclic or cycle graph of prereqs).
     *
     *
     * Example 2:
     * Input: numExams = 2, prerequisites = [[1,0],[0,1]]
     * Output: false
     * Explanation: There are a total of 2 exams to take.
     * To take exam 1 you should have completed the
     * certification of exam 0, and to take exams 0 you
     * should also have completed the certification of exam
     * 1. So, it is impossible (it is a cycle graph).
     *
     * @param numExams      - number of exams, which will produce a graph of n nodes
     * @param prerequisites - 2-dim array of directed edges.
     * @return boolean - True if all exams can be taken, else false.
     */
    public boolean canFinish(int numExams, int[][] prerequisites) {
        // Step 1: Make an adjacency list to represent the graph
        // Each node represents an exam, and edges show the "must take first"
        // relationships
        ArrayList<Integer>[] adjList = new ArrayList[numExams];
        for (int i = 0; i < numExams; i++) {
            adjList[i] = new ArrayList<>(); // Initialize an empty list for each exam
        }
        for (int[] prereq : prerequisites) {
            adjList[prereq[1]].add(prereq[0]); // Add a directed edge: to take 'prereq[0]', 'prereq[1]' must be
                                               // completed
        }

        // Step 2: Make two arrays to keep track of visited nodes
        boolean[] visited = new boolean[numExams]; // This tracks nodes in the current recursion path
        boolean[] checked = new boolean[numExams]; // This marks nodes that are already confirmed safe (no cycles)

        // Step 3: Check every node in the graph for cycles
        // We loop through all the exams because there could be disconnected parts of
        // the graph
        for (int i = 0; i < numExams; i++) {
            if (hasCycle(i, adjList, visited, checked)) {
                return false; // If there's any cycle, the prerequisites can't be completed
            }
        }

        // If no cycles are found, we can finish all exams
        return true;
    }

    // Helper method: checks for cycles in the graph using Depth-First Search (DFS)
    private boolean hasCycle(int node, ArrayList<Integer>[] adjList, boolean[] visited, boolean[] checked) {
        if (visited[node]) {
            // If we're visiting a node that's already in the current recursion stack,
            // there's a cycle
            return true;
        }
        if (checked[node]) {
            // If the node is already marked as safe, we don't need to check it again
            return false;
        }

        // Mark the node as part of the current path
        visited[node] = true;

        // Go through all the neighbors (exams that depend on this one)
        for (int neighbor : adjList[node]) {
            if (hasCycle(neighbor, adjList, visited, checked)) {
                // If any neighbor leads to a cycle, return true
                return true;
            }
        }

        // Unmark the node from the current path and mark it as safe
        visited[node] = false;
        checked[node] = true;

        // If no cycle is found, return false
        return false;
    }

    /**
     * Method numGroups
     *
     * Determines the number of connected groups in a graph represented by an
     * adjacency matrix.
     * There are n people. Some of them are connected as friends forming a group. If
     * person 'a' is
     * connected to person 'b', and person 'b' is connected to person 'c', they form
     * a connected
     * group.
     *
     * Not all groups are interconnected, meaning there
     * can be 1 or more groups depending on how people
     * are connected.
     *
     * Example 1:
     * Input :
     * AdjMatrix = [[0,1,0], [1,0,0], [0,0,0]]
     * Output: 2
     *
     * Example 2:
     * Input : AdjMatrix = [ [0,0,0], [0,0,0], [0,0,0]]
     * Output: 3
     */
    public int numGroups(int[][] adjMatrix) {
        int numNodes = adjMatrix.length;
        boolean[] visited = new boolean[numNodes]; // To track visited nodes
        int groupCount = 0; // Count of connected groups
        return -1;
    }

}
