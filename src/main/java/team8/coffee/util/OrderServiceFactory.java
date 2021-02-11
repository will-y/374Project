package team8.coffee.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import team8.coffee.service.AdvancedOrderStrategy;
import team8.coffee.service.OrderService;
import team8.coffee.service.ProgrammableOrderStrategy;
import team8.coffee.service.SimpleOrderStrategy;

//Here is where we use factory pattern, to help us deal with different types of order to send to the
// different types of coffee machines

@Service
public class OrderServiceFactory implements ApplicationContextAware {

    private static ApplicationContext context;

    public OrderService createOrderService(ControllerType controllerType) {
        OrderService service = new OrderService();
        switch (controllerType) {
            case SIMPLE:
                service.applyStrategy(new SimpleOrderStrategy());
                break;
            case ADVANCED:
                service.applyStrategy(new AdvancedOrderStrategy());
                break;
            case PROGRAMMABLE:
                service.applyStrategy(new ProgrammableOrderStrategy());
                break;
        }

        AutowireCapableBeanFactory awcbf = context.getAutowireCapableBeanFactory();
        awcbf.autowireBean(service);

        return service;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
