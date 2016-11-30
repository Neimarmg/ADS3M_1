package com.sercice.ws;

public class CalcwsProxy implements com.sercice.ws.Calcws {
  private String _endpoint = null;
  private com.sercice.ws.Calcws calcws = null;
  
  public CalcwsProxy() {
    _initCalcwsProxy();
  }
  
  public CalcwsProxy(String endpoint) {
    _endpoint = endpoint;
    _initCalcwsProxy();
  }
  
  private void _initCalcwsProxy() {
    try {
      calcws = (new com.sercice.ws.CalcwsServiceLocator()).getcalcws();
      if (calcws != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)calcws)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)calcws)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (calcws != null)
      ((javax.xml.rpc.Stub)calcws)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.sercice.ws.Calcws getCalcws() {
    if (calcws == null)
      _initCalcwsProxy();
    return calcws;
  }
  
  public java.lang.String wsRetorno(java.lang.String desc) throws java.rmi.RemoteException{
    if (calcws == null)
      _initCalcwsProxy();
    return calcws.wsRetorno(desc);
  }
  
  
}