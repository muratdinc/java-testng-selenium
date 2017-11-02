package com.fairbit.test.saucelab.Pages;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by OZGUR-FAIRBIT on 10/31/2017.
 */

public class ReadPlatformXML {
    public static Object[][] getObjects(File file) throws JAXBException{

        JAXBContext context = JAXBContext.newInstance(Platforms.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Platforms platforms = (Platforms) unmarshaller.unmarshal(file);
        List<Platform> data = platforms.getPlatforms();
        Object[][] o = null;
        Object[] onedimension = null;
        for (Platform platform : data){
            o = new Object[][]{
                new Object[]{platform.getBrowsername(), platform.getBrowserversion(), platform.getOs()},
            };

//            System.out.println(platform);
        }
        return o;
    }

    public static void main(String[] args) throws JAXBException {
        File f = new File("./data/platforms.xml");
        Object[][] obj = getObjects(new File("./data/platforms.xml"));

        for(Object objs: obj){
            System.out.println(objs.toString());
        }

    }
}
