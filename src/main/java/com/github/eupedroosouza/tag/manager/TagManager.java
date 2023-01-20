package com.github.eupedroosouza.tag.manager;

import com.github.eupedroosouza.tag.Main;
import com.github.eupedroosouza.tag.model.Tag;
import com.github.eupedroosouza.tag.repository.TagRepository;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.HashMap;

/**
 * @author Pedro
 * @project pedrotags
 * @created 08/12/2022 - 16:05
 */
@Getter
public class TagManager {

    @Getter
    private static final TagManager manager = new TagManager();

    private final HashMap<String, Tag> tags = new HashMap<>();
    private final HashMap<String, String> players = new HashMap<>();
    private Scoreboard scoreboard;

    public void setup(){
        TagRepository.getRepository().loadAll().forEach(tag ->
                tags.put(tag.getId().toLowerCase(), tag));
        Main.getInstance().getLogger().info(tags.size() + " tags have been loaded.");

        scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();


    }

    public void set(Player player, Tag tag){
        players.put(player.getName().toLowerCase(), tag.getId());

        Scoreboard scoreboard = player.getScoreboard();
        String prefixTeamName = "t" + tag.getPriority() + "_";
        int nameLength = 16 - prefixTeamName.length();
        String teamName = prefixTeamName + (player.getName().length() >= nameLength ? player.getName().substring(nameLength) : player.getName());

        Team team = scoreboard.getTeam(teamName) != null ? scoreboard.getTeam(teamName) : scoreboard.registerNewTeam(teamName);

        team.setPrefix(tag.getPrefix());
        team.setSuffix(tag.getSuffix());

        team.addEntry(player.getName());

    }

}
