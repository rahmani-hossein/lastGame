package model.minionPackage;

import Interfaces.Attackable;
import Interfaces.Visitor;
import com.fasterxml.jackson.annotation.JsonTypeName;
import model.GamePlayer;
import model.Minion;

import java.util.Map;

@JsonTypeName("highPriestAmet")
public class highPriestAmet extends Minion {

    public highPriestAmet(Map<String, Object> map) {
        super(map);
    }

    public highPriestAmet() {
    }

    @Override
    public void accept(Visitor visitor, GamePlayer freind, GamePlayer enemy, Attackable target) {
        visitor.visitHighPriestAmet(this,freind,enemy,target);
    }


}
