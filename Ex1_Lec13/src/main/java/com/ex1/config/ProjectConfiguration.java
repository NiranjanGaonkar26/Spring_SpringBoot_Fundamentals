package com.ex1.config;
import com.ex1.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfiguration {

    @Bean(name="Vehicle_Creta")
    Vehicle vehicle1()
    {
        Vehicle veh = new Vehicle();
        veh.setName("Creta");
        return veh;
    }

    @Bean(value = "Vehicle_XUV500")
    Vehicle vehicle2(){
        Vehicle veh = new Vehicle();
        veh.setName("XUV500");
        return veh;
    }

    @Bean("Vehicle_Thar")
    Vehicle vehicle3(){
        Vehicle veh = new Vehicle();
        veh.setName("Thar");
        return veh;
    }

    @Bean
    String str1(){
        return "Str1 Bean - Not Primary";
    }

    @Primary
    @Bean
    String str2(){
        return "Str2 Bean - Primary";
    }
}
