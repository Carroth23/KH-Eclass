package anno;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface TestInfo{
	int count() default 1;
	String testedBy();
}

@TestInfo(testedBy = "하이", count = 10)
class TestGo{
	Class<TestGo> cls = TestGo.class;
	TestInfo anno = cls.getAnnotation(TestInfo.class);
}

class Parent{
	void parentMethod() {
		
	}
}

@TestInfo(testedBy = "하이", count = 10)
public class OverAnno extends Parent{
	public static void main(String[] args) {
		System.out.println("하이");
		Class<TestGo> cls = TestGo.class;
		TestInfo anno = cls.getAnnotation(TestInfo.class);
		anno.testedBy();
		System.out.println(anno.testedBy());
	}
	@Override
	void parentMethod() {}
	
	// 오버라이딩할건데 실수로 잘못적음
	void parentmethod() {}
}

//@Deprecated // 옛날거니까 되도록 쓰지말라는 어노테이션
