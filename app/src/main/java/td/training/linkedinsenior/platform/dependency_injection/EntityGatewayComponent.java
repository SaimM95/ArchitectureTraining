package td.training.linkedinsenior.platform.dependency_injection;

import dagger.Component;
import td.training.linkedinsenior.domain.EntityGateway;

import javax.inject.Singleton;

@Singleton
@Component(modules = {EntityGatewayModule.class})
public interface EntityGatewayComponent {
    EntityGateway getEntityGateway();
}
