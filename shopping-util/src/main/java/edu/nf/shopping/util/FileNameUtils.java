package edu.nf.shopping.util;


import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class FileNameUtils {

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
		return fileName= fileName.substring(0,fileName.lastIndexOf("."));
	}

	public static int upload(String url, InputStream input, String fileName) {
		try(CloseableHttpClient httpClient = HttpClients.createDefault();
			BufferedInputStream bis = new BufferedInputStream(input);
			ByteArrayOutputStream baos = new ByteArrayOutputStream()){
			HttpPost post = new HttpPost(url);
			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
			byte[] bytes = new byte[2048];
			int len = 0;
			while((len=bis.read(bytes, 0, bytes.length)) != -1) {
				baos.write(bytes, 0, len);
			}
			builder.addBinaryBody("file", baos.toByteArray(), ContentType.MULTIPART_FORM_DATA, fileName);
			post.setEntity(builder.build());
			CloseableHttpResponse response = httpClient.execute(post);
			return response.getStatusLine().getStatusCode();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
