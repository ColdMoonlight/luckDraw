package com.atguigu.test;

public class GetLuckTest {
	
	final static int num = 122;

	public static void main(String[] args) throws Exception {
		
		
		for(int i=0;i<num;i++){
			double d = (int)(Math.random()*num);//因为不需要0，所以需要加1
			System.out.println("第"+i+"次是第d位员工:"+d);
			
		}
		
	}
}
