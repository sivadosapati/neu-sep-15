package lecture7;

class Glass implements Comparable {
	int volumeOfWater;

	Glass(int v) {
		this.volumeOfWater = v;
	}

	@Override
	public boolean equals(Object o) {
		Glass g = (Glass) o;
		if (volumeOfWater == g.volumeOfWater) {
			return true;
		}
		return false;

	}

	@Override
	public int hashCode() {
		return volumeOfWater;
	}

	@Override
	public int compareTo(Object o) {
		Glass g = (Glass) o;
		if (this.volumeOfWater > g.volumeOfWater) {
			return +1;
		}
		if (this.volumeOfWater == g.volumeOfWater) {
			return 0;
		}
		return -1;
	}
}