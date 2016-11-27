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
public interface PlannerPolicy {

    public LinkedList<Process> getExecutionPlan(LinkedList<Process> processTable);

    public Process getNext(LinkedList<Process> processTable);

    public String getName();

}
