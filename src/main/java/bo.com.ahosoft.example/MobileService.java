package bo.com.ahosoft.example;

import java.util.Optional;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 14-11-17 - 01:54 PM
 * Project       : example-java8
 * Package       : bo.com.ahosoft.example
 **/
public class MobileService {

    public int getMobileScreenWidth(Optional<Mobile> mobile) {
//        if (mobile != null) {
//            DisplayFeatures dfeatures = mobile.getDisplayFeatures();
//            if (dfeatures != null) {
//                ScreenResolution resolution = dfeatures.getResolution();
//                if(resolution != null)
//                    return resolution.getWidth();
//            }
//        }
//        return 0;
        return  mobile.flatMap(Mobile::getDisplayFeatures)
                .flatMap(DisplayFeatures::getResolution)
                .map(ScreenResolution::getWidth)
                .orElse(0);
    }
}
