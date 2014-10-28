#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import org.vaadin.maddon.label.RichText;
import org.vaadin.maddon.layouts.MVerticalLayout;

public class ErrorView extends MVerticalLayout implements View {

    public ErrorView() {
        addComponents(
                new RichText().withMarkDownResource("/error.md")
        );
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        // TODO, figure out how to get the error that caused this view to 
        // be instantiated
    }
}
