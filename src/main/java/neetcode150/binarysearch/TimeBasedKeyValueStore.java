package neetcode150.binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore {

  // Time -> get - O(n) & set - O(1)
  // Space -> O(m * n) -> m - number of keys & n - number of items in a key
  class TimeMap {

    record TimeValue(List<Integer> time, List<String> value) {}
    ;

    Map<String, TimeValue> timeMap;

    public TimeMap() {
      this.timeMap = new HashMap();
    }

    public void set(String key, String value, int timestamp) {
      TimeValue tv =
          timeMap.computeIfAbsent(key, k -> new TimeValue(new ArrayList<>(), new ArrayList<>()));
      tv.time.add(timestamp);
      tv.value.add(value);
    }

    public String get(String key, int timestamp) {
      if (!this.timeMap.containsKey(key)) {
        return "";
      }
      TimeValue timeValue = timeMap.get(key);

      String latestValue = "";
      int i = 0;

      while (i < timeValue.time.size() && timeValue.time.get(i) <= timestamp) {
        latestValue = timeValue.value.get(i);
        i++;
      }

      return latestValue;
    }
  }
}
