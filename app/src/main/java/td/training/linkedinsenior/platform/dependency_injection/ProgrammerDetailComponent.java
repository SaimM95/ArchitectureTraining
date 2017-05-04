package td.training.linkedinsenior.platform.dependency_injection;

import dagger.Component;
import td.training.linkedinsenior.platform.views.ProgrammerDetailActivity;

@FragmentScope
@Component(modules = {ProgrammerDetailModule.class}, dependencies = {EntityGatewayComponent.class})
public interface ProgrammerDetailComponent {
    void inject(ProgrammerDetailActivity activity);
}
