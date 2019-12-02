package com.ydual.xgen.util.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileHelper {

	private FileHelper() {
	}

	public static void genDir(String dirPath) {
		File f = new File(dirPath);
		f.mkdirs();
	}

	public static String readFile(String path) {
        String content;
        DataInputStream din;
        content = "";
        din = null;
        try
        {
            din = new DataInputStream(new BufferedInputStream(FileHelper.class.getClassLoader().getResourceAsStream(path)));
            byte bs[] = new byte[din.available()];
            din.read(bs);
            content = new String(bs);
        }
        catch(Exception err)
        {
            err.printStackTrace();
        }finally {
			if (din != null)
				try {
					din.close();
				} catch (IOException e) {
				}
		}
        return content;
    }

	public static void writeFile(String pathName, String content)
    {
        File f;
        DataOutputStream dout = null;
        f = new File(pathName);
        if(f.exists())
            f.delete();
        try
        {
            f.createNewFile();
            dout = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
            dout.write(content.getBytes());
        }
        catch(Exception err)
        {
            err.printStackTrace();
        }finally {
			if (dout != null)
				try {
					dout.close();
				} catch (IOException e) {
				}
		}
    }

}
