
public class List {

		private Archive first;
		private Archive last;
		private int large;

		public List() {
		}
		
		public void addLast(Archive node) {
			if (first == null && last==null) {
				first = node;
				last = node;
			}else {
				last.setNext(node);
				node.setPrev(first);
				last = node;
			}
			List.this.setLarge(List.this.getLarge()+1);

		}

		public int getLarge() {
			return large;
		}
		
		public void setLarge(int large) {
			this.large = large;
		}

		


}
