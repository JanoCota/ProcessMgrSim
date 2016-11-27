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
public class ManagerWithPolicy extends Manager {

    public ManagerWithPolicy(int memorySize) {
        super(memorySize);
    }

    public Process executeNext(PlannerPolicy policy) {
        Process p = policy.getNext(getRunningProcesses());
        unload(p);
        loadFromQueue();
        return p;
    }

    public LinkedList<Process> executeAll(PlannerPolicy policy) throws InterruptedException {
        LinkedList<Process> execPlan = policy.getExecutionPlan(getRunningProcesses());
        for (Process p : execPlan) {
            unload(p);
            Thread.sleep(10);
        }
        loadFromQueue();
        return execPlan;
    }
}
