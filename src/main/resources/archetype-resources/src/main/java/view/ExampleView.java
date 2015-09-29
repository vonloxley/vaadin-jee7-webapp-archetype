#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.view;

import com.vaadin.cdi.CDIView;
import com.vaadin.event.LayoutEvents;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import javax.annotation.PostConstruct;
import org.vaadin.viritin.label.Header;
import org.vaadin.viritin.layouts.MVerticalLayout;

@CDIView("Example")
public class ExampleView extends MVerticalLayout implements View {

    @PostConstruct
    public void initComponent() {
        addComponents(
                new Header("Another view")
        );

        addLayoutClickListener((LayoutEvents.LayoutClickEvent event) -> {
        });

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }

}
