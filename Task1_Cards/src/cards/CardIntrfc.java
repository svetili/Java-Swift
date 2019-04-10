package cards;

public class CardIntrfc {
	
	public static <T extends Enum<T>> void PrintEnum(Class<T> enumClass) {
		T[] arr = enumClass.getEnumConstants();
		for(T elem: arr) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		PrintEnum(CardSuit.class);
		PrintEnum(CardRank.class);
		
	}

}
