class Solution {
     public static boolean isPalindrome(int x) {
       if(x < 0) return false;
        if(x / 10  == x) return true; //se x ha size 1
        int size = 1; 
        while( (int)(x %  Math.pow(10, size)) != x ){
            System.out.println( x %  Math.pow(10, size));
            size++;
        }
        int curr = 1, left , right;
        for(int i = 1; i <= size/2 ; i++ ){
            if(i == 1){
                left = (int) ((int) x/Math.pow(10, size -i))  ;
                right = (int)((int) x % Math.pow(10, i));
            }else{
                left = (int) ((int) x/Math.pow(10, size -i)) % 10  ;
                right = (int)((int) x % Math.pow(10, i)) /curr;
            }

            if(left != right ){
                return false;
            }
            curr = (int)Math.pow(10, i);
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(isPalindrome(2147483647));
    }


}

