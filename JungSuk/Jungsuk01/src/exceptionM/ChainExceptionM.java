package exceptionM;

public class ChainExceptionM {
	public static void main(String[] args) throws MemoryException {
		throw new RuntimeException(new InstallExcetpion(null));
//		throw new MemoryException("에러");
	}

}

class InstallExcetpion extends Exception {
	public InstallExcetpion(String str) {
		super(str);
	}
}

class MemoryException extends Exception {
	public MemoryException(String strs) {
		super(strs);
	}
}
