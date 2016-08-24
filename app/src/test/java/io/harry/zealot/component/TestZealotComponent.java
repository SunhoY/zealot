package io.harry.zealot.component;

import javax.inject.Singleton;

import dagger.Component;
import io.harry.zealot.activity.SplashActivity;
import io.harry.zealot.activity.SplashActivityTest;
import io.harry.zealot.activity.TestAjaeActivity;
import io.harry.zealot.activity.TestAjaeActivityTest;
import io.harry.zealot.fragment.GagFragment;
import io.harry.zealot.fragment.GagFragmentTest;
import io.harry.zealot.module.TestAnimationModule;
import io.harry.zealot.module.TestFirebaseModule;
import io.harry.zealot.module.TestGagTestModule;
import io.harry.zealot.module.TestPicassoModule;
import io.harry.zealot.service.GagService;
import io.harry.zealot.service.GagServiceTest;

@Singleton
@Component(modules = {
        TestAnimationModule.class,
        TestGagTestModule.class,
        TestFirebaseModule.class,
        TestPicassoModule.class,
})
public interface TestZealotComponent extends ZealotComponent {
    void inject(SplashActivity splashActivity);
    void inject(SplashActivityTest splashActivityTest);
    void inject(TestAjaeActivity testAjaeActivity);
    void inject(TestAjaeActivityTest testAjaeActivityTest);
    void inject(GagService gagService);
    void inject(GagServiceTest gagServiceTest);
    void inject(GagFragment gagFragment);
    void inject(GagFragmentTest gagFragmentTest);
}
