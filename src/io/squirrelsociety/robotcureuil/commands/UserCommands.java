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
        channel.sendMessage("Clique sur le 🐿  pour avoir le rôle !").queue( message -> channel.addReactionById(message.getId(), "🐿").queue());
    }

    @Command(name = "stop", type = Command.ExecutorType.CONSOLE)
    public void stop(){
        RobotCureuil.getInstance().setRunning(false);
    }

}
