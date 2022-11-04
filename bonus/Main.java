import java.util.Scanner;
import java.util.Random;

class Main {

	public static void main (String args[]){
		int n;
		System.out.print("n = ");
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		n = scanner.nextInt();
		int[] array = new int[n];

		for (int i = 0; i < n; i ++){
			array[i] = random.nextInt(11);
			System.out.print(array[i] + " ");
		}

		int temp;

		for (int i = 0; i < n; i++){
			for (int j = 0; j < n-1; j ++){
				if (array[j] < array[j+1]){
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}

		System.out.print("\n");

		int[] bridge = new int[n];
		

		for (int i = 0; i < n; i ++){
			System.out.print(array[i] + " ");
		}

		System.out.print("\n");

		int a = n/4, b = n-a-1;

		bridge[a] = array[0];
		bridge[b] = array[1];
		int k = 2;
		int count = 1;
		while (k < n){

			if(a + count <= n && k < n){
				bridge[a + count] = array[k];
				k++;
			}
			if(b - count >= 0 && k < n){
				bridge[b - count] = array[k];
				k++;	
			}
			if(a - count >= 0 && k < n){
				bridge[a - count] = array[k];
				k++;
			}
			if(b + count <= n && k < n){
				bridge[b + count] = array[k];
				k++;
			} 	
			count++;
		}
		
		for (int i = 0; i < n; i++){
			System.out.print(bridge[i] + " ");
		}

		System.out.print("\n");

		int[][] display = new int[n][n];

		for (int i = 0; i < n; i ++){
			for (int j = 0; j < n; j++){
				display[i][j] = 0;
			}
		}

		for (int i = 0; i < n; i++){
			for (int j = 0; j < n; j++){
				if (bridge[i] > 0){
					display[i][n-j-1] = 1;
					bridge[i]--;
				}
			}
		}

		for (int i = 0; i < n; i++){
			for (int j = 0; j < n; j++){
				if(display[j][i] == 1){
					System.out.print('#');
				} else {
					System.out.print(' ');
				}
			}
			System.out.print("\n");
		}

		scanner.close();
	}
}