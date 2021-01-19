import java.util.*;

public class TSP{

	public static int min_distance = Integer.MAX_VALUE;
	public static final int MAX_N = 10;
	public static int[][] adjacency_matrix = new int[MAX_N][MAX_N];
		
	public static int find_path_length(int[] perm){
		return 0;
	}

	public static void process_kth_permutation(int[] perm){
		
	}
	
	public static int factorial(int n){
		if(n==0) 
			return 1;
		return n*factorial(n-1);
	}

	public static int[] find_kth_permutation(int n, int k){
		int[] perm = new int[n];
		for(int i=0; i<n; i++){
			boolean[] visited = new boolean[n];
			int count = k/factorial(n-i);
			
			//find 0-indexed count-th number that hasn't been visited
			int curr = -1;
			for(int j=0; j<n; i++){
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
			k -= k/factorial(n-i);
		}
		return perm;
	}
  
	public static void main(String[] args){
		for(int i=0; i<6; i++){
			System.out.println(Arrays.toString(find_kth_permutation(3,i)));
		}
	}
}
