package cars.utilities;

import java.util.Map;

public class CarResponse {

	private int page;
	private int pageSize;
	private int totalPageCount;
	private Map<String, String> wkda;

	public CarResponse(int page, int pageSize, int totalPageCount, Map<String, String> wkda) {
		this.page = page;
		this.pageSize = pageSize;
		this.totalPageCount = totalPageCount;
		this.wkda = wkda;
	}

	public Map<String, String> getWkda() {
		return wkda;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof CarResponse)) {
			return false;
		}

		CarResponse carResponse = (CarResponse) obj;
		return this.page == carResponse.page && this.pageSize == carResponse.pageSize
				&& this.totalPageCount == carResponse.totalPageCount && this.wkda.equals(carResponse.wkda);
	}

	@Override
	public int hashCode() {
		int sum = 0;
		for (String key : wkda.keySet()) {
			sum += key.length() * 31;
		}
		return sum * 31;
	}

	@Override
	public String toString() {
		return "wkda: " + wkda;
	}
}
