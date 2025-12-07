package com.in28minutes.learn_spring_framework.examples.g1;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import java.util.Arrays;

//@Component
@Named
class BusinessService{
    private DataService dataService;

//    @Autowired
    @Inject
    public void setDataService(DataService dataService) {
        System.out.println("Setter Injection - setDataService");
        this.dataService = dataService;
    }

    public DataService getDataService() {
        return dataService;
    }

}

//@Component
@Named
class DataService{

}

@Configuration
@ComponentScan
public class CdiContextLauncherApplication {
    public static void main(String[] args){
        try(var context = new AnnotationConfigApplicationContext(CdiContextLauncherApplication.class))
        {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println(context.getBean(BusinessService.class).getDataService());
        }
    }
}
//Jakarta CDI(Contexts and Dependency Injection)
//Inject API - part of Jakarta EE
//@Named (~ @Component)
//@Inject (~ @Autowired)
//@Singleton (~ @Scope("singleton"))
//@Qualifier
//@Scope
