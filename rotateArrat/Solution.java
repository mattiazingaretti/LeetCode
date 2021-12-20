class Solution {
    
    //i <= j 
    public static void invertFromItoJ(int[] a , int i , int j){
        while(i <= j){
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
            i++;
            j--;
        }
        return;
    }
    
    public static void rotate(int[] nums, int k) {
        if((nums.length % k == 0 && k != 1) || k == 0 ) return; //No need to rotate
        
        //Scambio i primi k elementi con gli ultimi k elementi
        //[TODO: Use util static function ]
        int i, left = 0;
        for(i =0 ; i < k ; i++){
            if((i+k)< nums.length-1) left++;
            int t = nums[(i+k)%nums.length];
            nums[(i+k)%nums.length] = nums[i];
            nums[i] = t;
        }

        Solution.printArr(nums);
        
        System.out.println("______________"+ left);

        if(left == k){
            Solution.invertFromItoJ(nums , left ,nums.length -1);
            Solution.printArr(nums);

            int size1 = k;
            int size2 = nums.length-2*k;

            Solution.invertFromItoJ(nums , left+size2 ,nums.length-1);
            Solution.invertFromItoJ(nums , left ,left+size2-1);
                        
            Solution.printArr(nums);
        }
        /*
        Solution.invertFromItoJ(nums , (k+i)%nums.length ,nums.length -left);
        Solution.printArr(nums);
        int first = k - left-2; 
        Solution.invertFromItoJ(nums , (k+i)%nums.length ,(k+i)%nums.length+first);
        Solution.printArr(nums);
        Solution.invertFromItoJ(nums , (k+i)%nums.length+first+1 , nums.length-1-left);
        Solution.printArr(nums);
        */
    }

    public static void printArr(int[] a){
        System.out.print("Array: ");
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println(" ");
        return;
    }

    public static void main(String[] args){
        int[] a = {1,2,3,4,5,6,7,8};
        int k = 5;

        int[] a2 = {1,2,3,4,5,6,7};
        int k2 = 1;
        
        Solution.rotate(a2, k2);
        System.out.println("Esecuzione testcase leet");
        //Solution.rotate(a, k);
        

    }
}




