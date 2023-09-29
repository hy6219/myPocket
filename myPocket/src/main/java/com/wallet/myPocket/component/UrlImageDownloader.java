package com.wallet.myPocket.component;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UrlImageDownloader {
	
	public String downloadImageFromUrl(String url, String dir, String fileName, String ext) {
		BufferedInputStream bis = null;
		FileOutputStream out= null;
		String fullName= "";
		
		try{
			fullName = getFullPath(dir, fileName, ext);
			//경로가 없으면 만들기
			File file = new File(dir);
			System.out.println("path exists? : "+file.exists());
			if(!file.exists()) {
				if(file.mkdirs()) {
					System.out.println("made dir");					
				}
			}
			
			bis = new BufferedInputStream(new URL(url).openStream());
			out = new FileOutputStream(fullName);
			byte[] data = new byte[1024*1024];
			int read = -1;
			
			while((read = bis.read(data))!=-1) {//한번에 읽기
				out.write(data, 0, read);
			}
			
			log.info("파일 : {} 저장 완료", fullName);
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				bis.close();
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return fullName;
	}
	
	public String getFullPath(String dir, String fileName, String ext) {
		return dir+"\\"+fileName+"."+ext;
	}
}
