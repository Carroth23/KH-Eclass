
public class Exam_01 { // Startup ��� Exam_01

	public static/*��ü����*/ int/*����Ÿ��*/ plus/*�޼����*/(int num1/*�Ű�����*/, int num2/*�Ű�����*/){
	// �Ű����� : (Arguments)
	// �Ű������� ������ ���������� ����
		int result/*���� ����*/ = num1 + num2;
		return result; // ���ް��� result�� ����� ��(�Ⱦ��� �ٷ� ���ϵ� ����). ��ȯ���� �ڵ�����ȯ ����.
		// 1. �޼��带 �����Ѵ�.
		// 2. ���� caller ���� �����Ѵ�.
	}
	//�޼��� �ϼ�
	
	//������ �ּ�����
//	public static int plus(int num1, int num2) { /*�޼��� ���Ǻ�*/
//		int result = num1 + num2;
//		return result;
//	}
	
	
//	double random(/*�Ķ���Ͱ� ���⶧���� �Ű������� ����*/){
//		// ���� ������ ����� �۾�...
//		return ����;
//	}
	
	
	public static void main(String[] args) { // main �����
		/*�޼��� ȣ���*/plus(10, 5); // �Ұ�ȣ�� ġ�� �޸��� ���� �����ϴ°� �޼��忡�� ���� �����ϴ� ���
		// �޼��带 �θ��� ó���� ���� �����ϴ� (10, 5)���� �μ�/����(parameter, argument)��� �θ���.
		// Parameter : �޼��带 call �ϸ鼭 �����ϴ� ��
		
		int result = plus(10, 5); // �̰͵� ���� �ᱹ int 15�̱� ����
		
//		plus() - ����� �����ϰ� Ű���� �ڿ�()�پ������� ��� �޼��� ȣ���̴�.
		System.out.println(10 + 5);
		
		
		Math.random();// ����Ÿ���� void�� �޼��� ()�� �Ķ���Ͱ� ����
	}

}
