package td.training.linkedinsenior;

import dagger.Module;
import dagger.Provides;

@Module
public class EntityGatewayModule {

    @Provides EntityGateway providesEntityGateway() {
        return new InMemoryRepo();
    }
}
