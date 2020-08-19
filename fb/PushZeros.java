class PushZeros {
  static void pushZeros(int[] input) {
			int non_zeros = 0;
			for (int i = 0; i < input.length; i++) {
					if (input[i] != 0) {
							input[non_zeros] = input[i];
							non_zeros++;
					}
			}
			for (int i = non_zeros; i < input.length; i++) {
					input[i] = 0;
			}
	}

	static void printArray(int[] input) {
			System.out.print("[ ");
			for (int n : input) {
					System.out.print(n + " ");
			}
			System.out.println("]");
  }
		
  public static void main(String[] args) {
			int[] arr = { 1, 2, 0, 3, 0, 4 , 0, 0, 0, 5, 6, 0, 7, 0};
			pushZeros(arr);
			printArray(arr);
  }
}
