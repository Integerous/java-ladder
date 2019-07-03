package ladder;

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
}
