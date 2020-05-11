package ch.swaechter.angularjuniversal.springboot.starter;

import org.jetbrains.annotations.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/**
 * This class is responsible for providing all mapped properties.
 *
 * @author Simon Wächter
 */
@ConfigurationProperties(prefix = "angularjuniversal")
public class AngularJUniversalProperties {

    /**
     * Path or executable name of the Node.js executable. This path is used to start a Node.js process for rendering.
     */
    @NotNull
    private String nodepath = "node";

    /**
     * Port of the Node.js process is opening a TCP server.
     */
    @NotNull
    private Integer nodeport = 9090;

    /**
     * Path of the server bundle resource.
     */
    @NotNull
    private String serverbundleresourcepath = "/server.js";

    /**
     * Path of the index resource.
     */
    @NotNull
    private String indexresourcepath = "/public/index.html";

    /**
     * Charset used for reading and rendering.
     */
    @NotNull
    private Charset charset = StandardCharsets.UTF_8;

    /**
     * Comma separated list with all routes of the application.
     */
    @NotNull
    private List<String> routes = Arrays.asList("/");

    /**
     * Get the path or executable name of the Node.js executable.
     *
     * @return Node.js path or executable name
     */
    @NotNull
    public String getNodePath() {
        return nodepath;
    }

    /**
     * Set the new path or executable name of the Node.js executable.
     *
     * @param nodepath New Node.js path or executable name
     */
    public void setNodePath(@NotNull String nodepath) {
        this.nodepath = nodepath;
    }

    /**
     * Get the port of the Node.js TCP socket used for the rendering communication
     *
     * @return Node.js port used for TCP communication
     */
    @NotNull
    public Integer getNodePort() {
        return nodeport;
    }

    /**
     * Set the new port for the Node.js TCP socket used for the rendering communication.
     *
     * @param nodeport New Node.js port used for TCP communication
     */
    public void setNodePort(@NotNull Integer nodeport) {
        this.nodeport = nodeport;
    }

    /**
     * Get the path of the server bundle resource.
     *
     * @return Path of the server bundle
     */
    @NotNull
    public String getServerBundleResourcePath() {
        return serverbundleresourcepath;
    }

    /**
     * Set the path of the new server bundle resource.
     *
     * @param serverbundleresourcepath Path of the new server bundle resource
     */
    public void setServerBundleResourcePath(@NotNull String serverbundleresourcepath) {
        this.serverbundleresourcepath = serverbundleresourcepath;
    }

    /**
     * Get the path of the index resource.
     *
     * @return Path of the index resource
     */
    @NotNull
    public String getIndexResourcePath() {
        return indexresourcepath;
    }

    /**
     * Set the path of the new index resource.
     *
     * @param indexresourcepath Path of the new index resource
     */
    public void setIndexResourcePath(@NotNull String indexresourcepath) {
        this.indexresourcepath = indexresourcepath;
    }

    /**
     * Get the charset used for reading and rendering.
     *
     * @return Charset
     */
    @NotNull
    public Charset getCharset() {
        return charset;
    }

    /**
     * Set the new charset.
     *
     * @param charset New charset
     */
    public void setCharset(@NotNull Charset charset) {
        this.charset = charset;
    }

    /**
     * Get all routes as list.
     *
     * @return All routes as list
     */
    @NotNull
    public List<String> getRoutes() {
        return routes;
    }

    /**
     * Set all routes as list.
     *
     * @param routes All routes as list
     */
    public void setRoutes(@NotNull List<String> routes) {
        this.routes = routes;
    }
}
