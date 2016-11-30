/**
 * CalcwsService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sercice.ws;

public interface CalcwsService extends javax.xml.rpc.Service {
    public java.lang.String getcalcwsAddress();

    public com.sercice.ws.Calcws getcalcws() throws javax.xml.rpc.ServiceException;

    public com.sercice.ws.Calcws getcalcws(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
