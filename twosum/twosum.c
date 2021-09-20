#include <stdlib.h>
#include <stdio.h>

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* twoSum(int* numbers, int numbersSize, int target, int* returnSize){
    
    int* ret = (int*) calloc(2 ,sizeof(int));
    
    *returnSize = 2*sizeof(int);
    
    int* half = (int*) malloc(*returnSize);
    int* noHalf = (int*) malloc(*returnSize);
    
    
    int i;
    int found=0, foundHalf=0;
    
    if (abs(target) == 1){
        for(i = 0; i < numbersSize && found < 2; i++){
            if(numbers[i] == target || numbers[i] == 0){
                ret[found] = i+1;
                found++;
            }
        }
    }else{
        for(i = 0; (i < numbersSize) && (found < 2) && (foundHalf < 2) ;i++){

        if (target%2 == 0 && numbers[i] == target/2){
            half[foundHalf] = i+1;//cause 1-indexed
            foundHalf++; 
        } else if( numbers[i]+abs(numbers[i]-target) == target){
                noHalf[found] = i+1;
                found++;
        }
        
        }
    
        if(foundHalf == 2){
            ret[0] = half[0];
            ret[1] = half[1];
        }else{
            ret[0] = noHalf[0];
            ret[1] = noHalf[1];
        }
    
    }

    
    free(half);
    free(noHalf);
    
    return ret;
    
}

int main(){

    int a[] = {-1,0};
    int t = -1;
    int *n=(int*) malloc(2*sizeof(int));
    int* c =twoSum(a,4 , t,n  );
    printf("[%d , %d] \n", c[0], c[1]);
    
    free(n);
    free(c);

    return 0;
}