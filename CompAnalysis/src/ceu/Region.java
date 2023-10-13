package ceu;

import java.util.List;

public class Region {
	private List<String> NCR;
	private List<String> CAR;
	private List<String> RegionI;
	
	public Region() {	
	}

	public List<String> getNCR() {
		return NCR;
	}

	public void setNCR(List<String> nCR) {
		NCR = nCR;
	}

	public List<String> getCAR() {
		return CAR;
	}

	public void setCAR(List<String> cAR) {
		CAR = cAR;
	}

	public List<String> getRegionI() {
		return RegionI;
	}

	public void setRegionI(List<String> regionI) {
		RegionI = regionI;
	}

	@Override
	public String toString() {
		return "Region [NCR=" + NCR + ", CAR=" + CAR + ", RegionI=" + RegionI + "]";
	}
}
