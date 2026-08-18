# Course Schedule

## LeetCode Problem

**Problem Number:** 207

**Problem Name:** Course Schedule

## Problem Description

There are a total of `numCourses` courses that need to be completed.

Some courses have prerequisites. For example:

```text
[1, 0]
```

means that Course `0` must be completed before Course `1`.

The goal is to determine whether it is possible to finish all courses.

If the prerequisite relationships contain a cycle, it is impossible to complete all courses.

## Example

### Input

```text
numCourses = 4

prerequisites = [
    [1, 0],
    [2, 0],
    [3, 1],
    [3, 2]
]
```

### Output

```text
true
```

## Explanation

The courses can be completed in the following order:

```text
0 → 1 → 2 → 3
```

Therefore, all courses can be completed.

## Approach

This solution uses **BFS and Topological Sorting**.

### Steps

1. Create an adjacency list to represent the course relationships.
2. Calculate the indegree of every course.
3. Add all courses with indegree `0` to a queue.
4. Remove a course from the queue and mark it as completed.
5. Reduce the indegree of courses that depend on it.
6. When a course's indegree becomes `0`, add it to the queue.
7. Count the number of completed courses.
8. If all courses are completed, return `true`.
9. If some courses remain, a cycle exists and return `false`.

## Concepts Used

* Graph
* BFS
* Queue
* Topological Sort
* Adjacency List
* Indegree
* Cycle Detection

## Time Complexity

`O(V + E)`

Where:

* `V` = number of courses
* `E` = number of prerequisite relationships

## Space Complexity

`O(V + E)`

The adjacency list, indegree array, and queue require additional space.

## Language

Java

## File Name

`CourseSchedule.java`

## Repository Name

`course-schedule-java`

## Author

**M. Pallavi**
