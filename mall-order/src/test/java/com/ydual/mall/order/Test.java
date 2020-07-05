package com.ydual.mall.order;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

public class Test {
     
    public static final String PATH="D:/video/art/nsjd";
     
    /**
     * 加密
     * @throws Exception
     */
    public void encode()throws Exception {
         
        //获取密钥文件
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(PATH+File.separator+"password")));
         
        byte[] passwd=new byte[bis.available()];
        bis.read(passwd);
        bis.close();
        File fold = new File(PATH);
        for (File f : FileFilterUtils.filter(new SuffixFileFilter(new String[] {"mp4", "flv"}), fold.listFiles())) {
        	
        	//获取原视频文件
        	BufferedInputStream bisOld = new BufferedInputStream(new FileInputStream(new File(PATH+ File.separator + f.getName())));
        	//输出加密后的流文件
        	BufferedOutputStream bosNew = new BufferedOutputStream(new FileOutputStream(new File(PATH+ File.separator + "encode" + File.separator + f.getName())));
        	//写入密钥
        	bosNew.write(passwd);
        	byte[] buffer=new byte[1024];
        	int len=0;
        	//加密文件
        	while((len=bisOld.read(buffer))>0){
        		bosNew.write(buffer, 0, len);
        	}
        	bosNew.flush();
        	bosNew.close();
        	
        	bisOld.close();
        }
         
         
         
    }
     
    /**
     * 解密
     * @throws Exception
     */
    public void decode()throws Exception {
        //获取密钥文件
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(PATH+File.separator+"password")));
        int passwdLen=bis.available();
        byte[] passwd=new byte[passwdLen];
        bis.close();
        File fold = new File(PATH+ File.separator + "encode");
        for (File f : FileFilterUtils.filter(new SuffixFileFilter(new String[] {"mp4","flv"}), fold.listFiles())) {
        	
        	System.out.println(f.getPath());
        	//获取加密文件
        	BufferedInputStream bisOld = new BufferedInputStream(new FileInputStream(f));
        	//输出解密后流文件
        	BufferedOutputStream bosNew = new BufferedOutputStream(new FileOutputStream(new File(PATH +"/decode/"+f.getName())));
        	//获取密钥
        	bisOld.read(passwd);
        	
        	
        	byte[] buffer=new byte[1024];
        	int len=0;
        	
        	while((len=bisOld.read(buffer))>0){
        		bosNew.write(buffer, 0, len);
        	}
        	
        	bosNew.flush();
        	bosNew.close();
        	
        	bisOld.close();
        }
        passwd=null;
    }
    
    public static void UpdateFileNameBatch() throws Exception {
    	String path = "D:/video/art/discrete";
    	File f = new File(path);
    	// 读取文件名列表
    	BufferedReader reader = new BufferedReader(new FileReader(new File(path+File.separator+"names.txt")));
    	String name = reader.readLine();
    	int index = 1;
    	while (name != null && !"".equals(name)) {
    		File[] file = FileFilterUtils.filter(FileFilterUtils.prefixFileFilter(name), f.listFiles());
    		if (file.length == 2) {
    			file[0].renameTo(new File(path + File.separator + index + "-" + file[0].getName()));
    			file[1].renameTo(new File(path + File.separator + index + "-" + file[1].getName()));
    		}
    		name = reader.readLine();
    		index ++;
    	}
    	reader.close();
    }
     
    public static void main(String[] args)throws Exception {
        Test t = new Test();
        //加密
        //t.encode();
        //解密
        t.decode();
        // 文件批量改名
        //UpdateFileNameBatch();
    }
 
}