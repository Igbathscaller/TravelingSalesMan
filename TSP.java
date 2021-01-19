import java.util.*;

public class TSP {
    public static String kthPermutation(int k, int size){
        string out = "";
        int nums[] = new int num[size];
        for(int i=0;i<size;i++)nums[i]=i;

    }

    public static void main(String[] args){
        //input parsing
        Scanner in = new Scanner(System.in);
        ArrayList<String> places = new ArrayList<String>();

        while(in.hasNextLine()){
            String line = in.nextLine();
            String[] words = line.split(" ");
            if(!places.contains(words[0]))places.add(words[0]);
            if(!places.contains(words[2]))places.add(words[2]);
        }

        int[][]dist = new int[places.size()][places.size()];
        for(int i=0;i<in.size();i++){
            String[] words = line.split(" ");
            //storing places as index,index = distance.
            dist[places.indexOf(words[0])][places.indexOf(words[2])] = words[5];
            dist[places.indexOf(words[2])][places.indexOf(words[0])] = words[5];
        }

        //process the cities
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<places.size();i++){
            int curr = 0;
            String perm = kthPermutation(i,places.size());
            for(int i=0;i<perm.size()-1;i++){
                curr += dist[(int)perm.charAt(i)][(int)perm.charAt(i+1)];
            }
            ans = Math.min(ans,curr);
        }

        //print solution
        System.out.println(ans);
    }
}
