package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerAnalyzerTest {

    private PlayerAnalyzer analyzer;

    @BeforeEach
    public void setUp() {
        analyzer = new PlayerAnalyzer();
    }

    @Test
    public void testNormalPlayer() {
        Player player = new Player();
        player.setAge(25);
        player.setExperience(5);
        player.setSkills(Arrays.asList(2, 2, 2));

        double score = analyzer.calculateScore(Collections.singletonList(player));

        assertEquals(250.0, score, "Expected score for normal player does not match");
    }

    @Test
    public void testJuniorPlayer() {
        Player player = new Player();
        player.setAge(15);
        player.setExperience(3);
        player.setSkills(Arrays.asList(3, 3, 3));

        double score = analyzer.calculateScore(Collections.singletonList(player));

        assertEquals(67.5, score, "Expected score for junior player does not match");
    }

    @Test
    public void testSeniorPlayer() {
        Player player = new Player();
        player.setAge(35);
        player.setExperience(15);
        player.setSkills(Arrays.asList(4, 4, 4));

        double score = analyzer.calculateScore(Collections.singletonList(player));

        assertEquals(2520.0, score, "Expected score for senior player does not match");
    }

    @Test
    public void testMultiplePlayers() {
        Player normalPlayer = new Player();
        normalPlayer.setAge(25);
        normalPlayer.setExperience(5);
        normalPlayer.setSkills(Arrays.asList(2, 2, 2));

        Player juniorPlayer = new Player();
        juniorPlayer.setAge(15);
        juniorPlayer.setExperience(3);
        juniorPlayer.setSkills(Arrays.asList(3, 3, 3));

        double score = analyzer.calculateScore(Arrays.asList(normalPlayer, juniorPlayer));

        assertEquals(317.5, score, "Expected score for multiple players does not match");
    }

    @Test
    public void testSkillsIsNull() {
        Player player = new Player();
        player.setAge(25);
        player.setExperience(5);
        player.setSkills(null);

        assertThrows(NullPointerException.class, () -> {
            analyzer.calculateScore(Collections.singletonList(player));
        }, "Expected NullPointerException when skills is null");
    }

    @Test
    public void testEmptyArray() {
        List<Player> emptyList = Collections.emptyList();

        double score = analyzer.calculateScore(emptyList);

        assertEquals(0.0, score, "Expected score for an empty list of players to be 0");
    }
}
