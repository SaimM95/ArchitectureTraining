package td.training.linkedinsenior.platform;

import td.training.linkedinsenior.platform.dependency_injection.EntityGatewayComponent;
import td.training.linkedinsenior.platform.dependency_injection.NewProgrammerComponent;
import td.training.linkedinsenior.platform.dependency_injection.ProgrammerDetailComponent;
import td.training.linkedinsenior.platform.dependency_injection.ProgrammersListComponent;

public interface ApplicationServiceLocator {
    ProgrammersListComponent getProgrammersListComponent();
    NewProgrammerComponent getNewProgrammerComponent();
    ProgrammerDetailComponent getProgrammerDetailComponent(String id);
    EntityGatewayComponent getEntityGatewayComponent();
}
