package com.example.accesskeybackend.template.controller;

import com.example.accesskeybackend.template.service.AccessKeyIpService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/web/")
@RequiredArgsConstructor
public class AccessKeyIpController {

    private final AccessKeyIpService accessKeyIpService;

    @GetMapping("/checkIpv6Support")
    public ResponseEntity<String> checkIpv6Support(@NotNull @RequestParam("siteUrl") String siteUrl) {
        return accessKeyIpService.isIpv6Supported(siteUrl);
    }
}
