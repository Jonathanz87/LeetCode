public class WeightedQuickUnion{

	static public void main(String[] args){
		final int SIZE = 10;
		WeightedQuickUnion union = new WeightedQuickUnion(SIZE);

		union.union(1,7);
		union.union(2,8);
		union.union(3,9);
		union.union(3,2);

		for(int i = 0; i < SIZE; i++){
			for(int j = 0; j < SIZE; j++){
				System.out.println(i + " and " + j + " is "
				 + (union.connected(i,j) ? "" : "not ") + "connected.");
			}
		}

		for(int i = 0; i < SIZE; i++){
			System.out.println(i + " in group " + union.find(i)
			 + " has a size of " + union.getSizeOfUnion(i));
		}
	}



	int[] id;
	int[] size;

	public WeightedQuickUnion(int size){
		this.id		= new int[size];
		this.size	= new int[size];

		for(int i = 0; i < size; i++){
			this.id[i] 	= i;
			this.size[i] = 1;
		}
	}

	public int getSizeOfUnion(int x){
		return size[find(x)];
	}

	public boolean connected(int p, int q){
		return find(p) == find(q);
	}

	public int find(int x){
		if(x != id[x]){
			id[x] = find(id[x]);
		}
		return id[x];
	}

	public void union(int p, int q){
		int pIndex = find(p);
		int qIndex = find(q);
		if(pIndex == qIndex)
			return;

		if(size[pIndex] > size[qIndex]){
			size[pIndex] += size[qIndex];
			id[qIndex] = pIndex;
		}else{
			size[qIndex] += size[pIndex];
			id[pIndex] = qIndex;
		}
	}
}