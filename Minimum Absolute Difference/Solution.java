import java.util.LinkedList;
import java.util.List;

class Solution {
    
    public static void quickSortInPlace(int[] S , int a , int b){
        if( a >= b) return;
        int left = a, right = b-1, pivot = S[b], temp;
        while(left <= right){
            while(left <= right && S[left] < pivot) left++;
            while(left <= right && S[right] > pivot) right--;
            if(left <= right){
                temp = S[left];
                S[left] = S[right];
                S[right] = temp;
                left++;
                right--;
            }
        }
        temp = S[left];
        S[left] = S[b];
        S[b]= temp;
        quickSortInPlace(S, a, left-1);
        quickSortInPlace(S, left +1, b);
        return;
    }
    
    
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        //Sort the array
        quickSortInPlace(arr, 0 , arr.length-1);
        int minGap = Integer.MAX_VALUE;
        List<List<Integer>> ris = new LinkedList<>();
        
        for(int i =0 ; i < arr.length-1 ; i++){
            int diff = Math.abs(arr[i]- arr[i+1]);
            if( diff < minGap){
                minGap = diff;
            }    
        }
        
        for(int i = 0; i < arr.length -1 ; i++){
            int diff = Math.abs(arr[i] - arr[i+1]);
            LinkedList<Integer> item = new LinkedList<>();
            if(diff == minGap){
                item.addFirst(arr[i]);
                item.addFirst(arr[i+1]);
                ris.add(item);  
            }    
        }
        
        return ris;
    }


    public static void main(String[] args ){
        int[] a = {4, 62, 1 , 0 };
        quickSortInPlace(a, 0 , a.length-1);
        for(int i = 0; i < a.length; i++)
            System.out.println(a[i]);
    
    }

}


