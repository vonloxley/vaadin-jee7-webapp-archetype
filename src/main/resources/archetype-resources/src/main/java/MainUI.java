#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import com.vaadin.annotations.Theme;
import com.vaadin.cdi.CDIUI;
import com.vaadin.cdi.CDIViewProvider;
import ${package}.app.ViewMenu;
import ${package}.app.Footer;
import ${package}.view.ErrorView;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import javax.inject.Inject;
import org.vaadin.maddon.layouts.MVerticalLayout;

@CDIUI("")
@Theme("apptheme")
public class MainUI extends UI {
    static final String APP_NAME = "${artifactId}";

    @Inject
    private CDIViewProvider viewProvider;
    
    @Inject
    private ViewMenu menu;

    @Inject
    private Footer footer;
    
    @Override
    public void init(VaadinRequest request) {

        VerticalLayout mainarea = new VerticalLayout();
 
        Navigator navigator = new Navigator(this, mainarea);
        navigator.addProvider(viewProvider);
        navigator.setErrorView(ErrorView.class);
        
        footer.setName(APP_NAME);
        
        setContent(
                new MVerticalLayout(
                        menu.getBasicMenu(),
                        mainarea,
                        footer)
                // Comment for non-fixed app-height (screen-height);
                .expand(mainarea)
        );
    }    
}



