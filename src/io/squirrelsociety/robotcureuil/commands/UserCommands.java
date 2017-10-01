package io.squirrelsociety.robotcureuil.commands;

import io.squirrelsociety.robotcureuil.RobotCureuil;
import io.squirrelsociety.robotcureuil.command.Command;
import net.dv8tion.jda.core.entities.TextChannel;

/**
 * Created by GartoxFR on 30/09/2017.
 */
public class UserCommands {

    @Command(name = "role", type = Command.ExecutorType.USER)
    public void info(TextChannel channel) {
        channel.sendMessage("Clique sur le <:graven:357498859053776908> pour avoir le rôle !").queue();
        channel.addReactionById(channel.getLatestMessageIdLong(), "357498859053776908").complete();
    }

    @Command(name = "stop", type = Command.ExecutorType.CONSOLE)
    public void stop(){
        RobotCureuil.getInstance().setRunning(false);
    }

}
