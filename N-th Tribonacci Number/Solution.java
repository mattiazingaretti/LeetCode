class Solution {
    public int[] tribRec(int n){
        if(n <= 3) { int[] a = {2, 1, 1};return a; }
        else{
            int[] b = tribRec(n-1); //[ F(n-1), F(n-2) , F(n-3)]
            int[] ans = {b[0] + b[1]+ b[2], 0 ,0};
            return ans;
        }
    }
    
    public int tribonacci(int n) {
        return tribRec(n)[0];
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.tribonacci(4));
        System.out.println(s.tribonacci(5));    
        System.out.println(s.tribonacci(6));
        System.out.println(s.tribonacci(7));
    }
}