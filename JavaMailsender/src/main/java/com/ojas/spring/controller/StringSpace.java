package com.ojas.spring.controller;

public class StringSpace {

	public static void main(String[] args) {

String name="Ranjith";
//String spare=new String(name);
for(int i=0;i<17;i++) {
	
	if(i==16) {
		name=name+i;
	}else
	name=name+" ";
}
System.out.println(name);
	}

}
