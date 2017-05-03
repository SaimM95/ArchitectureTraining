package td.training.linkedinsenior.platform.dependency_injection;

import dagger.Module;
import dagger.Provides;
import td.training.linkedinsenior.data.InMemoryRepo;
import td.training.linkedinsenior.domain.EntityGateway;

@Module
public class EntityGatewayModule {

    @Provides
    EntityGateway providesEntityGateway() {
        return new InMemoryRepo();
    }
}
