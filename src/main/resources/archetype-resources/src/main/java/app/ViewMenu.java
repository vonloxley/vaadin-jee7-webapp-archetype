#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.app;

import com.vaadin.cdi.CDIView;
import com.vaadin.cdi.UIScoped;
import com.vaadin.navigator.View;
import com.vaadin.ui.Component;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;
import java.io.Serializable;
import java.util.Set;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;

@UIScoped
public class ViewMenu implements Serializable {

    @Inject
    private BeanManager beanManager;

    @Inject 
    private Footer footer;
    
    private Set<Bean<?>> getAvailableViews() {
        Set<Bean<?>> all = beanManager.getBeans(View.class,
                new AnnotationLiteral<Any>() {
                });
        // TODO check if accessible for current user
        return all;
    }

    public Component getBasicMenu() {
        MenuBar menuBar = new MenuBar();
        getAvailableViews()
                .stream()
                .map((viewBean) -> viewBean.getBeanClass())
                .filter((beanClass) -> (beanClass.getAnnotation(CDIView.class) != null))
                .forEach((beanClass) -> {
                    CDIView cdiview = beanClass.getAnnotation(CDIView.class);
                    menuBar.addItem( cdiview.value().isEmpty()?"Start":cdiview.value(), (MenuBar.MenuItem selectedItem) -> {
                        UI.getCurrent().getNavigator().navigateTo(cdiview.value());
                        footer.setStatus(cdiview.value());
                    });
                });

        return menuBar;
    }

    protected String getNameFor(Class<?> viewType) {
        return viewType.getSimpleName();
    }
}
