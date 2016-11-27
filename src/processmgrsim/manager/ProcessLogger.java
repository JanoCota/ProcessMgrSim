package processmgrsim.manager;

import java.util.LinkedList;
import processmgrsim.manager.Process;

/**
 *
 * @author janoc
 */
public class ProcessLogger {

    private LinkedList<Process> processList;

    public ProcessLogger() {
        processList = new LinkedList<>();
    }

    public void insert(Process process) {
        processList.add(process);
    }

    public LinkedList<String[]> asTableRowList() {
        LinkedList<String[]> l = new LinkedList<>();
        processList.forEach(p -> l.add(toArray(p)));
        return l;
    }

    private String[] toArray(Process p) {
        return new String[]{
            Integer.toString(p.getPID()),
            Double.toString(p.getTimeArrival() / 1000d),
            Integer.toString(p.getSize()),
            p.getTimeLoaded() == 0L ? "---" : Double.toString(p.getTimeLoaded() / 1000d),
            p.getTimeUnloaded() == 0L ? "---" : Double.toString(p.getTimeUnloaded() / 1000d)
        };
    }
}
