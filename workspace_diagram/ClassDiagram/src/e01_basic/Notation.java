package e01_basic;

public class Notation {
	public static int _static; 		// Static은 클래스다이어그램에서 밑줄로 표기
	private int _private;			// - 로 표기
	int _default;					// ~ 로 표기
	protected int _protected;		// # 로 표기
	public int _public;				// + 로 표기
	
	public Notation () {}
	
	private void _privateF() {}
	void _defaultF() {}
	protected void _protectedF() {}
	public void _publicF() {}
}
