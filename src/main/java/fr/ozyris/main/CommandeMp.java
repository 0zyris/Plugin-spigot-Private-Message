package fr.ozyris.main;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

public class CommandeMp implements CommandExecutor, TabCompleter{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player){

            Player player = (Player) sender;

            if(label.equalsIgnoreCase("mp")){

                Player player1 = Bukkit.getPlayer(args[0]);
                String thefinalstring = "";
                int ag = args.length;
                int a = ag - 1;
                for (int i = 1; i < args.length - 1; i++) {
                    thefinalstring += args[i] + ' ';
                }
                thefinalstring += args[a] ;
                thefinalstring = thefinalstring.trim();
                player.sendMessage(ChatColor.AQUA + "<You> -->" + " <" + player.getName() + "> " + thefinalstring);
                player1.sendMessage(ChatColor.LIGHT_PURPLE + " <" + player.getName() + "> --> <You> " + thefinalstring);
            }
        }
        return false;
    }

    List<String> arguments1 = new ArrayList<String>();
    List<String> arguments2 = new ArrayList<String>();
    
	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		
        if (sender instanceof Player) {

            Player player = (Player) sender;

            Player[] players = new Player[Bukkit.getServer().getOnlinePlayers().size()];
                Bukkit.getServer().getOnlinePlayers().toArray(players);
                for (int i = 0; i< players.length; i++){
                    arguments1.add(players[i].getName());
                }
                if (args.length == 1){
                    return arguments1;
                }else if (args.length > 1){
                    return arguments2;
                }
        }
        return null;
	}
}

// /mp pseudo msg