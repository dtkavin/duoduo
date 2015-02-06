/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fls.common.webservice.xfire.test;

import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;
import org.fls.common.webservice.FlsWebService;

/**
 *
 * @author Tone
 */
public class WebServiceTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String serviceURL = "http://localhost:8080/fls/services/FlsWebService";
        Service serviceModel = new ObjectServiceFactory().create(FlsWebService.class, null, serviceURL, null);
        XFireProxyFactory serviceFactory = new XFireProxyFactory();
        try {
            FlsWebService service = (FlsWebService) serviceFactory.create(serviceModel, serviceURL);
            service.test("haha");
            System.out.println(service.getApplicationInfo("UPDATE", "455295168@qq.com", "12"));


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
