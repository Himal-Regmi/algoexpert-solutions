package neetcode150.arraysandhashing;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
  class Solution {
    public int[] productExceptSelf(int[] nums) {
      int[] products = new int[nums.length];
      Arrays.fill(products, 1);
      int currentProduct = nums[0];
      for (int i = 1; i < nums.length; i++) {
        products[i] = currentProduct;
        currentProduct *= nums[i];
      }
      currentProduct = nums[nums.length - 1];
      for (int i = nums.length - 2; i >= 0; i--) {
        products[i] *= currentProduct;
        currentProduct *= nums[i];
      }

      return products;
    }
  }
}
