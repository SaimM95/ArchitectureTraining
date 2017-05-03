package td.training.linkedinsenior.platform.dependency_injection;

import dagger.Module;
import dagger.Provides;
import td.training.linkedinsenior.data.InMemoryRepo;
import td.training.linkedinsenior.domain.EntityGateway;

import javax.inject.Singleton;

@Module
public class EntityGatewayModule {

    @Singleton
    @Provides
    EntityGateway providesEntityGateway() {
        return new InMemoryRepo();
    }
}
