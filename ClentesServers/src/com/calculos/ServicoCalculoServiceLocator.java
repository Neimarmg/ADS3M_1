/**
 * ServicoCalculoServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.calculos;

public class ServicoCalculoServiceLocator extends org.apache.axis.client.Service implements com.calculos.ServicoCalculoService {

    public ServicoCalculoServiceLocator() {
    }


    public ServicoCalculoServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServicoCalculoServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for servicoCalculo
    private java.lang.String servicoCalculo_address = "http://localhost:8080/wsmatematica/services/servicoCalculo";

    public java.lang.String getservicoCalculoAddress() {
        return servicoCalculo_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String servicoCalculoWSDDServiceName = "servicoCalculo";

    public java.lang.String getservicoCalculoWSDDServiceName() {
        return servicoCalculoWSDDServiceName;
    }

    public void setservicoCalculoWSDDServiceName(java.lang.String name) {
        servicoCalculoWSDDServiceName = name;
    }

    public com.calculos.ServicoCalculo getservicoCalculo() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(servicoCalculo_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getservicoCalculo(endpoint);
    }

    public com.calculos.ServicoCalculo getservicoCalculo(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.calculos.ServicoCalculoSoapBindingStub _stub = new com.calculos.ServicoCalculoSoapBindingStub(portAddress, this);
            _stub.setPortName(getservicoCalculoWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setservicoCalculoEndpointAddress(java.lang.String address) {
        servicoCalculo_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.calculos.ServicoCalculo.class.isAssignableFrom(serviceEndpointInterface)) {
                com.calculos.ServicoCalculoSoapBindingStub _stub = new com.calculos.ServicoCalculoSoapBindingStub(new java.net.URL(servicoCalculo_address), this);
                _stub.setPortName(getservicoCalculoWSDDServiceName());
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
        if ("servicoCalculo".equals(inputPortName)) {
            return getservicoCalculo();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://calculos.com", "servicoCalculoService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://calculos.com", "servicoCalculo"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("servicoCalculo".equals(portName)) {
            setservicoCalculoEndpointAddress(address);
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
