import java.util.Iterator;

public class Main {

	static CatInfo alice = new CatInfo("Alice", 87, 50, 88, 10);
	static CatInfo felix = new CatInfo("Felix", 85, 60, 87, 10);
	static CatInfo bob = new CatInfo("Bob", 88, 60, 89, 10);
	static CatInfo doughnut = new CatInfo("Doughnut", 85, 50, 86, 10);
	static CatInfo eleanor = new CatInfo("Eleanor", 85, 45, 86, 10);
	static CatInfo hilda = new CatInfo("Hilda", 95, 55, 96, 10);
	static CatInfo gaia = new CatInfo("Gaia", 86, 55, 87, 10);
	static CatInfo coco = new CatInfo("Coco", 87, 55, 88, 10);
	static CatTree myTree;

	public static void main(String[] args) throws Exception {
		System.out.println("========================\n" + "| Welcome to Cat Cafe! |\n" + "========================");

		// System.out.println("========================\n" + "| Testing Adding |\n"
		// +"========================");
		// test_1();
		// test_2();
		// test_3();
		// test_4();
		// test_5();
		// test_13();

		// System.out.println("========================\n" + "| Testing Remove |\n" +
		// "========================");
		// test_6();
		// test_7();
		// test_8();
		// test_9();
		// test_10();

		// System.out.println("========================\n" + "| Testing mostSenior |\n"
		// + "========================");
		// test_11();
		// test_12();
		// test_14();

		// System.out.println("========================\n" + "| Testing fluffiest |\n" +
		// "========================");
		// test_15();
		// test_16();

		// System.out.println("========================\n" + "| Testing hiredFromMonths
		// |\n" + "========================");

		// test_17();
		// test_18();
		// test_19();
		// test_20();
		// test_21();
		// test_26();

		// System.out.println(
		// "========================\n" + "| Testing fluffliestFromMonth |\n" +
		// "========================");
		// test_22();
		// test_23();
		// test_24();
		// test_25();

		//System.out.println(
		//		"========================\n" + "| Testing Iterator |\n" + "========================");
		//test_27();

	}

	// Test: same monthsHired; bigger fur added first
	private static void test_1() {
		System.out.println(
				"========================\n" + "| Adding Felix then Doughnut |\n" + "========================");

		myTree = new CatTree(alice);
		myTree.addCat(felix);
		myTree.addCat(doughnut);
		printTree();
	};

	// Test: same monthsHired; smaller fur added first
	private static void test_2() {
		System.out.println(
				"========================\n" + "| Adding Doughnut then Felix |\n" + "========================");

		myTree = new CatTree(alice);
		myTree.addCat(doughnut);
		myTree.addCat(felix);

		printTree();

	};

	// Test: same monthsHired; added same monthsHired; smallest:medium:big fur
	private static void test_3() {
		System.out.println("========================\n" + "| Adding Eleanor then Felix then Doughnut |\n"
				+ "========================");

		myTree = new CatTree(alice);
		myTree.addCat(eleanor);
		myTree.addCat(felix);
		myTree.addCat(doughnut);
		printTree();

	};

	// Test: same monthsHired; added same monthsHired; same fur
	private static void test_4() {
		System.out.println("========================\n" + "| Adding Eleanor then testCat then Felix then Doughnut |\n"
				+ "========================");

		CatInfo testCat = new CatInfo("TestCat", eleanor.monthHired, eleanor.furThickness,
				eleanor.nextGroomingAppointment, eleanor.expectedGroomingCost);
		myTree = new CatTree(alice);
		myTree.addCat(eleanor);
		myTree.addCat(testCat);
		myTree.addCat(felix);
		myTree.addCat(doughnut);
		printTree();

	};

	// Test: all cats + a cat that has equal fur to another and a link
	private static void test_5() {
		System.out.println("========================\n"
				+ "| Running the full test in order and adding a cat of equal fur |\n" + "========================");

		CatInfo testCat = new CatInfo("TestCat", felix.monthHired, felix.furThickness, felix.nextGroomingAppointment,
				felix.expectedGroomingCost);

		myTree = new CatTree(alice);
		myTree.addCat(bob);
		myTree.addCat(felix);
		myTree.addCat(doughnut);
		myTree.addCat(eleanor);
		myTree.addCat(hilda);
		myTree.addCat(gaia);
		myTree.addCat(coco);
		myTree.addCat(testCat);

		printTree();
	};

