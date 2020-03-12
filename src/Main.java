
public class Main {

	static CatInfo alice = new CatInfo("Alice", 87, 50, 88, 10);
	static CatInfo felix = new CatInfo("Felix", 85, 60, 87, 10);
	static CatInfo bob = new CatInfo("Bob", 88, 60, 89, 10);
	static CatInfo doughnut = new CatInfo("Doughnut", 85, 50, 86, 10);
	static CatInfo eleanor = new CatInfo("Eleanor", 85,45,86,10);
	static CatInfo hilda = new CatInfo("Hilda", 95,55,96,10);
	
	static CatTree myTree;

	public static void main(String[] args) {
		System.out.println("========================\n" + "| Welcome to Cat Cafe! |\n" + "========================\n");

		//test_1();
		test_2();
		//test_3();
		//test_full();
	}

	// Test: same monthsHired; bigger fur added first
	private static void test_1() {
		System.out.println(
				"========================\n" + "| Adding Felix then Doughnut |\n" + "========================\n");

		myTree = new CatTree(alice);
		myTree.addCat(felix);
		myTree.addCat(doughnut);
		printTree();
	};

	// Test: same monthsHired; smaller fur added first
	private static void test_2() {
		System.out.println(
				"========================\n" + "| Adding Doughnut then Felix |\n" + "========================\n");

		myTree = new CatTree(alice);
		myTree.addCat(doughnut);
		myTree.addCat(felix);

		printTree();

	};
	
	// Test: same monthsHired; added same monthsHired; smallest:medium:big
	private static void test_3() {
		System.out.println(
				"========================\n" + "| Adding Eleanor then Felix then Doughnut |\n" + "========================\n");

		myTree = new CatTree(alice);
		myTree.addCat(eleanor);
		myTree.addCat(felix);
		myTree.addCat(doughnut);
		printTree();

	};

	// Creates all the cats from the initial example of addcats
	private static void test_full() {
		System.out.println("\n========================\n" + "| Running the full test in order! |\n"
				+ "========================\n");

		myTree = new CatTree(alice);
		myTree.addCat(bob);
		myTree.addCat(felix);
		myTree.addCat(doughnut);
		myTree.addCat(eleanor);
		myTree.addCat(hilda);
		printTree();
	};

	public static void printTree() {
		System.out.println(myTree.root);
	}
}
