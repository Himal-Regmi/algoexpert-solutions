package greedyalgorithms.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

// O(n * logn) && O(n)
public class TaskAssignment {
  public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
    ArrayList<ArrayList<Integer>> taskAssignment = new ArrayList<>();
    ArrayList<Task> taskList = new ArrayList<>();
    for (int i = 0; i < tasks.size(); i++) {
      Task task = new Task(i, tasks.get(i));
      taskList.add(task);
    }

    taskList.sort(Comparator.comparingInt((Task a) -> a.duration));

    int lowerIdx = 0;
    int higherIdx = taskList.size() - 1;

    while (higherIdx > lowerIdx) {
      int task1Index = taskList.get(lowerIdx).index;
      int task2Index = taskList.get(higherIdx).index;

      taskAssignment.add(new ArrayList<Integer>(Arrays.asList(task1Index, task2Index)));

      lowerIdx++;
      higherIdx--;
    }

    return taskAssignment;
  }

  public static class Task {
    int index;
    int duration;

    public Task(int index, int duration) {
      this.index = index;
      this.duration = duration;
    }
  }
}