	// Test: delete Coco from tree
	private static void test_6() {
		System.out.println("========================\n" + "| Running the full test and removing Coco |\n"
				+ "========================");

		myTree = new CatTree(alice);
		myTree.addCat(bob);
		myTree.addCat(felix);
		myTree.addCat(doughnut);
		myTree.addCat(eleanor);
		myTree.addCat(hilda);
		myTree.addCat(gaia);
		myTree.addCat(coco);

		myTree.removeCat(coco);
		printTree();
	};

	// Test: delete Coco and Alice from tree
	private static void test_7() {
		System.out.println("========================\n" + "| Running the full test and removing Coco and Alice |\n"
				+ "========================");

		myTree = new CatTree(alice);
		myTree.addCat(bob);
		myTree.addCat(felix);
		myTree.addCat(doughnut);
		myTree.addCat(eleanor);
		myTree.addCat(hilda);
		myTree.addCat(gaia);
		myTree.addCat(coco);

		myTree.removeCat(coco);
		myTree.removeCat(alice);
		printTree();
	};

	// Test: delete Coco and Alice from tree
	private static void test_8() {
		System.out.println("========================\n"
				+ "| Running the full test and removing Coco and Alice and Bob |\n" + "========================");

		myTree = new CatTree(alice);
		myTree.addCat(bob);
		myTree.addCat(felix);
		myTree.addCat(doughnut);
		myTree.addCat(eleanor);
		myTree.addCat(hilda);
		myTree.addCat(gaia);
		myTree.addCat(coco);

		myTree.removeCat(coco);
		myTree.removeCat(alice);
		myTree.removeCat(bob);
		printTree();
	};

	// Test: delete root
	private static void test_9() {
		System.out.println(
				"========================\n" + "| Adding Alice then removing Alice |\n" + "========================");

		myTree = new CatTree(alice);
		myTree.addCat(felix);
		myTree.removeCat(alice);
		printTree();
	};

	// Test: Test removeCat when Node to remove is at root
	private static void test_10() {
		System.out.println("========================\n" + "| Test 6 from MiniTester |\n" + "========================");
		CatInfo a = new CatInfo("A", 87, 50, 243, 40);
		CatInfo b = new CatInfo("B", 85, 60, 240, 30);
		CatInfo c = new CatInfo("C", 88, 70, 248, 10);

		CatTree t = new CatTree(a);
		t.addCat(b);

		t.removeCat(c); // nothing should change since c not in tree
		t.removeCat(a);
		printTree();
	}

	// Test: if mostSenior returns correctly in the full tree
	private static void test_11() throws Exception {
		System.out.println("========================\n"
				+ "| Running the full test and removing Coco and Alice and Bob |\n" + "========================");

		myTree = new CatTree(alice);
		myTree.addCat(bob);
		myTree.addCat(felix);
		myTree.addCat(doughnut);
		myTree.addCat(eleanor);
		myTree.addCat(hilda);
		myTree.addCat(gaia);
		myTree.addCat(coco);

		System.out.println("The test concluded: " + assertEquals(felix.monthHired, myTree.mostSenior()) + "\n");

		printTree();
	}

	// Test: if mostSenior returns correctly with one node
	private static void test_12() throws Exception {
		System.out.println("========================\n"
				+ "| Running the full test and removing Coco and Alice and Bob |\n" + "========================");

		myTree = new CatTree(alice);

		System.out.println("The test concluded: " + assertEquals(alice.monthHired, myTree.mostSenior()) + "\n");

		printTree();
	}

	// Test: all cats + a cat that is senior to all
	private static void test_13() {
		System.out.println("========================\n"
				+ "| Running the full test in order and adding a cat that is most senior |\n"
				+ "========================");

		CatInfo testCat = new CatInfo("TestCat", felix.monthHired - 1, felix.furThickness,
				felix.nextGroomingAppointment, felix.expectedGroomingCost);

		myTree = new CatTree(alice);
		myTree.addCat(bob);
		myTree.addCat(felix);
		myTree.addCat(doughnut);
		myTree.addCat(eleanor);
		myTree.addCat(hilda);
		myTree.addCat(gaia);
		myTree.addCat(coco);
		myTree.addCat(testCat);

		printTree();
	};

