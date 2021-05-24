package com.example.springbootlogging.api;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/log")
public class LogEndpoint {
    //LoggerFactory=içerisinde asenkron bir logları içerisine yazabileceğimiz class instance ı veriyo

   // Logger logger= LoggerFactory.getLogger(this.getClass());//parantez içine LogEndpoint.class de yazılabilir//LogEndpoint classı için bir logger ver bana bu class için yazdığım bütün logları "logger" a devredicem "logger"da işlemler yapıcak
    //her class içerisinde yukarıdaki satırı yazmamız gerekiyor BUNDAN BİZİ KURTARACAK ANOTASYON @SLF4J DUR "log.info" kullanmamızı sağlar
    @GetMapping
    public String getDetails(){

        log.info("get details methodu basladı");
        return internalLogDetail();
    }

    private String internalLogDetail(){
        try
        {
            log.debug("internalLogDetail methodu basladı");
            Thread.sleep(1000);
            return "API mesaj";
        }
        catch (InterruptedException e)
        {
            log.error("Hata:{}",e);
        }
        return "";
    }

    /*
    -Loglama Asenkron olmalıdır.
    -printStackTrace ve System.out.println() kullanılmamalıdır nedeni:formatlarımıza ayrırı
    -Sensitive data olmamalidir. müşteri bilgisi kullanıcıid password bircok sey kullanılmamalıdır.
    -Tum loglar merkezi toplanmalıdır,belli formatta
    -Level dikkatli kullanılmalıdır mesela sisteme login oldu diye onu error log olarak vermem saçma olur
    -Farklı levellar için farklı appenderlar kullanılabilir
    */


}
