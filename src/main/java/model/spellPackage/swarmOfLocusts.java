package model.spellPackage;

import Interfaces.Attackable;
import Interfaces.Visitor;
import com.fasterxml.jackson.annotation.JsonTypeName;
import model.GamePlayer;
import model.spell;

import java.util.Map;

@JsonTypeName("swarmOfLocusts")
public class swarmOfLocusts extends spell {

    public swarmOfLocusts(Map<String, Object> map) {
        super(map);
    }

    public swarmOfLocusts() {
    }

    @Override
    public void accept(Visitor visitor, GamePlayer freind, GamePlayer enemy, Attackable target) {
        visitor.visitSwarmOfLocusts(this,freind,enemy,target);
    }


}
