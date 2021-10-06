public class Solution{
     
    public static int removeDuplicates(int[] nums) {
        int j=0, fI = 0, equalToi=0;
        for(int i = 0; i  < nums.length && fI < nums.length; i += equalToi){
            equalToi = 0;
            for( j = i; j < nums.length && (nums[i] == nums[j]) ; j++) equalToi++;
            nums[fI] = nums[i]; 
            fI++;
        }
        return fI;
    }
    public static void printArr(int[] a){
        System.out.print("Array : ");
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args){
        int[] a = {1,1,2};
        int[] b = {0,0,1,1,1,2,3,4,4};
        System.out.println(Solution.removeDuplicates(a));
        Solution.printArr(a);
        System.out.println(Solution.removeDuplicates(b));
        Solution.printArr(b);
        
    }
}