package com.example.accesskeybackend.template.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.*;

@Service
@RequiredArgsConstructor
public class AccessKeyIpService {
    public ResponseEntity<String> isIpv6Supported(String siteUrl) {
        try {

            URL url;
            if (siteUrl.startsWith("http://") || siteUrl.startsWith("https://")) {
                url = new URL(siteUrl);
            } else {
                url = new URL("http://" + siteUrl);
            }

            InetAddress[] addresses = InetAddress.getAllByName(url.getHost());
            for (InetAddress address : addresses) {
                if (address instanceof Inet6Address) {
                    return ResponseEntity.ok("success - " + true);
                }
            }
        } catch (UnknownHostException | MalformedURLException ex) {
            System.err.println(ex.getMessage());
        }
        return ResponseEntity.ok("success - " + false);
    }
}
