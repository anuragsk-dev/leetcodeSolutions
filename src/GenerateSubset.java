import java.util.ArrayList;
import java.util.List;

/***
 * code to generate subsets of String
 * ****/


public class GenerateSubset {
    public static void main(String[] args) {
        List<List<String>> ans = new ArrayList<>();
        List<String> current = new ArrayList<>();

        generateSubsetFunc("hello",0, ans, current);

        System.out.println("size of ans: "+ans.size());
        for(List<String> separatedWord : ans){
            System.out.print(" [");
            for(String word : separatedWord){
                System.out.print(word+" ");
            }
            System.out.print("] ");
        }

    }


    private static void generateSubsetFunc(String s, int index, List<List<String>> ans ,List<String> current){

        if(index >= s.length()){
            ans.add(new ArrayList<>(current));
            return;
        }

        // include index

        for(int i=index; i<s.length(); i++){

            String str = s.substring(index, i+1);
            current.add(str);
            generateSubsetFunc(s,i+1, ans, current);

            // include current index in all list
            current.remove(current.size()-1);
        }
        return;
    }

}
