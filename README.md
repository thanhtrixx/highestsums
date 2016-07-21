# highestsums

 **This project to resolve bellow requirement:**
 You are given several lists of integers. The integers in each list are 
 non-increasing from the list head to the list tail (so the largest value in a 
 list will always be at the head, and the smallest at the tail). You may assume 
 every list contains at least one integer. A list may contain duplicate entries.
 
 You are asked to build a sum by picking one integer from each list. Find the n 
 largest sums amongst all the combinations of picking an integer from each list, 
 where n is some positive value. For example if n is 1, then you are simply 
 expected to find the sum that can be created by adding together the highest 
 integers in all the lists. If there are not n largest sums available (i.e. n is
 larger than the number of combinations of all list entries), you should return
 as many sums as possible. In any case, the result may contain duplicate entries. 
 
 Implement the following method that accepts these lists and a positive integer 
 parameter n, and returns the n largest sums found in non-increasing order 
 (i.e. largest sum returned first).
 
     List findHighestSums(int[][] lists, int n) {
     }
 
 For example, given the lists:
 
     [5,4,3,2,1]
     [4,1]
     [5,0,0]
     [6,4,2]
     [1] 
 
 and a value of 5 for n, your procedure should return a List of size 5:
 
     [21,20,19,19,18]
     
 **Clone, run test & view test report:**
 
 * Clone
 
        git clone https://github.com/thanhtrixx/highestsums

 * Run test
 
         mvn clean cobertura:cobertura 
  
  
 * View test report
 
    * To view test report open file:
    
            ${project}/target/surefire-reports/TEST-HighestSumsTest.xml
    
    * To view coverage report open file:
    
            ${project}/target/site/cobertura/index.html