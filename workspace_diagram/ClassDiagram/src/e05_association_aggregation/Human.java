package e05_association_aggregation;

public class Human {
	private Watch watch; // 여기에 new Watch() 로 담게되면 어쏘시네이션 관계이지만 컴포지션임. ?뭔말이지(아마 라이프사이클관련있을듯)
	private Glasses glasses;
	
	public Human(Watch watch, Glasses glasses) {
		this.watch = watch;
		this.glasses = glasses;
	}
	
	public void setWatch(Watch watch) { // 위에서 new로 만들면 라이프사이클을 같이 가져가지만 이렇게 만들면 워치인스턴스와 휴먼은 라이프사이클이 다르다.
		this.watch = watch;
	}
}
