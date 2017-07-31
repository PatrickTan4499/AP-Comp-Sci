
public class LotsOfCopies {
	public static void main(String[] args){
		int num = 7;
		String strMain ="APCS";
		int[]arrMain= {1, 2, 3, 4,5};
		changeMe(num, strMain, arrMain);
		int a = 2;
		int b = a;
		a = 3;
		System.out.println(a);
		System.out.println(b);
	}
	public static void changeMe(int x, String str, int[] arr){
		x = 10;
		str = "nunu";
		for(int i= 0; i < arr.length; i++){
			arr[i] = i+4;
		}
		System.out.println(x);
		System.out.println(str);
		System.out.println(arr);
	}
}
