package utils;

import entitys.Place;
import entitys.RealPlace;
import entitys.VirtualPlace;

public class PlaceFabric {

    public static Place createPlace(String[] args){
        if (args.length==1){
            return new VirtualPlace(args[0]);
        }else if (args.length==3){
            return new RealPlace(Integer.parseInt(args[0]), Integer.parseInt(args[0]), Integer.parseInt(args[2]));
        } else{
            throw new IllegalArgumentException();
        }
    }

}
