package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private List<Boolean> bars;

    private Line(List<Boolean> bars) {
        this.bars = new ArrayList<>(bars);
    }

    public static Line from(int numberOfPlayers) {
        LineMaker lineMaker = new LineMaker();
        return new Line(lineMaker.generateBars(numberOfPlayers));
    }

    public List<Boolean> getBars() {
        return Collections.unmodifiableList(bars);
    }

    public int travel(int position) {
        if (bars.get(position)) { //사용자의 현재 위치보다 bar의 위치가 같으면 사용자의 현재위치가 1만큼 증가
            return position + 1;
        }
        if (bars.get(position - 1)) { //사용자의 현재 위치보다 bar의 위치가 1만큼 작으면 사용자의 현재위치는 1만큼 감소
            return position - 1;
        }
        return position;
    }
}
