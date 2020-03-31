package cn.edu.zucc.pb.ioc.framework;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-03-21 16:21
 */
@XmlRootElement(name="pb-ioc")
@XmlAccessorType(XmlAccessType.FIELD)
public class Pbioc {
    @XmlElement(name="controller")
    private List<ControllerNode> controllers;

    @XmlElement(name="service")
    private List<ServiceNode> services;

    public List<ControllerNode> getControllers() {
        return controllers;
    }
    public ControllerNode findController(String path){
        for (ControllerNode controller: controllers) {
            if(controller.getPath().equals(path)){
                return controller;
            }
        }
        return null;
    }
    public ServiceNode findService(String id){
        for (ServiceNode service: services) {
            if(service.getId().equals(id)){
                return service;
            }
        }
        return null;
    }

}
