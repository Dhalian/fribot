package com.torpill.fribot.commands.utility;

import java.util.List;

import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.permission.PermissionType;
import org.javacord.api.entity.permission.Role;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;

import com.torpill.fribot.App;
import com.torpill.fribot.bot.DiscordBot;
import com.torpill.fribot.commands.Command;
import com.torpill.fribot.commands.Command.ArgumentType;
import com.torpill.fribot.commands.Command.Category;

/**
 * 
 * Cette classe représente une commande affichant les informations du bot
 * Discord.
 * 
 * @author torpill40
 * 
 * @see com.torpill.fribot.commands.Command
 *
 */

public class InfoCommand extends Command {

	/**
	 * 
	 * Constructeur de la classe <code>InfoCommand</code>.
	 * 
	 */
	public InfoCommand() {

		super("info", Command.ArgumentType.NONE, Command.Category.UTILITY);
	}

	@Override
	public String getHelp() {

		return "Affiche des informations sur le bot.";
	}

	@Override
	public boolean deleteCommandUsage() {

		return true;
	}

	@Override
	public List<PermissionType> permissionNeeded() {

		return null;
	}

	@Override
	public List<Role> whiteListedRoles(DiscordBot bot, Server server) {

		return null;
	}

	@Override
	public List<Role> blackListedRoles(DiscordBot bot, Server server) {

		return null;
	}

	@Override
	public List<User> whiteListedUsers(DiscordBot bot, Server server) {

		return null;
	}

	@Override
	public List<User> blackListedUsers(DiscordBot bot, Server server) {

		return null;
	}

	@Override
	public int execute(DiscordBot bot, String[] args, User user, TextChannel channel, Server server) {

		final EmbedBuilder embed = bot.defaultEmbedBuilder("Informations :", bot.getName() + " :", user);
		embed.addField("Propriétaire :", bot.owner().getDiscriminatedName(), true);
		embed.addField("Version :", App.VERSION, true);
		embed.addField("Préfix :", bot.getPrefix(), true);
		embed.addField("Date de création :", bot.getCreationDate(), false);
		embed.addField("Couleur :", "RGB(" + bot.getColor().getRed() + ", " + bot.getColor().getGreen() + ", " + bot.getColor().getBlue() + ")", true);
		embed.addField("Langage :", "Java", true);
		embed.addField("Github :", App.GITHUB, false);
		channel.sendMessage(embed);

		return 0;
	}
}