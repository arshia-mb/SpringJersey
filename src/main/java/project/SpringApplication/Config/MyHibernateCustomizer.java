package project.SpringApplication.Config;

import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MyHibernateCustomizer implements HibernatePropertiesCustomizer {
    @Override
    public void customize(Map<String, Object> hibernateProperties) {
        hibernateProperties.put("hibernate.query.plan_cache_max_size",40);
        hibernateProperties.put("hibernate.query.plan_parameter_metadata_max_size",40);
        hibernateProperties.put("hibernate.query.in_clause_parameter_padding",true);
    }
}