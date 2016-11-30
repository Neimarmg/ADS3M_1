/**
 * ServicoCalculoService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.calculos;

public interface ServicoCalculoService extends javax.xml.rpc.Service {
    public java.lang.String getservicoCalculoAddress();

    public com.calculos.ServicoCalculo getservicoCalculo() throws javax.xml.rpc.ServiceException;

    public com.calculos.ServicoCalculo getservicoCalculo(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
