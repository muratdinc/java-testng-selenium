package com.fairbit.test.saucelab.Pages;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

/**
 * Created by OZGUR-FAIRBIT on 10/31/2017.
 */

public class ReadPlatformXML {

    public static void main(String[] args) throws JAXBException {

        JAXBContext context = JAXBContext.newInstance(Platforms.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        File f = new File("./data/platforms.xml");

        Platforms platforms = (Platforms) unmarshaller.unmarshal(f);
        List<Platform> data = platforms.getPlatforms();

        for (Platform platform : data){
            System.out.println(platform);
        }
    }
}
