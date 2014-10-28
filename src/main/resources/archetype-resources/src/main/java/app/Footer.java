#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.app;

import com.vaadin.cdi.UIScoped;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import java.io.Serializable;

@UIScoped
public class Footer extends HorizontalLayout implements Serializable {

    private final Panel statuspanel;
    private final Panel namepanel;
    private final Panel versionpanel;

    Footer() {
        statuspanel = new Panel("&nbsp;");
        namepanel = new Panel("Anwendungsname");
        versionpanel = new Panel("Version: 0.1");

        setWidth("100%");
        addComponent(namepanel);
        addComponent(versionpanel);
        addComponent(statuspanel);
    }

    public void setName(String name) {
        namepanel.setCaption(name);
    }

    public void setVersion(String version) {
        versionpanel.setCaption(version);
    }

    public void setStatus(String status) {
        if (status == null || "".equals(status)) {
            status = "&nbsp;";
        }
        statuspanel.setCaption(status);
    }
}
