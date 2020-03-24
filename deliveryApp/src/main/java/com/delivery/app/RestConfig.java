
package com.delivery.app;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.ParameterNameProvider;
import javax.validation.Validation;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.ContextResolver;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.yaml.snakeyaml.constructor.Construct;
import org.glassfish.jersey.moxy.json.MoxyJsonConfig;
import org.glassfish.jersey.moxy.json.MoxyJsonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.validation.ValidationConfig;
import org.glassfish.jersey.server.validation.internal.InjectingConstraintValidatorFactory;

import com.delivery.app.endpoint.OrderEndpoint;
import com.delivery.app.service.OrderService;

@Configuration
@ApplicationPath("api")
public class RestConfig extends ResourceConfig {
	public RestConfig() {
		
		//register(OrderService.class);
		register(OrderEndpoint.class);
		register(ValidationConfigurationContextResolver.class);

        // Providers - JSON.
        //register(MoxyJsonFeature.class);
        //register(JsonConfiguration.class);
		
	}

	//@PostConstruct
	//public void setup() {
		//register(OrderService.class);
		//register(OrderEndpoint.class);
		
	//}
	
	/**
     * Custom configuration of validation. This configuration defines custom:
     * <ul>
     *     <li>ConstraintValidationFactory - so that validators are able to inject Jersey providers/resources.</li>
     *     <li>ParameterNameProvider - if method input parameters are invalid, this class returns actual parameter names
     *     instead of the default ones ({@code arg0, arg1, ..})</li>
     * </ul>
     */
    public static class ValidationConfigurationContextResolver implements ContextResolver<ValidationConfig> {

        @Context
        private ResourceContext resourceContext;

        @Override
        public ValidationConfig getContext(final Class<?> type) {
            return new ValidationConfig()
                    .constraintValidatorFactory(resourceContext.getResource(InjectingConstraintValidatorFactory.class))
                    .parameterNameProvider(new CustomParameterNameProvider());
        }

        /**
         * See ContactCardTest#testAddInvalidContact.
         */
        private class CustomParameterNameProvider implements ParameterNameProvider {

            private final ParameterNameProvider nameProvider;

            public CustomParameterNameProvider() {
                nameProvider = Validation.byDefaultProvider().configure().getDefaultParameterNameProvider();
            }

            @Override
            public List<String> getParameterNames(final Construct<?> constructor) {
                return nameProvider.getParameterNames(constructor);
            }

            @Override
            public List<String> getParameterNames(final Method method) {
                // See ContactCardTest#testAddInvalidContact.
                
                return nameProvider.getParameterNames(method);
            }

			@Override
			public List<String> getParameterNames(Constructor<?> arg0) {
				// TODO Auto-generated method stub
				return null;
			}
        }
    }

    /**
     * Configuration for {@link org.eclipse.persistence.jaxb.rs.MOXyJsonProvider} - outputs formatted JSON.
     */
    public static class JsonConfiguration implements ContextResolver<MoxyJsonConfig> {

        @Override
        public MoxyJsonConfig getContext(final Class<?> type) {
            final MoxyJsonConfig config = new MoxyJsonConfig();
            config.setFormattedOutput(true);
            return config;
        }
    }
}
