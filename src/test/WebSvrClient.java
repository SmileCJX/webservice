package test;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.utils.StringUtils;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

/**
 * Created by Administrator on 2018/3/22/022.
 */
public class WebSvrClient {

    public static void main(String[] args) {

        String url = "http://localhost:8080/services/HelloWorld";
        String method = "sayTitle";
        String[] parms = new String[]{"科比"};
        WebSvrClient webClient = new WebSvrClient();

        String svrResult = webClient.callMethod(url, method, parms);

        System.out.println(svrResult);
    }

    public String callMethod(String url,String method,Object[] args) {
        String result = null;
        if (StringUtils.isEmpty(url)) {
            return "url地址为空";
        }

        if (StringUtils.isEmpty(method)) {
            return "method地址为空";
        }

        Call rpcCall = null;
        try {
            //实例webservice调动实例
            Service webService = new Service();
            rpcCall = (Call) webService.createCall();
            rpcCall.setTargetEndpointAddress(new java.net.URL(url));
            rpcCall.setOperationName(method);
            //执行webservice方法
//            rpcCall.setReturnType(XMLType.SOAP_STRING);
            result = (String)rpcCall.invoke(args);
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return result;
    }
}
