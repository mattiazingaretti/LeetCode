import java.util.LinkedList;
class Solution {
   

    
    public static void sortColors(int[] nums) {
        LinkedList zero = new LinkedList();
        LinkedList one = new LinkedList();
        LinkedList two = new LinkedList();
        
        LinkedList[] bucket = new LinkedList[3];
        bucket[0] = zero;
        bucket[1] = one;
        bucket[2] = two;
    
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                zero.add(nums[i]);
            }else if(nums[i] == 1){
                one.add(nums[i]);
            } else{
                two.add(nums[i]);
            }
        }
        System.out.println(zero.toString());
        System.out.println(one.toString());
        System.out.println(two.toString());
        int j = 0 , k =0, h=0;
        
        while( k+j+h < nums.length){
            if(zero.size() > 0 ){
                nums[k+j+h] = (int) zero.poll();
                j++;
            }else if(one.size() > 0){
                nums[k+j+h] = (int) one.poll();
                h++;
            }else if(two.size() > 0){
                nums[k+j+h] = (int) two.poll();
                k++;
            }
            
            
            
            
        }
    
        System.out.println(zero.toString());
        System.out.println(one.toString());
        System.out.println(two.toString());
        
        return;
    }


    public static void printArr(int[] a){
        
        for(int i = 0; i < a.length; i++){
            System.out.print(" "+ a[i]);
        }
        System.out.println();
        return;
    }

    public static void main(String[] args){
        int[] a = {2,0,2,1,1,0};
        Solution.sortColors(a);
        Solution.printArr(a);

    }
}