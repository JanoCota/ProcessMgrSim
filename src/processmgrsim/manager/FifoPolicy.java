/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processmgrsim.manager;

import java.util.LinkedList;

/**
 *
 * @author janoc
 */
public class FifoPolicy implements PlannerPolicy {

    @Override
    public LinkedList<Process> getExecutionPlan(LinkedList<Process> processTable) {
        LinkedList<Process> sorted = (LinkedList<Process>) processTable.clone();
        sorted.sort((p1, p2) -> Long.compare(p1.getTimeArrival(), p2.getTimeArrival()));
        return sorted;
    }

    @Override
    public Process getNext(LinkedList<Process> processTable) {
        return getExecutionPlan(processTable).peekFirst();
    }

    @Override
    public String getName() {
        return "FIFO";
    }
}
