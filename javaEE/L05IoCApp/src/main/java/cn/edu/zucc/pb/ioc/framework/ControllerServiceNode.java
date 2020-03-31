package cn.edu.zucc.pb.ioc.framework;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class ControllerServiceNode {
    @XmlAttribute
    private String name;
    @XmlAttribute
    private String ref;

    public String getName() {
        return name;
    }

    public String getRef() {
        return ref;
    }
}
