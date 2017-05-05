package td.training.linkedinsenior.platform;

import android.app.Application;

import td.training.linkedinsenior.platform.dependency_injection.DaggerEntityGatewayComponent;
import td.training.linkedinsenior.platform.dependency_injection.DaggerNewProgrammerComponent;
import td.training.linkedinsenior.platform.dependency_injection.DaggerProgrammerDetailComponent;
import td.training.linkedinsenior.platform.dependency_injection.DaggerProgrammersListComponent;
import td.training.linkedinsenior.platform.dependency_injection.EntityGatewayComponent;
import td.training.linkedinsenior.platform.dependency_injection.NewProgrammerComponent;
import td.training.linkedinsenior.platform.dependency_injection.ProgrammerDetailComponent;
import td.training.linkedinsenior.platform.dependency_injection.ProgrammerDetailModule;
import td.training.linkedinsenior.platform.dependency_injection.ProgrammersListComponent;
import td.training.linkedinsenior.platform.dependency_injection.ProgrammersListModule;

public class RealProgrammerApplication extends Application implements ApplicationServiceLocator {
    private EntityGatewayComponent mEntityGatewayComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mEntityGatewayComponent = DaggerEntityGatewayComponent.builder()
                .build();
    }

    @Override
    public ProgrammersListComponent getProgrammersListComponent() {
        return DaggerProgrammersListComponent.builder()
                .entityGatewayComponent(getEntityGatewayComponent())
                .programmersListModule(new ProgrammersListModule())
                .build();
    }

    @Override
    public NewProgrammerComponent getNewProgrammerComponent() {
        return DaggerNewProgrammerComponent.builder()
                .entityGatewayComponent(getEntityGatewayComponent())
                .build();
    }

    @Override
    public ProgrammerDetailComponent getProgrammerDetailComponent(String id) {
        return DaggerProgrammerDetailComponent.builder()
                .programmerDetailModule(new ProgrammerDetailModule(id))
                .entityGatewayComponent(getEntityGatewayComponent())
                .build();
    }

    @Override
    public EntityGatewayComponent getEntityGatewayComponent() {
        return mEntityGatewayComponent;
    }
}
