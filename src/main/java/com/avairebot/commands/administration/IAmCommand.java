package com.avairebot.commands.administration;

import com.avairebot.AvaIre;
import com.avairebot.contracts.commands.Command;
import com.avairebot.database.controllers.GuildController;
import com.avairebot.database.transformers.GuildTransformer;
import com.avairebot.factories.MessageFactory;
import com.avairebot.utilities.RoleUtil;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.Role;

import java.util.Collections;
import java.util.List;

public class IAmCommand extends Command {

    public IAmCommand(AvaIre avaire) {
        super(avaire, false);
    }

    @Override
    public String getName() {
        return "I Am Command";
    }

    @Override
    public String getDescription() {
        return "Gives you the role with the given name if it is in the self-assignable list of roles.";
    }

    @Override
    public List<String> getUsageInstructions() {
        return Collections.singletonList("`:command <role>`");
    }

    @Override
    public List<String> getExampleUsage() {
        return Collections.singletonList("`:command DJ`");
    }

    @Override
    public List<String> getTriggers() {
        return Collections.singletonList("iam");
    }

    @Override
    public boolean onCommand(Message message, String[] args) {
        if (args.length == 0) {
            return sendErrorMessage(message, "Missing argument, the `role` argument is required.");
        }

        Role role = RoleUtil.getRoleFromMentionsOrName(message, args[0]);
        if (role == null) {
            MessageFactory.makeWarning(message, ":user Invalid role, I couldn't find any role called **:role**")
                .set("role", args[0])
                .queue();
            return false;
        }

        GuildTransformer transformer = GuildController.fetchGuild(avaire, message);
        if (!transformer.getSelfAssignableRoles().containsValue(role.getName().toLowerCase())) {
            MessageFactory.makeWarning(message, ":user Invalid role, **:role** is not a self-assignable role.")
                .set("role", args[0])
                .queue();
            return false;
        }

        if (RoleUtil.isRoleHierarchyHigher(message.getGuild().getSelfMember().getRoles(), role)) {
            MessageFactory.makeWarning(message, ":user The role is higher in the role hierarchy, I can't give/remove the **:role**  role from anyone.")
                .set("role", args[0])
                .queue();
            return false;
        }

        if (!RoleUtil.hasRole(message.getMember(), role)) {
            message.getGuild().getController().addSingleRoleToMember(message.getMember(), role).queue();
        }

        MessageFactory.makeSuccess(message, ":user You now have the **:role** role!")
            .set("role", role.getName())
            .queue();
        return true;
    }
}
