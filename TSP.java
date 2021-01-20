import java.util.*;

public class TSP {

	public static int min_distance = Integer.MAX_VALUE;
	public static int MAX_N = 10;
	public static int[][] adjacency_matrix = new int[MAX_N][MAX_N];

	public static int find_path_length(int[] perm){
			int current = 0;
            for(int i=0; i<perm.length - 1; i++){
                current += adjacency_matrix[perm[i]][perm[i+1]];
            }
			return current;
	}

	public static void process_kth_permutation(int n, int k){
			int[] perm = find_kth_permutation(n,k);
			min_distance = Math.min(min_distance, find_path_length(perm));
	}

	public static int factorial(int n){
		if(n==0)
			return 1;
		return n*factorial(n-1);
	}

	public static int[] find_kth_permutation(int n, int k){
		//kth permutation of n numbers
		int[] perm = new int[n];
		boolean[] visited = new boolean[n];

		for(int i=0; i<n; i++){
			int count = k/factorial(n-i-1);
			//find 0-indexed count-th number that hasn't been visited
			int curr = -1;
			for(int j=0; j<n; j++){
				if(!visited[j]){
					--count;
				}
				if(count == -1){
					curr = j;
					visited[j] = true;
					break;
				}
			}
			perm[i] = curr;
			k %= factorial(n-i-1);
		}
		return perm;
	}

    public static void main(String[] args){
        //input parsing
		Scanner s = new Scanner(System.in);
        ArrayList<String> places = new ArrayList<String>();
        while (s.hasNext()) {
            String line = s.nextLine();
            Scanner l = new Scanner(line);
            String start = l.next();
            if (!places.contains(start)) places.add(start);
            l.next();
            String end = l.next();
            if (!places.contains(end)) places.add(end);
            l.next();
            int dist = l.nextInt();
            adjacency_matrix[places.indexOf(start)][places.indexOf(end)] = dist;
            adjacency_matrix[places.indexOf(end)][places.indexOf(start)] = dist;
		}

		int num_cities = places.size();
		for(int i=0; i<factorial(num_cities); i++){
			process_kth_permutation(num_cities, i);
		}

        //print solution
        System.out.println(min_distance);

		s.close();
    }
}
