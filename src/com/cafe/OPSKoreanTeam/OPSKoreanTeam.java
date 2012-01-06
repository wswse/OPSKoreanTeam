// Decompiled by DJ v3.6.6.79 Copyright 2004 Atanas Neshkov  Date: 2012-01-05 ���� 1:23:41
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   OPSKoreanTeam.java

package com.cafe.OPSKoreanTeam;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class OPSKoreanTeam extends JavaPlugin
{
    private static final Logger log = Logger.getLogger("Minecraft"); //마인크래프트에 로깅
    public OPSKoreanTeam()
    {
    }

    public void onDisable() //종료 메세지
    {
        log.info(String.format("[OPS] OPS플러그인을 사용해 주셔서 감사합니다.", new Object[0]));
    }

    public void onEnable() //구동 메세지
    {
        log.info(String.format("[OPS] \uD55C\uAE00\uD654\uD300\uC758 \uD50C\uB7EC\uADF8\uC778\uC744 \uC774\uC6A9\uD574\uC8FC\uC154\uC11C \uAC10\uC0AC\uD569\uB2C8\uB2E4.OPS\uD55C\uAE00\uD654\uD300\uC758 \uD50C\uB7EC\uADF8\uC778\uC740 OPSLicense,CCL\uC5D0 \uC758\uD574 \uBCF4\uD638\uBC1B\uACE0 \uC788\uC2B5\uB2C8\uB2E4.\uD50C\uB7EC\uADF8\uC778\uC744 \uBB34\uB2E8\uC73C\uB85C \uC218\uC815\uD558\uAC70\uB098 \uBC30\uD3EC\uD560 \uACBD\uC6B0 \uCC98\uBC8C \uBC1B\uC73C\uC2E4\uC218 \uC788\uC2B5\uB2C8\uB2E4.", new Object[0]));
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
