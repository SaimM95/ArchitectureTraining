package td.training.linkedinsenior.platform.dependency_injection;


import dagger.Module;
import dagger.Provides;
import td.training.linkedinsenior.domain.EntityGateway;
import td.training.linkedinsenior.domain.UseCaseFactory;

/**
 * 20170427. Initial version created by jorge.
 */
@Module
public class UseCaseFactoryModule {

    @Provides
    UseCaseFactory provideUseCaseFactory(EntityGateway entityGateway) {
        return new UseCaseFactory(entityGateway);
    }
}
