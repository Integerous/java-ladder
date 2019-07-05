package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private static final String NAME_SEPARATOR = ",";
    private static final int MINIMUM_NUMBER_OF_PLAYERS = 2;
    private static final String ALERT_SHORTAGE_OF_NUMBER_OF_PLAYERS = "플레이어는 최소 2명이 필요합니다.";
    public static final String ALERT_INEXISTENT_PLAYER_NAME = "입력하신 플레이어가 존재하지 않습니다.";

    private final List<Player> players;

    private Players(List<Player> players) {
        if (players.size() < MINIMUM_NUMBER_OF_PLAYERS) {
            throw new IllegalArgumentException(ALERT_SHORTAGE_OF_NUMBER_OF_PLAYERS);
        }
        this.players = players;
    }

    public static Players of(String inputNames) {
        return new Players(Arrays
                .stream(inputNames.split(NAME_SEPARATOR))
                .map(String::trim)
                .map(Player::from)
                .collect(Collectors.toList()));
    }

    public Player findPlayerByName(String playerNameToFind) {
        return players.stream()
                .filter(player -> playerNameToFind.equals(player.getName()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ALERT_INEXISTENT_PLAYER_NAME));
    }

    public int numberOfPlayers() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
