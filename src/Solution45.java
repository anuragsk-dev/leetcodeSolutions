import java.util.HashMap;

public class Solution45 {

    public int jump(int[] jumps) {

        if(jumps.length == 1){
            return 0;
        }

        int currStepRange = 0;
        HashMap<Integer, Integer> hmap = new HashMap<>();

        hmap.put(0,0);

        for(int i=0; i<jumps.length; i++){

            if(i > hmap.get(currStepRange)){
                currStepRange++;
            }

            int currMaxJump = i+jumps[i];

            if(currMaxJump >= jumps.length-1){
                return currStepRange+1;
            }

            if(!hmap.containsKey(currStepRange+1)){
                hmap.put(currStepRange+1, currMaxJump);
            }
            else{

                if(hmap.get(currStepRange+1) < currMaxJump){
                    hmap.put(currStepRange+1, currMaxJump);
                }
            }

        }

        return currStepRange;

    }

}
