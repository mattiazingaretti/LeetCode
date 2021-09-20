public class ShiftLetters{

    public static String shiftingLetters(String s, int[] shifts) {
        long total = 0;
        char[] ret = new char[shifts.length] ;
        for(int i = shifts.length-1; i >= 0 ; i--){
            total += shifts[i];
            long val = (total)%26 ;
            if( val != 0)
                ret[i]  = (char)((97 + (s.charAt(i) -97+val)));
            else
                ret[i] = s.charAt(i);
            System.out.println("val: "+val +" total : "+total+" ret[i]: "+ret[i] +" string[i]: "+s.charAt(i));
        }
        System.out.println("---------------------------------");
        String result = new String(ret);
        System.out.println(result);
        return result;
    }

    public static void main(String args[]){


        String s = new String("ruu");
        int[] sh = {26,9,17};

        s = ShiftLetters.shiftingLetters(s, sh);

    }
}