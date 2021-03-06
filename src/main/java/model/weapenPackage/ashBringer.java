package model.weapenPackage;

import Interfaces.Attackable;
import Interfaces.Visitor;
import com.fasterxml.jackson.annotation.JsonTypeName;
import model.GamePlayer;
import model.weapen;

import java.util.Map;

@JsonTypeName("ashBringer")
public class ashBringer extends weapen {


    public ashBringer(Map<String,Object>map){super(map);}

    public ashBringer() {
    }

    @Override
    public void accept(Visitor visitor, GamePlayer freind, GamePlayer enemy, Attackable target) {
        visitor.visitAshBringer(this,freind,enemy,target);
    }


}
