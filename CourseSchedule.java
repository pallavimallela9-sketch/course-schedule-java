import java.util.*;

class CourseSchedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        // Create adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Indegree stores the number of prerequisites
        // required for each course
        int[] indegree = new int[numCourses];

        // Build the graph
        for (int[] prerequisite : prerequisites) {

            int course = prerequisite[0];
            int requiredCourse = prerequisite[1];

            graph.get(requiredCourse).add(course);

            indegree[course]++;
        }

        // Queue contains courses with no prerequisites
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {

            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int completedCourses = 0;

        // Process courses using BFS
        while (!queue.isEmpty()) {

            int currentCourse = queue.poll();

            completedCourses++;

            // Remove current course as a prerequisite
            for (int nextCourse : graph.get(currentCourse)) {

                indegree[nextCourse]--;

                // All prerequisites completed
                if (indegree[nextCourse] == 0) {
                    queue.add(nextCourse);
                }
            }
        }

        // If all courses are completed,
        // there is no cycle
        return completedCourses == numCourses;
    }

    public static void main(String[] args) {

        int numCourses = 4;

        int[][] prerequisites = {
            {1, 0},
            {2, 0},
            {3, 1},
            {3, 2}
        };

        System.out.println("Number of Courses: " + numCourses);

        System.out.println("\nPrerequisites:");

        for (int[] pair : prerequisites) {
            System.out.println(
                "Course " + pair[0] +
                " requires Course " + pair[1]
            );
        }

        boolean result =
            canFinish(numCourses, prerequisites);

        System.out.println("\nCan Finish All Courses: " + result);
    }
}
