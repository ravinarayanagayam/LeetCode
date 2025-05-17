import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println("null");
        Integer[] nums = { -1, 2, 4, 1, 2, -1, 1 };
        List<Integer> nIntegers = Arrays.asList(nums);
        System.out.println(reduce(nIntegers));
    }

    public static Integer reduce(List<Integer> data) {
        int maxIndex = 0;
        Long maxValue = Long.MIN_VALUE;

        for(int i=1;i<data.size()-1;i++){
            long x = data.get(i-1) + data.get(i+1);
            if(x > data.get(i-1) && )
        }

        return 0;
    }
}
