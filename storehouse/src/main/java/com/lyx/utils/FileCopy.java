package com.lyx.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class FileCopy {
	public FileCopy(InputStream is,OutputStream os) {
			
			try {
				
				byte[] flush = new byte[1024];
				int len = -1;
				while((len = is.read(flush))!=-1) {
					os.write(flush,0,len);
					
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				 
				if (os != null) {
					try {
						os.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (is != null) {
					try {
						is.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
	}

}
