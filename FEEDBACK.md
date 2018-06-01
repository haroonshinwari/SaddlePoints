Do not compare conditions to `True` or `False` as they already have a boolean value.

```
     if (sadPoint == true){
                trueCount = trueCount + 1;
                int sadPointRow = saddlePointRow(randomArray);
                int sadPointColumn = saddlePointColumn(randomArray);
            }
            else {
                System.out.println("no saddle points");
             
```
Make appropriate use of constants.
```
     int minValue = -5;         //range for the values inside the random array
            int maxValue = 5;
        
```
Could you have avoided the repeated code structure by utilising an appropriately parameterised *helper* method?
```
     */
    int saddlePointRow(int[][] array){
        int sadPointRow = 0;
        int smallArray [] = smallestValues(array);
        int largestNum = largest(smallArray);
        for (int i = 0; i<smallArray.length;i++){
            if (smallArray[i] == largestNum){
                System.out.println("saddle point on row " + i);
            }
            sadPointRow = i;
        }
        return sadPointRow;
    }
    /**
     * Given an array that is known to have a saddle point, returns the number of a
     * column containing a saddle point. If more than one column contains a saddle point,
     * the first such column will be returned.
     *
     * @param array An array containing one or more saddle points.
     * @return The lowest-numbered column containing a saddle point.
     */

    int saddlePointColumn(int[][] array){
        int sadPointCol = 0;
        int largeArray [] = largestValues(array);
        int smallestNum = smallest(largeArray);
        for (int i = 0; i<largeArray.length;i++){
            if (largeArray[i] == smallestNum){
                System.out.println("saddle point on column " + i);
            }
            sadPointCol = i;
        }
        return sadPointCol;
    }
} 
```
