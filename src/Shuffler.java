/**
 * This class provides a convenient way to test shuffling methods.
 */

/*
QUESTIONS:
1.
public static String flip(){
		if(Math.random() < 1/3.0){
			return "tails";
		}
		return "heads";
	}

2.
	public static boolean arePermutations(int[] arr1, int[] arr2){
		for(int num : arr1){
			boolean matched = false;
			for(int i = 0; i < arr1.length; i++){
				if(num == arr2[i]){
					matched = true;
				}
			}
			if(!matched){
				return false;
			}
		}
		return true;
	}

3.
3, 2, 2, 3
 */

public class Shuffler {

	/**
	 * The number of consecutive shuffle steps to be performed in each call
	 * to each sorting procedure.
	 */
	private static final int SHUFFLE_COUNT = 8;


	/**
	 * Tests shuffling methods.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive perfect shuffles:");
		int[] values1 = {0, 1, 2, 3, 4, 5};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			perfectShuffle(values1);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values1.length; k++) {
				System.out.print(" " + values1[k]);
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive efficient selection shuffles:");
		int[] values2 = {0, 1, 2, 3};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			selectionShuffle(values2);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values2.length; k++) {
				System.out.print(" " + values2[k]);
			}
			System.out.println();
		}
		System.out.println();
	}


	/**
	 * Apply a "perfect shuffle" to the argument.
	 * The perfect shuffle algorithm splits the deck in half, then interleaves
	 * the cards in one half with the cards in the other.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void perfectShuffle(int[] values) {
		int k = 0;
		int[] shuffled = new int[values.length];
		for(int j = 0; j < (values.length + 1) / 2; j++){
			shuffled[k] = values[j];
			k += 2;
		}
		k = 1;
		for(int j = (values.length + 1) / 2; j < values.length; j++){
			shuffled[k] = values[j];
			k += 2;
		}

		for(int i = 0; i < values.length; i++){
			values[i] = shuffled[i];
		}
	}

	/**
	 * Apply an "efficient selection shuffle" to the argument.
	 * The selection shuffle algorithm conceptually maintains two sequences
	 * of cards: the selected cards (initially empty) and the not-yet-selected
	 * cards (initially the entire deck). It repeatedly does the following until
	 * all cards have been selected: randomly remove a card from those not yet
	 * selected and add it to the selected cards.
	 * An efficient version of this algorithm makes use of arrays to avoid
	 * searching for an as-yet-unselected card.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void selectionShuffle(int[] values) {
		for(int k = values.length - 1; k > 0; k--){
			int temp = values[k];
			int random = (int) (Math.random() * (k + 1));
			values[k] = values[random];
			values[random] = temp;
		}
	}
}
