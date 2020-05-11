package ch.swaechter.angularjuniversal.springboot.starter;

import ch.swaechter.angularjuniversal.renderer.Renderer;
import ch.swaechter.angularjuniversal.renderer.configuration.RenderConfiguration;
import org.jetbrains.annotations.NotNull;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.view.AbstractTemplateViewResolver;
import org.springframework.web.servlet.view.AbstractUrlBasedView;

import java.util.Locale;

/**
 * This class is responsible for resolving our view requests if the routing matches.
 *
 * @author Simon Wächter
 */
public class AngularJUniversalViewResolver extends AbstractTemplateViewResolver {

    /**
     * Renderer that will be passed to the view for rendering the page request.
     */
    @NotNull
    private final Renderer renderer;

    /**
     * Render configuration that will be used to check the routes.
     */
    @NotNull
    private final RenderConfiguration renderConfiguration;

    /**
     * Constructor with the renderer and properties that will be passed to the view.
     *
     * @param renderer            Renderer
     * @param renderConfiguration Render configuration
     */
    public AngularJUniversalViewResolver(@NotNull Renderer renderer, @NotNull RenderConfiguration renderConfiguration) {
        setViewClass(requiredViewClass());
        this.renderer = renderer;
        this.renderConfiguration = renderConfiguration;
    }

    /**
     * Define the required view class.
     *
     * @return AngularJ Universal view class
     */
    @Override
    @NotNull
    public Class<?> requiredViewClass() {
        return AngularJUniversalView.class;
    }

    /**
     * Check if the given model name can be handled as valid URI. If yes, we will render the request later on, otherwise
     * we will not.
     *
     * @param modelName Model name that we threat as URI
     * @param locale    Locale of the page request
     * @return Status of the check
     */
    @Override
    public boolean canHandle(@NotNull String modelName, @NotNull Locale locale) {
        @NotNull
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        for (String url : renderConfiguration.getRoutes()) {
            if (antPathMatcher.match(url, modelName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Build a valid view based on the given URI.
     *
     * @param uri URI of the page request
     * @return Valid view
     */
    @Override
    @NotNull
    public AbstractUrlBasedView buildView(@NotNull String uri) {
        return new AngularJUniversalView(renderer, renderConfiguration);
    }
}
