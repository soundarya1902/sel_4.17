package framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import static java.lang.System.out;

public class Props
{
    private static final Logger LOG = LoggerFactory.getLogger(Props.class);
    private static Properties environmentProps,properties;


    public static void loadProperties(String configPropertyFileLocation)
    {
        environmentProps = new Properties();
        try (InputStream inputStream = Props.class.getResourceAsStream(configPropertyFileLocation))
        {
            environmentProps.load(inputStream);
            environmentProps.list(out);
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
        properties = new Properties();
        try (InputStream inputStream = Props.class.getResourceAsStream(environmentProps.getProperty("profile.path"))) {
            properties.load(inputStream);
            properties.list(out);
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
    }
    public static String getProp(String key) {
        if ((key == null) || key.isEmpty()) {
            return "";
        } else {
            return properties.getProperty(key);

        }
    }
    public static void setprop(String key,String value) {
        if ((key == null) || key.isEmpty()) {
            System.out.println("no key value");
        } else {
            properties.setProperty(key, value);

        }
    }
}
