package interfaceM;

// 인터페이스는 다중상속 가능 extends A, B 가능 단, 인터페이스만 상속가능(추상메서드는 충돌해도 문제X)
public interface ProcInterface {
	public static final int PROC_INT = 0;
	final int DIAMOND = 3;
	int CLOVER = 1;
	// public static final이 생략되어 있다. 명시 안해도 자동으로 붙어있음.
	
	public abstract String getCardNumber();
	String getCardKind();
	// 마찬가지로 public abstract가 생략되어 있음.
	
}
