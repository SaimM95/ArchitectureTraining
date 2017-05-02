package td.training.linkedinsenior;

import dagger.Component;

@FragmentScope
@Component(modules = {ProgrammersListModule.class}, dependencies = {EntityGatewayComponent.class})
public interface ProgrammersListComponent {
    void inject(ProgrammersListActivity programmersListActivity);
}
