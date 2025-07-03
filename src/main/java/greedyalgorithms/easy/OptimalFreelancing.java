package greedyalgorithms.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

// O(n * logn) && O(1)
public class OptimalFreelancing {
  public int optimalFreelancing(Map<String, Integer>[] jobs) {

    Arrays.sort(
        jobs, Comparator.comparingInt((Map<String, Integer> a) -> a.get("payment")).reversed());

    //        Arrays.sort(jobs, new Comparator<Map<String, Integer>>(){
    //            public int compare(Map<String, Integer> a, Map<String, Integer> b){
    //                return b.get("payment").compareTo(a.get("payment"));
    //            }
    //        });
    //
    //        Arrays.sort(jobs, (a, b) -> b.get("payment").compareTo(a.get("payment")));

    int daysAvailableToWorkOn = 7;

    boolean[] daysTakenForWork = new boolean[daysAvailableToWorkOn];

    int totalPayment = 0;
    for (Map<String, Integer> job : jobs) {
      int deadline = job.get("deadline");
      int payment = job.get("payment");

      int preferredDayOfWork = Math.min(deadline - 1, daysTakenForWork.length - 1);

      while (preferredDayOfWork >= 0) {
        if (!daysTakenForWork[preferredDayOfWork]) {
          totalPayment += payment;
          daysTakenForWork[preferredDayOfWork] = true;
          break;
        }
        preferredDayOfWork--;
      }
    }

    return totalPayment;
  }
}
