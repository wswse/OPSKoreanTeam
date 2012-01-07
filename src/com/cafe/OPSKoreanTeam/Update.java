package com.cafe.OPSKoreanTeam;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.net.URL;

class Update implements Serializable
{
	private static final long serialVersionUID = 1L;
	String s; 
	transient int i; 

    public static String readAll(Reader in) throws IOException {
        if(in == null) 
        	throw new NullPointerException("in == null");
        try {
            StringBuilder sb = new StringBuilder();
            char[] buf = new char[1024];
            int charsRead;
            while((charsRead = in.read(buf)) != -1) {
                sb.append(buf, 0, charsRead);
            }
            return sb.toString();
        }
        finally {
            in.close();
        }
    }
    
	public static void autoDownload(String url, String datafolder) throws Exception
	{
			String path = datafolder + "/Update/"; //업데이트 폴더에 다운을 받음
			File dir = new File(path);
			dir.mkdir();
			File file = new File(path + "OPS.jar"); //을 받음
			if (file.exists())
			{
				file.delete();
				autoDownload(url, datafolder);
				return;
			}
			else
			{
			try
			{
					URL newurl = new URL(url); //데이터 전송
			        BufferedInputStream buffin = new BufferedInputStream(newurl.openStream());
	                BufferedOutputStream buffout = new BufferedOutputStream(new FileOutputStream(file));
	                byte[] buffer = new byte[200000];
	                int len; 
	                while ((len = buffin.read(buffer)) != -1) {
	                    buffout.write(buffer, 0, len);
	                }      
	                buffout.flush();
	                buffout.close();
	                buffin.close(); //다운로드 완료 메세지
	                System.out.println("[OPS] 새로운 OPS를 다운로드 했습니다, OPS폴더를 확인해 주세요.");
				}
				finally
				{
	
				}
	      }
	}
}