	// Test: if mostSenior returns correctly in the full tree when added a senior
	// that is most senior
	private static void test_14() throws Exception {
		System.out.println("========================\n"
				+ "| Running the full test and removing Coco and Alice and Bob |\n" + "========================");

		CatInfo testCat = new CatInfo("TestCat", felix.monthHired - 1, felix.furThickness,
				felix.nextGroomingAppointment, felix.expectedGroomingCost);

		myTree = new CatTree(alice);
		myTree.addCat(bob);
		myTree.addCat(felix);
		myTree.addCat(doughnut);
		myTree.addCat(eleanor);
		myTree.addCat(hilda);
		myTree.addCat(gaia);
		myTree.addCat(coco);
		myTree.addCat(testCat);

		System.out.println("The test concluded: " + assertEquals(testCat.monthHired, myTree.mostSenior()) + "\n");

		printTree();
	}

	// Test: if fluffiest returns correctly
	private static void test_15() throws Exception {
		System.out.println("========================\n"
				+ "| Running the full test and removing Coco and Alice and Bob |\n" + "========================");

		CatInfo testCat = new CatInfo("TestCat", felix.monthHired - 1, felix.furThickness + 1,
				felix.nextGroomingAppointment, felix.expectedGroomingCost);

		myTree = new CatTree(alice);
		myTree.addCat(bob);
		myTree.addCat(felix);
		myTree.addCat(doughnut);
		myTree.addCat(eleanor);
		myTree.addCat(hilda);
		myTree.addCat(gaia);
		myTree.addCat(coco);
		myTree.addCat(testCat);

		System.out.println("The test concluded: " + assertEquals(testCat.furThickness, myTree.fluffiest()) + "\n");

		printTree();
	}

	// Test: if fluffiest returns correctly
	private static void test_16() throws Exception {
		System.out.println("========================\n"
				+ "| Running the full test and removing Coco and Alice and Bob |\n" + "========================");

		CatInfo testCat = new CatInfo("TestCat", felix.monthHired - 1, felix.furThickness + 1,
				felix.nextGroomingAppointment, felix.expectedGroomingCost);

		myTree = new CatTree(alice);

		System.out.println("The test concluded: " + assertEquals(alice.furThickness, myTree.fluffiest()) + "\n");

		printTree();
	}

	// Test: hiredFromMonths; only root and not in interval
	private static void test_17() throws Exception {
		System.out.println("\n========================\n" + "| Adding root and checking in (1000,1000) |\n"
				+ "========================\n");

		myTree = new CatTree(alice);
		System.out.println("The test conluded: " + assertEquals(0, myTree.hiredFromMonths(1000, 1000)));

		printTree();
	}

	// Test: hiredFromMonths;
	private static void test_18() throws Exception {
		System.out.println("\n========================\n" + "| Adding root and checking in (80,90) |\n"
				+ "========================\n");
		int expected = 2;

		myTree = new CatTree(alice);
		myTree.addCat(bob);

		System.out.println("The test conluded: " + assertEquals(expected, myTree.hiredFromMonths(80, 90)));

		printTree();
	}

	// Test: hiredFromMonths;
	private static void test_19() throws Exception {
		System.out.println("\n========================\n" + "| Adding root and checking in (80,90) |\n"
				+ "========================\n");
		int expected = 2;

		myTree = new CatTree(alice);
		myTree.addCat(bob);
		myTree.addCat(hilda);

		System.out.println("The test conluded: " + assertEquals(expected, myTree.hiredFromMonths(80, 90)));

		printTree();
	}

	// Test: hiredFromMonths;
	private static void test_20() throws Exception {
		System.out.println("\n========================\n" + "| Adding root and checking in (80,95) |\n"
				+ "========================\n");
		int expected = 3;

		myTree = new CatTree(alice);
		myTree.addCat(bob);
		myTree.addCat(hilda);

		System.out.println("The test conluded: " + assertEquals(expected, myTree.hiredFromMonths(80, 95)));

		printTree();
	}

	// Test: hiredFromMonths; only root and not in interval
	private static void test_21() throws Exception {
		System.out.println("\n========================\n" + "| Adding root and checking in (0,100) |\n"
				+ "========================\n");
		int expected = 8;

		myTree = new CatTree(alice);
		myTree.addCat(bob);
		myTree.addCat(felix);
		myTree.addCat(doughnut);
		myTree.addCat(eleanor);
		myTree.addCat(hilda);
		myTree.addCat(gaia);
		myTree.addCat(coco);

		System.out.println("The test conluded: " + assertEquals(expected, myTree.hiredFromMonths(0, 100)));

		printTree();
	}

