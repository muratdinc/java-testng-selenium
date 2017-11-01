package com.fairbit.test.saucelab.Pages;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by OZGUR-FAIRBIT on 10/31/2017.
 */

@XmlRootElement(name="platforms")
@XmlAccessorType(XmlAccessType.FIELD)
public class Platforms {

    @XmlElement(name="platform", type=Platform.class)
    private List<Platform> platforms;

    public List<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }

}
