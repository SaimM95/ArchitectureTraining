package td.training.linkedinsenior;

import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {EntityGatewayModule.class})
public interface EntityGatewayComponent {
    EntityGateway getEntityGateway();
}
