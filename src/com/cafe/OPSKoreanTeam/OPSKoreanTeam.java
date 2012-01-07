
package com.cafe.OPSKoreanTeam;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class OPSKoreanTeam extends JavaPlugin
{	
	public float Version = 0; //버젼 확인 float형
    private static final Logger log = Logger.getLogger("Minecraft.OPS"); // 로깅
    public OPSKoreanTeam()
    {
    }

    public void onDisable() //종료 메세지
    {
        log.info(String.format("[OPS] OPS플러그인을 사용해 주셔서 감사합니다.", new Object[0]));
    }
	public void autoUpdate() //자동 다운로드 드롭박스 경로
	{

		try {
			Update.autoDownload("http://dl.dropbox.com/u/40491841/OPSKoreanTeam/OPS.jar", getDataFolder().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public float Version() //버젼 확인 !중요! float형
	{
		try
		{
			Version = Float.parseFloat(getDescription().getVersion());
		}
		catch(Exception e)
		{
			System.out.println("[OPS] 버젼확인 불가!");
		}
		return Version;
	}
	public float getNewVersion(String url) //인터넷 환경 테스트, 버젼 html 에 연결
	{
		float rt2 = 0;
		String zeile;

		try {
			URL myConnection = new URL(url);
			URLConnection connectMe = myConnection.openConnection();

			InputStreamReader lineReader = new InputStreamReader(connectMe.getInputStream());
			//BufferedReader buffer = new BufferedReader(lineReader);
			BufferedReader br = new BufferedReader(new BufferedReader(lineReader));
			zeile = br.readLine();
			rt2 = Float.parseFloat(zeile);
		} catch(IOException ioe) {
			ioe.printStackTrace();
			System.out.println("[OPS] 인터넷 환경을 확인해 주세요!");
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[OPS] 인터넷 환경을 확인해 주세요!");
			return 0;
		}
		return rt2;
	}
	public boolean UpdateAvailable(String url, float currVersion) { //경로 확인 데이터
		boolean a = false;
		if(getNewVersion(url) > currVersion)
		{
			a = true;
		}
		return a;
	}
    public void onEnable() //구동 메세지
    {	
    	Version();
    	File localFile1 = new File("plugins/Update/");
	    localFile1.mkdir();                            //OPS 폴더생성
    	try
    	{
		this.getConfig().options().copyDefaults(true); //config.yml 지금은 사용하지 않음
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("[OPS]버젼: " + Version + " 구동 확인![OPS한글화팀]"); //현재 버젼 알림

		System.out.println(getDataFolder()); //구동 메세지
        log.info(String.format("[OPS] \uD55C\uAE00\uD654\uD300\uC758 \uD50C\uB7EC\uADF8\uC778\uC744 \uC774\uC6A9\uD574\uC8FC\uC154\uC11C \uAC10\uC0AC\uD569\uB2C8\uB2E4.OPS\uD55C\uAE00\uD654\uD300\uC758 \uD50C\uB7EC\uADF8\uC778\uC740 OPSLicense,CCL\uC5D0 \uC758\uD574 \uBCF4\uD638\uBC1B\uACE0 \uC788\uC2B5\uB2C8\uB2E4.\uD50C\uB7EC\uADF8\uC778\uC744 \uBB34\uB2E8\uC73C\uB85C \uC218\uC815\uD558\uAC70\uB098 \uBC30\uD3EC\uD560 \uACBD\uC6B0 \uCC98\uBC8C \uBC1B\uC73C\uC2E4\uC218 \uC788\uC2B5\uB2C8\uB2E4.", new Object[0]));
		String URL = "http://mineinfo.woobi.co.kr:80/OPSVersion.html"; //http://mineinfo.woobi.co.kr/OPSVersion.html
		if((UpdateAvailable(URL, Version)))
			if((UpdateAvailable(URL, Version)))
			{
				System.out.println("[OPS] 새로운 버젼: " + getNewVersion(URL) + " 찾음!"); //새로운 버젼 알림이
					autoUpdate();
				}
			}
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String args[])
    {
        if(commandLabel.equalsIgnoreCase("한글화팀")) //명령어 /한글화팀 을 치면 메세지출력 : 용도는 서버에 OPS플러그인이 있나의 사용용도
        {                if(args.length == 0)
        {
            sender.sendMessage((ChatColor.DARK_PURPLE) + "현서버는" + (ChatColor.GOLD) + "OPS한글화팀의" + (ChatColor.AQUA) + "플러그인을" + (ChatColor.DARK_RED) +"사용중입니다");
        }
		return false;   
        }
		return false;
    }
}
