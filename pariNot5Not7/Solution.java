public class Solution {
    
    public static boolean divisibile(int k , int i){
        if(k == 5){
            String s = String.valueOf(i);
            return s.charAt(s.length()-1) == '5' || s.charAt(s.length()-1) == '0'  ;
        }else{
            int[] app = new int[2019];
            for(int j = 7; j < app.length; j+=7){
                app[j]++;
            }
            return app[i] == 1;
        }
    }

    public static int count(){
        int count =0;
        for(int i = 2; i <= 2020 ; i++ ){
            if(i %2 == 0 ){
                if(!divisibile(5,i) && !divisibile(7 , i)){
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args){
        System.out.println(count());
    } 

}