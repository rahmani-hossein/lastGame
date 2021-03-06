package model.spellPackage;

import Interfaces.Attackable;
import Interfaces.Visitor;
import com.fasterxml.jackson.annotation.JsonTypeName;
import model.GamePlayer;
import model.spell;

import java.util.Map;

@JsonTypeName("decimation")
public class decimation extends spell {

    public decimation(Map<String, Object> map) {
        super(map);
    }

    public decimation() {
    }

    @Override
    public void accept(Visitor visitor, GamePlayer freind, GamePlayer enemy, Attackable target) {
        visitor.visitDecimation(this,freind,enemy,target);
    }


}
