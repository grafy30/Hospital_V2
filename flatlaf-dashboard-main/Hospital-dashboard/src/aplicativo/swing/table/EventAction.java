package aplicativo.swing.table;

import Hospital.Modelo.ModelStudent;

public interface EventAction {

    public void delete(ModelStudent student);

    public void update(ModelStudent student);
}
