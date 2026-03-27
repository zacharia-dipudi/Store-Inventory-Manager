package Util;

/* Helper.java
Helper class
Author: Jayden Avontuur (222032278)
Date: 19 March 2026*/

public class Helper {
      public static boolean isNullOrEmpty(String str){
            if (str == null || str.isEmpty()){
                  return true;
            }
            return false;
      }

      public static boolean isValidQuantity(int quantity) {
                  if (quantity < 0) {
                        return false;
                  }
                  return true;
            }

      public static boolean isValidPrice(double price) {
                  if (price <= 0) {
                        return false;
                  }
                  return true;
            }

      public static boolean isValidStockLevels(int min, int max) {
                  if (min < 0 || max < 0 || min > max) {
                        return false;
                  }
                  return true;
            }
      }

