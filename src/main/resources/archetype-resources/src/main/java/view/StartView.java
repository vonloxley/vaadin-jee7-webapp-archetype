#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.view;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import javax.annotation.PostConstruct;
import org.vaadin.viritin.label.RichText;
import org.vaadin.viritin.layouts.MVerticalLayout;


@CDIView("")
public class DefautView extends MVerticalLayout implements View {

    @PostConstruct
    public void initComponent() {
        addComponents(
                new RichText().withMarkDownResource("/welcome.md")
        );

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }

}
