package io.squirrelsociety.robotcureuil.commands;

import java.awt.Color;

import io.squirrelsociety.robotcureuil.command.Command;
import io.squirrelsociety.robotcureuil.command.Command.ExecutorType;
import io.squirrelsociety.robotcureuil.maps.PartiMap;
import io.squirrelsociety.robotcureuil.objects.Parti;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;

public class PoliticCommands {
	
	private PartiMap partiMap = new PartiMap();
	
	private void errorBuilder(TextChannel channel, String message) {
		EmbedBuilder builder = new EmbedBuilder();
		builder.setTitle("ERREUR", null);
		builder.setDescription(message);
		builder.setColor(Color.RED);
		builder.setThumbnail("https://images-ext-2.discordapp.net/external/KFVDlmbzoOmDr6LebDtMpYNVkIlxOnCo6fXPqu1YfZI/http/minuskube.fr/error_icon.png");
		channel.sendMessage(builder.build()).queue();
	}
	
	@Command(name="parti", type=ExecutorType.USER)
	public void onParti(User user, TextChannel channel, String[] args, Guild guild, Message message) {
		if(args.length < 2) {
			errorBuilder(channel, "Vous n'avez pas entré assez d'arguments");
		} else {
			System.out.println(args[0]);
			if(args[0].equals("join")) {
				System.out.println("Il essaye de join");
				if(partiMap.getMap().containsKey(args[1])) {
					partiMap.getMap().get(args[1]).registerMember(user);
				} else {
					errorBuilder(channel, "Ce parti n'existe pas");
				}
			} else if (args[0].equals("create")) {
				if(args.length < 2) {
					errorBuilder(channel, "Pour créer votre parti il faut entrer `nom`, `position`");
				} else {
					System.out.println("Il essaye de créer un parti");
					if(!partiMap.getMap().containsKey(args[1])) {
						System.out.println("Ce parti n'existe pas");
						System.out.println("Il veut l'appeller " + args[1] + " et à comme position " + args[2]);
						partiMap.register(new Parti(args[1], args[2], user));
						channel.sendMessage("Vous venez de créer le parti **" + args[1] + "** !").queue();
					} else {
						errorBuilder(channel, "Ce parti existe déjà");
					}
				}
			}
		}
	}
}
