package model.spellPackage;

import Interfaces.Attackable;
import Interfaces.Visitor;
import com.fasterxml.jackson.annotation.JsonTypeName;
import model.GamePlayer;
import model.spell;

import java.util.Map;

@JsonTypeName("fireBlast")
public class fireBlast extends spell {

    public fireBlast(Map<String,Object> map){
        super(map);
    }

    public fireBlast() {
    }

    @Override
    public void accept(Visitor visitor, GamePlayer freind, GamePlayer enemy, Attackable target) {
        visitor.visitFireBlast(this,freind,enemy,target);
    }


}
