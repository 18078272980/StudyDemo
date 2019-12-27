import producer_comsumer.Comsumer;
import producer_comsumer.Producer;


public class Test /*extends DemoTestC*/{
	private static final int MAX_LEN = 500;
	String test = "TEST D";
	public Test() {
		//System.out.println("Test:" + "test = " + test);
	}
	public int i = 0;
	public void set() {
		i++;
	}
	public static void main(String[] args) {
		//int i = 0;
		final Test test = new Test();
		SingleInstanceDemo singleInstance = SingleInstanceDemo.getLazyInstance();
		Thread thread1 = new Thread(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				//i++;
				int i=0;
				while(i<10) {
					test.set();
					i++;
				}
			}
			
		});
		Thread thread2 = new Thread(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				int i=0;
				while(i<10) {
					//System.out.println("Thread 2");
					test.set();
					i++;
				}
			}
		});
		
		Thread thread3 = new Thread(new Runnable(){

			public void run() {
				// TODO Auto-generated method stub
				int i=0;
				Test test = new Test();
				while(i<10) {
					test.set();
					i++;
				}
			}
		});
		//thread1.start();
		//thread2.start();
		//thread3.start();
		//System.out.println("i = " + test.i);
		
		//生产者
		/*int j=0,k = 0;
		while(j<11){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			new Thread(new Producer()).start();
			j++;
		}*/
		//消费者
		/*while(k<11) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			new Thread(new Comsumer()).start();
			k++;
		}*/
		
		/*String str = "1-2+3";
		 String[] tem = str.split("-|\\+|\\*|÷");
		for(int i=0;i<tem.length;i++) {
			//System.out.println(tem[i]);
			 * 
		}*/
		//Integer i = new Integer(10);
		//add3(i);
		//System.out.println("Test D" + ":TEST = " + test);
		//new Test();
		//DemoTestC testc = new DemoTestC(2);
		//DemoTestC(2);
		//ThreadLocal threadLocal = new ThreadLocal();
		//final ThreadLocal<String> RESOURCE_1 = new ThreadLocal<String>();

		int[] arr = {-1,2,3,-2,5,-3,-5};
		sort(arr,arr.length);
		//int[] resultArr = 
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i] + " ");
			
		}
		
	}
	/**
	 * 数组中，将负数放在左边，正数放右边且相对位置不变。如：
	 *-1,2,3，-2,5，-3，-5排序后变为-1,-2,-3,-5,2,3,5
	 * @param arr
	 * @param length
	 */
	
	public static void sort(int[] arr, int length){
	    int i, j, k, tmp;
	    for(i = 0, j = 0; i < length; i++)
	    {
	        if (arr[i] < 0)
	        {
	            tmp = arr[i];
	            for(k = i; k > j; k--){
	            	arr[k] = arr[k - 1];
	            }
	            arr[j++] = tmp;
	            //j++;
	        }
	    }
	    
	    //return arr;
	}
	
	public static void arrSort(int[] arr,int length) {
		int i,j,k,tmp;
		for(i=0,j=0;i<length;i++) {
			if(arr[i] < 0) {
				tmp = arr[i];
				for(k = i;k < j;k--) {
					arr[k] = arr[k - 1];
				}
				arr[j] = tmp;
				j++;
			}
		}
	}
	
	public static void add3(Integer i) {
		int val = i.intValue();
		val += 3;
		i = new Integer(val);
	}
	
	
	
	public static String operatorProcess(String str) {
        int weightPlus = 0, topOp = 0,
                topNum = 0, flag = 1, weightTemp = 0;

        double number[] = new double[MAX_LEN];//将数字保存在栈中
        char operator[] = new char[MAX_LEN];//保存运算符
        int weight[] = new int[MAX_LEN];//保存运算符优先级
        String op;

        String temp = str;
        String[] tem = temp.split("-|\\+|\\*|÷");
        for(int i=0;i<tem.length;i++) {
            System.out.println(tem[i]);
            number[topNum++] = Double.valueOf(tem[i]).doubleValue();
        }
        
        for (int i = 0; i < temp.length(); i++) {
            char ch = temp.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '÷') {
                switch (ch) {
                    case '-':
                    case '+':
                        weightTemp = 1 + weightPlus;
                        break;
                    case '*':
                    case '÷':
                        weightTemp = 2 + weightPlus;
                        break;
                    default:
                        weightTemp = 4 + weightPlus;
                        break;
                }
                if (topOp == 0 || weight[topOp - 1] < weightTemp) {
                    weight[topOp] = weightTemp;
                    operator[topOp] = ch;
                    topOp++;
                }else {
                    while (topOp > 0 && weight[topOp-1] >= weightTemp) {
                        switch (operator[topOp-1]) {
                            case '+':
                                number[topNum-2] += number[topNum-1];
                                break;
                            case '-':
                                number[topNum-2] -= number[topNum-1];
                                break;
                            case '*':
                                number[topNum-2] *= number[topNum-1];
                                break;
                            case '÷':
                                if (number[topNum-1] != 0) {
                                    number[topNum-2] /= number[topNum-1];
                                }
                                break;
                        }
                        topOp--;
                        topNum--;
                    }
                    weight[topOp] = weightTemp;
                    operator[topOp] = ch;
                    topOp++;
                }
            }
        }
        while (topOp > 0) {
            switch (operator[topOp-1]) {
                case '+':
                    number[topNum-2] += number[topNum-1];
                    break;
                case '-':
                    number[topNum-2] -= number[topNum-1];
                    break;
                case '*':
                    number[topNum-2] *= number[topNum-1];
                    break;
                case '÷':
                    if (number[topNum-1] != 0) {
                        number[topNum-2] /= number[topNum-1];
                    }
                    break;
            }
            topNum--;
            topOp--;
        }
        return String.valueOf(number[0]);
    }
}
