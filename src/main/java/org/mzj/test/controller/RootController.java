package org.mzj.test.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mzj
 */
@RestController
@RequestMapping("")
public class RootController {
    /*
     使用 curl http://localhost:8280/mzjtestboot 无响应
     使用 curl http://localhost:8280/mzjtestboot/ 优先级为先"/"后""
     */
    /*
    @RequestMapping("/")
    public String index1() {
	    System.out.println("index1...");
        return "success1";
    }
    */

    @RequestMapping("")
    public String index2() {
    	System.out.println("index2...");
        InetAddress host = null;
        try {
            host = Inet4Address.getLocalHost();
        } catch (UnknownHostException e) {
        }
        return "success2 Host=" + host + " IPs=" + getServerIps();
    }

    public static String  getServerIps(){
        List<String> ips = new ArrayList<>();
        try {
            Enumeration netInterfaces = NetworkInterface.getNetworkInterfaces();
            while (netInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = (NetworkInterface) netInterfaces.nextElement();
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                StringBuffer sb = new StringBuffer("{");
                int i = 0;
                while (inetAddresses.hasMoreElements()) {
                    if (i > 0) {
                        sb.append(" ");
                    }
                    InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                    sb.append(inetAddress.getHostAddress());
                    i++;
                }
                sb.append("}");
                if (sb.length() > 2) {
                    ips.add(sb.toString());
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }

        return ips.stream().collect(Collectors.joining(",","[","]"));
    }
}
