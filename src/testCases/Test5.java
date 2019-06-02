package testCases;

public class Test5 {

	public static void main(String[] args) {
		int num=100;
		valueValidator(num);
	}

	public static void valueValidator(int number){
		for(int i=1;i<number;i++){
			if(i%3==0 && i%5==0){
				System.out.println(i);
				System.out.println("Resolver");
			}else if(i%3==0){
				System.out.println(i);
				System.out.println("MThree");
			}else if(i%5==0){
				System.out.println(i);
				System.out.println("MFive");
			}
		}
	}
}
