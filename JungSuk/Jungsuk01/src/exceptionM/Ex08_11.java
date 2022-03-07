package exceptionM;

public class Ex08_11 {
	public static void main(String[] args) {
		try {
			startInstall(); // 예외 발생 예상
			copyFiles();
		} catch (SpaceException e) {
			System.out.println("에러메세지 : " + e.getMessage());
			e.printStackTrace();
			System.out.println("공간을 확보해주세요.");
		} catch (MemoryException e) {
			System.out.println("에러메세지 : " + e.getMessage());
			e.printStackTrace();
//			System.gc(); 가비지컬렉터 실행해서 메모리 늘려주는 코드
			System.out.println("다시 설치를 시도하세여.");
		} finally { // 임시파일 삭제(무조건 실행)
			deleteTemplate();
		}
	}

	static void startInstall() throws SpaceException, MemoryException {
		if (!enoughSpace()) {
			throw new SpaceException("설치할 공간이 부족합니다.");
		}
		if (!enoughMemory()) {
			throw new MemoryException("메모리가 부족합니다.");
		}
	}

	static void copyFiles() {
		System.out.println("파일 복사");
	}

	static void deleteTemplate() {
		System.out.println("임시 파일 삭제");
	}

	static boolean enoughSpace() {
		// 성치공간 확인 코드
		return false;
	}

	static boolean enoughMemory() {
		// 설치 메모리 확인 코드
		return true;
	}
}

// 내가 만든 예외
class SpaceException extends Exception {
	SpaceException(String msg) {
		super(msg);
	}
}

class MemoryException extends RuntimeException {
	MemoryException(String msg) {
		super(msg);
	}
}
