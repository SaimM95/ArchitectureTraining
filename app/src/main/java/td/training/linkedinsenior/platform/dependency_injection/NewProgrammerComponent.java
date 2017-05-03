package td.training.linkedinsenior.platform.dependency_injection;

import dagger.Component;
import td.training.linkedinsenior.platform.views.NewProgrammerActivity;

@FragmentScope
@Component(modules = { NewProgrammerModule.class }, dependencies = { EntityGatewayComponent.class })
public interface NewProgrammerComponent {
    void inject(NewProgrammerActivity newProgrammerActivity);
}
