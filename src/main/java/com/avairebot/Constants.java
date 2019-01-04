/*
 * Copyright (c) 2018.
 *
 * This file is part of AvaIre.
 *
 * AvaIre is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AvaIre is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with AvaIre.  If not, see <https://www.gnu.org/licenses/>.
 *
 *
 */

package com.avairebot;

import java.io.File;

@SuppressWarnings("WeakerAccess")
public class Constants {

    public static final File STORAGE_PATH = new File("storage");

    // Database Tables
    public static final String GUILD_TABLE_NAME = "guilds";
    public static final String GUILD_TYPES_TABLE_NAME = "guild_types";
    public static final String STATISTICS_TABLE_NAME = "statistics";
    public static final String BLACKLIST_TABLE_NAME = "blacklists";
    public static final String PLAYER_EXPERIENCE_TABLE_NAME = "experiences";
    public static final String VOTES_TABLE_NAME = "votes";
    public static final String FEEDBACK_TABLE_NAME = "feedback";
    public static final String MUSIC_PLAYLIST_TABLE_NAME = "playlists";
    public static final String SHARDS_TABLE_NAME = "shards";
    public static final String LOG_TABLE_NAME = "logs";
    public static final String LOG_TYPES_TABLE_NAME = "log_types";
    public static final String REACTION_ROLES_TABLE_NAME = "reaction_roles";

    // Package Specific Information
    public static final String PACKAGE_COMMAND_PATH = "com.avairebot.commands";
    public static final String PACKAGE_INTENTS_PATH = "com.avairebot.ai.intents";
    public static final String PACKAGE_JOB_PATH = "com.avairebot.scheduler";

    // Emojis
    public static final String EMOTE_ONLINE = "<:Online:519338699788648458>";
    public static final String EMOTE_AWAY = "<:Away:519338739751976970>";
    public static final String EMOTE_DND = "<:DND:519338793166307344>";

    // Command source link
    public static final String SOURCE_URI = "https://github.com/LTN-Akagi/Kaga/tree/master/src/main/java/com/avairebot/commands/%s/%s.java";
}
