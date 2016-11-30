package com.calculadora;

public class CalculoWebServiceProxy implements com.calculadora.CalculoWebService {
  private String _endpoint = null;
  private com.calculadora.CalculoWebService calculoWebService = null;
  
  public CalculoWebServiceProxy() {
    _initCalculoWebServiceProxy();
  }
  
  public CalculoWebServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initCalculoWebServiceProxy();
  }
  
  private void _initCalculoWebServiceProxy() {
    try {
      calculoWebService = (new com.calculadora.CalculoWebServiceServiceLocator()).getCalculoWebService();
      if (calculoWebService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)calculoWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)calculoWebService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (calculoWebService != null)
      ((javax.xml.rpc.Stub)calculoWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.calculadora.CalculoWebService getCalculoWebService() {
    if (calculoWebService == null)
      _initCalculoWebServiceProxy();
    return calculoWebService;
  }
  
  public java.lang.String getResultado(java.lang.String operacao, float numerador, float denonominador) throws java.rmi.RemoteException{
    if (calculoWebService == null)
      _initCalculoWebServiceProxy();
    return calculoWebService.getResultado(operacao, numerador, denonominador);
  }
  
  
}