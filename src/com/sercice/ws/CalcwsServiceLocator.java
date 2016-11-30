/**
 * CalcwsServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sercice.ws;

public class CalcwsServiceLocator extends org.apache.axis.client.Service implements com.sercice.ws.CalcwsService {

    public CalcwsServiceLocator() {
    }


    public CalcwsServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CalcwsServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for calcws
    private java.lang.String calcws_address = "http://localhost:8080/ws/services/calcws";

    public java.lang.String getcalcwsAddress() {
        return calcws_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String calcwsWSDDServiceName = "calcws";

    public java.lang.String getcalcwsWSDDServiceName() {
        return calcwsWSDDServiceName;
    }

    public void setcalcwsWSDDServiceName(java.lang.String name) {
        calcwsWSDDServiceName = name;
    }

    public com.sercice.ws.Calcws getcalcws() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(calcws_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getcalcws(endpoint);
    }

    public com.sercice.ws.Calcws getcalcws(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.sercice.ws.CalcwsSoapBindingStub _stub = new com.sercice.ws.CalcwsSoapBindingStub(portAddress, this);
            _stub.setPortName(getcalcwsWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setcalcwsEndpointAddress(java.lang.String address) {
        calcws_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.sercice.ws.Calcws.class.isAssignableFrom(serviceEndpointInterface)) {
                com.sercice.ws.CalcwsSoapBindingStub _stub = new com.sercice.ws.CalcwsSoapBindingStub(new java.net.URL(calcws_address), this);
                _stub.setPortName(getcalcwsWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("calcws".equals(inputPortName)) {
            return getcalcws();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.sercice.com", "calcwsService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.sercice.com", "calcws"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("calcws".equals(portName)) {
            setcalcwsEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
