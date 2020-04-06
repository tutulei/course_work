package cn.edu.zucc.pb.ioc.framework;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-03-21 16:27
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ServiceNode {
    @XmlAttribute
    private String id;

    @XmlAttribute
    private String clazz;
    @XmlAttribute
    private String iclazz;

    public String getIclazz() {
        return iclazz;
    }

    public String getId() {
        return id;
    }

    public String getClazz() {
        return clazz;
    }
}
