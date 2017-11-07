package dynamictableapp.view.bean;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;

import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class DynamicTableBean {
    private RichInputText sqlQueryBind;

    public DynamicTableBean() {
    }

    /*****Generic Method to call operation binding**/
    public BindingContainer getBindingsCont() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    /**
     * Generic Method to execute operation Binding
     * */
    public OperationBinding executeOperation(String operation) {
        OperationBinding createParam = getBindingsCont().getOperationBinding(operation);
        return createParam;

    }

    /**Method to create viewObject
     * @param actionEvent
     */
    public void createViewObjectAction(ActionEvent actionEvent) {
        if (sqlQueryBind.getValue() != null) {
            OperationBinding ob = executeOperation("createNewViewObject");
            ob.getParamsMap().put("query", sqlQueryBind.getValue().toString());
            ob.execute();
        }
    }

    public void setSqlQueryBind(RichInputText sqlQueryBind) {
        this.sqlQueryBind = sqlQueryBind;
    }

    public RichInputText getSqlQueryBind() {
        return sqlQueryBind;
    }
}
