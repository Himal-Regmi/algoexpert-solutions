package famousalgorithm.medium;

import java.util.*;

// O(n ^ 2) and O(n ^ 2)
public class StableInternships {
  public int[][] stableInternships(int[][] interns, int[][] teams) {
    Map<Integer, Integer> teamInternMapping = new HashMap<>();
    Stack<Integer> internsAvailable = new Stack<>();
    for (int i = 0; i < interns.length; i++) {
      internsAvailable.push(i);
    }
    int[] currentInternChoice = new int[interns.length];

    List<HashMap<Integer, Integer>> teamsPriority = new ArrayList<>();

    for (int[] team : teams) {
      HashMap<Integer, Integer> teamPriority = new HashMap<>();
      for (int i = 0; i < team.length; i++) {
        teamPriority.put(team[i], i);
      }
      teamsPriority.add(teamPriority);
    }

    while (!internsAvailable.isEmpty()) {
      int internNum = internsAvailable.pop();

      int[] intern = interns[internNum];
      int teamPreference = intern[currentInternChoice[internNum]];

      currentInternChoice[internNum]++;

      if (!teamInternMapping.containsKey(teamPreference)) {
        teamInternMapping.put(teamPreference, internNum);
        continue;
      }

      int previousIntern = teamInternMapping.get(teamPreference);
      int previousInternRank = teamsPriority.get(teamPreference).get(previousIntern);
      int currentInternRank = teamsPriority.get(teamPreference).get(internNum);

      if (currentInternRank < previousInternRank) {
        teamInternMapping.put(teamPreference, internNum);
        internsAvailable.push(previousIntern);
      } else {
        internsAvailable.push(internNum);
      }
    }

    int[][] stableInternships = new int[interns.length][2];
    int index = 0;

    for (Map.Entry<Integer, Integer> internChosen : teamInternMapping.entrySet()) {
      stableInternships[index] = new int[] {internChosen.getValue(), internChosen.getKey()};
      index++;
    }

    return stableInternships;
  }
}
