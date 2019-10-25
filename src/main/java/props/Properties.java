package props;

import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;

@Resource.Classpath("properties")
public interface Properties  {

    @Property("service.url")
    String serviceUrl();

    Properties props = PropertyLoader.newInstance().populate(Properties.class);
}