	// Test: FluffliestFromMonth; same branch
	private static void test_22() throws Exception {
		System.out.println("\n========================\n" + "| Checking for month 85; same branch |\n"
				+ "========================\n");

		myTree = new CatTree(felix);
		int expected = myTree.fluffiest();
		myTree.addCat(doughnut);
		myTree.addCat(eleanor);

		System.out.println("The test conluded: " + assertEquals(expected, myTree.fluffiestFromMonth(85).furThickness)
				+ " Fluffliest from month: " + myTree.fluffiestFromMonth(85).toString());

		printTree();
	}

	// Test: FluffliestFromMonth; one branch with null
	private static void test_23() throws Exception {
		System.out.println("\n========================\n" + "| Checking for month 87; same branch |\n"
				+ "========================\n");

		myTree = new CatTree(felix);
		myTree.addCat(doughnut);
		myTree.addCat(eleanor);

		System.out.println("The test conluded: " + (myTree.fluffiestFromMonth(87) == null));

		printTree();
	}

	// Test: FluffliestFromMonth; senior branch
	private static void test_24() throws Exception {
		System.out.println("\n========================\n" + "| Checking for month 85; senior branch |\n"
				+ "========================\n");

		myTree = new CatTree(alice);

		myTree.addCat(bob);
		myTree.addCat(felix);
		myTree.addCat(doughnut);
		myTree.addCat(eleanor);
		myTree.addCat(hilda);
		myTree.addCat(gaia);
		myTree.addCat(coco);

		int expected = myTree.root.senior.fluffiest();
		System.out.println("The test conluded: " + assertEquals(expected, myTree.fluffiestFromMonth(85).furThickness)
				+ " Fluffliest from month: " + myTree.fluffiestFromMonth(85).toString());
		printTree();
	}

	// Test: FluffliestFromMonth; junior branch
	private static void test_25() throws Exception {
		System.out.println("\n========================\n" + "| Checking for month 88; senior branch |\n"
				+ "========================\n");

		myTree = new CatTree(alice);

		myTree.addCat(bob);
		myTree.addCat(felix);
		myTree.addCat(doughnut);
		myTree.addCat(eleanor);
		myTree.addCat(hilda);
		myTree.addCat(gaia);
		myTree.addCat(coco);

		int expected = 60;
		System.out.println("The test conluded: " + assertEquals(expected, myTree.fluffiestFromMonth(88).furThickness)
				+ " Fluffliest from month: " + myTree.fluffiestFromMonth(88).toString());
		printTree();
	}

	// Test: hiredFromMonths; bad parameters
	private static void test_26() throws Exception {
		System.out.println("\n========================\n" + "| Adding root and checking in (1000,100) |\n"
				+ "========================\n");
		int expected = 0;

		myTree = new CatTree(alice);
		myTree.addCat(bob);
		myTree.addCat(felix);
		myTree.addCat(doughnut);
		myTree.addCat(eleanor);
		myTree.addCat(hilda);
		myTree.addCat(gaia);
		myTree.addCat(coco);

		System.out.println("The test conluded: " + assertEquals(expected, myTree.hiredFromMonths(1000, 100)));

		printTree();
	}

	// Test: Iterator
	private static void test_27() throws Exception {
		System.out.println(
				"\n========================\n" + "| Iterating through myTree |\n" + "========================\n");

		myTree = new CatTree(alice);
		myTree.addCat(bob);
		myTree.addCat(felix);
		myTree.addCat(doughnut);
		myTree.addCat(eleanor);
		myTree.addCat(hilda);
		myTree.addCat(gaia);
		myTree.addCat(coco);

		Iterator myIter = myTree.iterator();
		int counter = 0;
		CatInfo testArray[] = new CatInfo[] { eleanor, doughnut, felix, gaia, alice, coco, bob, hilda };

		while (myIter.hasNext()) {
			CatInfo myInfo = (CatInfo) myIter.next();
			if (!myInfo.equals(testArray[counter])) {
				throw new Exception("expected: " + testArray[counter].name + " and got " + myInfo.name);
			}
			System.out.print(myInfo + " : ");
			counter++;
		}

		System.out.println("\n");
		printTree();
	}

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
		myTree.addCat(gaia);
		myTree.addCat(coco);

		printTree();
	};

	public static void printTree() {
		System.out.println(myTree.root);
	}

	public static boolean assertEquals(int expected, int actual) throws Exception {
		if (expected == actual) {
			return true;
		}
		throw new Exception("expected: " + expected + " and got " + actual);
	}
}
