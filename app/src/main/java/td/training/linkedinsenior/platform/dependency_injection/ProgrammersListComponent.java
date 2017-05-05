package td.training.linkedinsenior.platform.dependency_injection;

import dagger.Component;
import td.training.linkedinsenior.platform.views.ProgrammersListActivity;

@FragmentScope
@Component(modules = {ProgrammersListModule.class, UseCaseFactoryModule.class}, dependencies = {EntityGatewayComponent.class})
public interface ProgrammersListComponent {
    void inject(ProgrammersListActivity programmersListActivity);
}
