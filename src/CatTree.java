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
		
		//COMPLETED
		public CatNode removeCat(CatInfo c) {
			// ADD YOUR CODE HERE

			/*
			 * Strategy: Traverse tree until you find node with same CatInfo and then cut
			 * it's link and set them to the previous
			 */

			// if the root is null then the first cat added is the cat passed
			if (this.data.equals(c)) {
				CatNode myCat = null;
				if(this.same!=null) {
					//move to the root
					myCat = this.same;
					myCat.senior=this.senior;
					myCat.junior=this.junior;
					myCat.same=this.same.same;
				}else if(this.same==null && this.senior!=null) {
					myCat = this.senior;
					
					if(this.senior.junior!=null) {
						this.senior.junior.junior = this.junior;
					}
					
					myCat.junior = this.senior.junior;
				}else if(this.same==null && this.senior==null) {
					myCat = this.junior;
				}
				this.junior=null;
				this.senior=null;
				this.same=null;
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
				if(this.same!=null) {
					this.same = this.same.removeCat(c);
				}

			}

			return this; // DON'T FORGET TO MODIFY THE RETURN IF NEED BE
		}

		//COMPLETED
		public int mostSenior() {
			if(this.senior==null) {
				return this.data.monthHired;
			}
			return this.senior.mostSenior(); // CHANGE THIS
		}

		//COMPLETED
		public int fluffiest() {
			if(this.same==null && this.senior==null && this.junior==null) {
				return this.data.furThickness;
			}else {
				int senior = 0, junior = 0, same = 0;
				if(this.junior!=null) {
					junior=this.junior.fluffiest();
				}
				if(this.senior!=null) {
					senior=this.senior.fluffiest();
				}
				if(this.same!=null) {
					same=this.same.fluffiest();
				}
				return max(junior,senior,same, this.data.furThickness);
			}
		}
		
		//HELPER
		private int max(int junior, int senior, int same, int itself) {
			if(junior>senior && junior > same && junior > itself) {
				return junior;
			}else if(senior>same && senior>junior && senior>itself) {
				return senior;
			}else if(same>senior && same>junior && same>itself){
				return same;
			}else {
				return itself;
			}
		}

		public int hiredFromMonths(int monthMin, int monthMax) {
			// ADD YOUR CODE HERE
			return -1; // DON'T FORGET TO MODIFY THE RETURN IF NEED BE

		}

		public CatInfo fluffiestFromMonth(int month) {
			// ADD YOUR CODE HERE
			return null; // DON'T FORGET TO MODIFY THE RETURN IF NEED BE
		}

		public int[] costPlanning(int nbMonths) {
			// ADD YOUR CODE HERE
			return null; // DON'T FORGET TO MODIFY THE RETURN IF NEED BE
		}

	}

	private class CatTreeIterator implements Iterator<CatInfo> {
		// HERE YOU CAN ADD THE FIELDS YOU NEED

		public CatTreeIterator() {
			// YOUR CODE GOES HERE
		}

		public CatInfo next() {
			// YOUR CODE GOES HERE
			return null; // DON'T FORGET TO MODIFY THE RETURN IF NEED BE
		}

		public boolean hasNext() {
			// YOUR CODE GOES HERE
			return false; // DON'T FORGET TO MODIFY THE RETURN IF NEED BE
		}
	}

}
