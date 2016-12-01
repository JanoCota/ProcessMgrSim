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
public class SmallestSizePolicy implements PlannerPolicy {

    @Override
    public LinkedList<Process> getPlan(LinkedList<Process> processTable) {
        LinkedList<Process> sorted = (LinkedList<Process>) processTable.clone();
        sorted.sort((Process p1, Process p2) -> {
            if (p1.getSize() != p2.getSize()) {
                return Integer.compare(p1.getSize(), p2.getSize());
            } else {
                return Long.compare(p1.getTimeArrival(), p2.getTimeArrival());
            }
        });
        return sorted;
    }

    @Override
    public Process getNext(LinkedList<Process> processTable) {
        return getPlan(processTable).peekFirst();
    }

    @Override
    public String getName() {
        return "Menor tanaño";
    }
}
