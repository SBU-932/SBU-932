package objects.blocks;

public class Pair<E, T> {
	public T first;
	public E second;

	public Pair() {
	}

	public Pair(T f, E s) {
		first = f;
		second = s;
	}

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		if (!(o instanceof Pair<?, ?>))
			return super.equals(o);

		Pair t = (Pair) o;
		if (!(t.first.getClass().equals(first.getClass()) && t.second
				.getClass().equals(second.getClass()))) {
			return false;
		}
		
		return first.equals(t.first) && second.equals(t.second);

	}
}
