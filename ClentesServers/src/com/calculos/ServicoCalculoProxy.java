package com.calculos;

public class ServicoCalculoProxy implements com.calculos.ServicoCalculo {
  private String _endpoint = null;
  private com.calculos.ServicoCalculo servicoCalculo = null;
  
  public ServicoCalculoProxy() {
    _initServicoCalculoProxy();
  }
  
  public ServicoCalculoProxy(String endpoint) {
    _endpoint = endpoint;
    _initServicoCalculoProxy();
  }
  
  private void _initServicoCalculoProxy() {
    try {
      servicoCalculo = (new com.calculos.ServicoCalculoServiceLocator()).getservicoCalculo();
      if (servicoCalculo != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)servicoCalculo)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)servicoCalculo)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (servicoCalculo != null)
      ((javax.xml.rpc.Stub)servicoCalculo)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.calculos.ServicoCalculo getServicoCalculo() {
    if (servicoCalculo == null)
      _initServicoCalculoProxy();
    return servicoCalculo;
  }
  
  public java.lang.String getResultado(java.lang.String operacao, float valor1, float valor2) throws java.rmi.RemoteException{
    if (servicoCalculo == null)
      _initServicoCalculoProxy();
    return servicoCalculo.getResultado(operacao, valor1, valor2);
  }
  
  
}