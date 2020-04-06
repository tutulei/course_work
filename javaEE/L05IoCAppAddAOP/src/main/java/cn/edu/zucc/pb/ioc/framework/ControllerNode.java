package cn.edu.zucc.pb.ioc.framework;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-03-21 16:27
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ControllerNode {
    @XmlAttribute
    private String id;

    @XmlAttribute
    private String clazz;

    @XmlAttribute
    private String path;

    @XmlElement(name = "service")
    private List<ControllerServiceNode> services;

    public List<ControllerServiceNode> getServices() {
        return services;
    }

    public ControllerServiceNode findService(String name) {
        for(ControllerServiceNode service : services){
            if(service.getName().equals(name)){
                return service;
            }
        }
        return null;
    }
    public ControllerServiceNode getService(int index){
        return services.get(index);
    }
    public String getPath() {
        return path;
    }

    public String getId() {
        return id;
    }

    public String getClazz() {
        return clazz;
    }

}
