package ch.swaechter.angularjuniversal.springboot.starter;

import ch.swaechter.angularjuniversal.renderer.configuration.RenderConfiguration;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * This class is responsible for registering all routes of the application, so no further mapping in the application is
 * required.
 *
 * @author Simon Wächter
 */
public class AngularJUniversalConfigurer implements WebMvcConfigurer {

    /**
     * Render configuration that will be used to check the routes.
     */
    @NotNull
    private final RenderConfiguration renderConfiguration;

    /**
     * Constructor with the render configuration.
     *
     * @param renderConfiguration Render configuration
     */
    public AngularJUniversalConfigurer(@NotNull RenderConfiguration renderConfiguration) {
        this.renderConfiguration = renderConfiguration;
    }

    /**
     * Add all view controllers than are defined as routing, so no further request mapping in the application is
     * required.
     *
     * @param viewControllerRegistry Registry to add new view controllers
     */
    @Override
    public void addViewControllers(@NotNull ViewControllerRegistry viewControllerRegistry) {
        for (String url : renderConfiguration.getRoutes()) {
            @NotNull
            ViewControllerRegistration viewControllerRegistration = viewControllerRegistry.addViewController(url);
            viewControllerRegistration.setViewName(url);
        }
    }
}
