import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CatTree implements Iterable<CatInfo> {
	public CatNode root;

	public CatTree(CatInfo c) {
		this.root = new CatNode(c);
	}

	private CatTree(CatNode c) {
		this.root = c;
	}

	public void addCat(CatInfo c) {
		this.root = root.addCat(new CatNode(c));
	}

	public void removeCat(CatInfo c) {
		this.root = root.removeCat(c);
	}

	public int mostSenior() {
		return root.mostSenior();
	}

	public int fluffiest() {
		return root.fluffiest();
	}

	public CatInfo fluffiestFromMonth(int month) {
		return root.fluffiestFromMonth(month);
	}

	public int hiredFromMonths(int monthMin, int monthMax) {
		return root.hiredFromMonths(monthMin, monthMax);
	}

	public int[] costPlanning(int nbMonths) {
		return root.costPlanning(nbMonths);
	}

	public Iterator<CatInfo> iterator() {
		return new CatTreeIterator();
	}

	class CatNode {

		CatInfo data;
		CatNode senior;
		CatNode same;
		CatNode junior;

		public CatNode(CatInfo data) {
			this.data = data;
			this.senior = null;
			this.same = null;
			this.junior = null;
		}

		public String toString() {
			String result = this.data.toString() + "\n";
			if (this.senior != null) {
				result += "more senior " + this.data.toString() + " :\n";
				result += this.senior.toString();
			}
			if (this.same != null) {
				result += "same seniority " + this.data.toString() + " :\n";
				result += this.same.toString();
			}
			if (this.junior != null) {
				result += "more junior " + this.data.toString() + " :\n";
				result += this.junior.toString();
			}
			return result;
		}

		// COMPLETED
		public CatNode addCat(CatNode c) {
			// ADD YOUR CODE HERE

			/*
			 * Strategy: iterate, add by comparing months (if months ==, compare fur) Edge
			 * Cases: The root is null; fur and months are equal
			 * 
			 * 
			 * More senior Less senior - _________________________ +
			 */

			// if the root is null then the first cat added is the cat passed
			if (this == null)
				return c;

			if (c.data.monthHired > this.data.monthHired) {
				// we recurse through root.junior
				// if junior is null then set it
				if (this.junior != null) {
					this.junior = this.junior.addCat(c);
				} else {
					this.junior = c;
				}
			} else if (c.data.monthHired < this.data.monthHired) {
				// we recurse through root.senior
				// if senior is null then set it
				if (this.senior != null) {
					this.senior = this.senior.addCat(c);
				} else {
					this.senior = c;
				}
			} else if (c.data.monthHired == this.data.monthHired) {
				// recurse through root.same
				// Edge case: when the fur thickness is the same
				if (c.data.furThickness > this.data.furThickness) {

					c.same = this;
					// also switch senior and junior!
					c.junior = this.junior;
					c.senior = this.senior;

					this.junior = null;
					this.senior = null;
					return c;

				} else if (c.data.furThickness == this.data.furThickness || this.same == null) {

					c.same = this.same;
					this.same = c;

				} else if (c.data.furThickness < this.data.furThickness) {

					this.same = this.same.addCat(c);

				}

			}
			return this; // DON'T FORGET TO MODIFY THE RETURN IF NEED BE
		}

		// COMPLETED
		public CatNode removeCat(CatInfo c) {
			// ADD YOUR CODE HERE

			/*
			 * Strategy: Traverse tree until you find node with same CatInfo and then cut
			 * it's link and set them to the previous
			 */

			// if the root is null then the first cat added is the cat passed
			if (this.data.equals(c)) {
				CatNode myCat = null;
				if (this.same != null) {
					// move to the root
					myCat = this.same;
					myCat.senior = this.senior;
					myCat.junior = this.junior;
					myCat.same = this.same.same;
				} else if (this.same == null && this.senior != null) {
					myCat = this.senior;

					if (this.senior.junior != null) {
						this.senior.junior.junior = this.junior;
					}

					myCat.junior = this.senior.junior;
				} else if (this.same == null && this.senior == null) {
					myCat = this.junior;
				}
				this.junior = null;
				this.senior = null;
				this.same = null;
				return myCat;
			}

			if (c.monthHired > this.data.monthHired) {
				// we recurse through root.junior
				// if junior is null then set it
				if (this.junior != null) {
					this.junior = this.junior.removeCat(c);
				}
			} else if (c.monthHired < this.data.monthHired) {
				// we recurse through root.senior
				// if senior is null then set it
				if (this.senior != null) {
					this.senior = this.senior.removeCat(c);
				}
			} else if (c.monthHired == this.data.monthHired) {
				// recurse through root.same
				// Edge case: when the fur thickness is the same
				if (this.same != null) {
					this.same = this.same.removeCat(c);
				}

			}

			return this; // DON'T FORGET TO MODIFY THE RETURN IF NEED BE
		}

		// COMPLETED
		public int mostSenior() {
			if (this.senior == null) {
				return this.data.monthHired;
			}
			return this.senior.mostSenior(); // CHANGE THIS
		}

		// COMPLETED
		public int fluffiest() {
			if (this.same == null && this.senior == null && this.junior == null) {
				return this.data.furThickness;
			} else {
				int senior = 0, junior = 0, same = 0;
				if (this.junior != null) {
					junior = this.junior.fluffiest();
				}
				if (this.senior != null) {
					senior = this.senior.fluffiest();
				}
				if (this.same != null) {
					same = this.same.fluffiest();
				}
				return max(junior, senior, same, this.data.furThickness);
			}
		}

		// HELPER
		private int max(int junior, int senior, int same, int itself) {
			if (junior > senior && junior > same && junior > itself) {
				return junior;
			} else if (senior > same && senior > junior && senior > itself) {
				return senior;
			} else if (same > senior && same > junior && same > itself) {
				return same;
			} else {
				return itself;
			}
		}

		// COMPLETED
		public int hiredFromMonths(int monthMin, int monthMax) {

			int nbJunior = 0, nbSenior = 0, nbSame = 0;

			if (monthMin > monthMax)
				return 0;

			if (junior != null) {
				nbJunior = junior.hiredFromMonths(monthMin, monthMax);
			}

			if (senior != null) {
				nbSenior = senior.hiredFromMonths(monthMin, monthMax);
			}

			if (same != null) {
				nbSame = same.hiredFromMonths(monthMin, monthMax);
			}

			if (data.monthHired >= monthMin && data.monthHired <= monthMax) {
				return 1 + nbJunior + nbSenior + nbSame;
			}

			return nbJunior + nbSenior + nbSame;
			// ADD YOUR CODE HERE

		}

		// COMPLETED
		public CatInfo fluffiestFromMonth(int month) {
			CatInfo juniorInfo = null, seniorInfo = null, sameInfo = null;

			if (this.junior != null) {
				juniorInfo = this.junior.fluffiestFromMonth(month);
				if (juniorInfo != null && juniorInfo.furThickness > data.furThickness) {
					return juniorInfo;
				}
			}

			if (this.senior != null) {
				seniorInfo = this.senior.fluffiestFromMonth(month);
				if (seniorInfo != null && seniorInfo.furThickness > data.furThickness) {
					return seniorInfo;
				}
			}

			if (this.same != null) {
				sameInfo = this.same.fluffiestFromMonth(month);
				if (sameInfo != null && sameInfo.furThickness > data.furThickness) {
					return sameInfo;
				}
			}

			if (this.data.monthHired == month) {
				return this.data;
			}

			return null;

		}

		public int[] costPlanning(int nbMonths) {
			// ADD YOUR CODE HERE
			return null; // DON'T FORGET TO MODIFY THE RETURN IF NEED BE
		}

	}

	private class CatTreeIterator implements Iterator<CatInfo> {
		// HERE YOU CAN ADD THE FIELDS YOU NEED
		ArrayList<CatNode> myList = new ArrayList<CatNode>();
		
		//COMPLETE
		public CatTreeIterator() {
			// YOUR CODE GOES HERE
			// The most senior and most fluffy is the given by taken the catInfo from the
			// fluffiest Cat in the mostSenior month
			pushCat(root);
		}
		
		//COMPLETE
		private void pushCat(CatNode node) {
			// adds the node to 0: first in first out; last node is the root
				if (!myList.contains(node) && node != null) {
					myList.add(0, node);
					pushCat(node.same);
					pushCat(node.senior);
			}
		}
		
		//COMPLETE
		public CatInfo next() {
			CatNode node = myList.remove(0);
			pushCat(node.junior);
			return node.data; // DON'T FORGET TO MODIFY THE RETURN IF NEED BE
		}
		
		//COMPLETE
		public boolean hasNext() {
			if (!myList.isEmpty()) {
				return true;
			}
			return false; // DON'T FORGET TO MODIFY THE RETURN IF NEED BE
		}
	}

}
