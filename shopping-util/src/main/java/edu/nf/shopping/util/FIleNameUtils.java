package edu.nf.shopping.util;


public class FIleNameUtils {

	public static String newFileName(String fileName) {
		StringBuilder builder=new StringBuilder();
		String[] pattern=fileName.split("\\.");
		if(pattern.length > 1) {
			String extName=pattern[pattern.length-1];
			builder.append(System.currentTimeMillis()).append(".").append(extName);
		}else {
			builder.append(System.currentTimeMillis());
		}		
		return builder.toString();
	}

	public static String getFileSuffix(String fileName) {
		StringBuilder builder=new StringBuilder();
		String[] pattern=fileName.split("\\.");
		String extName=pattern[pattern.length-1];
		return extName;
	}
	
	public static String fileNameNotHaveSuffix(String fileName) {
		return fileName= fileName.substring(0, fileName.lastIndexOf("."));
	}

	public static void main(String[] args) {
		System.out.println(newFileName("oop面向对象.jpg"));
	}
}
