import java.util.HashMap;

class Solution45 {
    public int jump(int[] nums) {

        if (nums.length == 1) return 0;

        int jumps = 0;
        int currEnd = 0;     // hmap[currStepRange]
        int farthest = 0;   // hmap[currStepRange + 1]

        for (int i = 0; i < nums.length - 1; i++) {

            farthest = Math.max(farthest, i + nums[i]);

            if (i == currEnd) {     // finished current jump range
                jumps++;
                currEnd = farthest;
            }
        }
        return jumps;
    }
}
