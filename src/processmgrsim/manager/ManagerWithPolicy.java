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

    private final int SLEEPTIME = 100;

    public ManagerWithPolicy(int memorySize) {
        super(memorySize);
    }

    public Process executeNext(PlannerPolicy policy) throws InterruptedException {
        Process p = policy.getNext(getRunningProcesses());
        unload(p);
        loadFromQueue(policy);
        return p;
    }

    public LinkedList<Process> executeAll(PlannerPolicy policy) throws InterruptedException {
        LinkedList<Process> execPlan = policy.getPlan(getRunningProcesses());
        for (Process p : execPlan) {
            unload(p);
            Thread.sleep(SLEEPTIME);
        }
        loadFromQueue(policy);
        return execPlan;
    }

    private void loadFromQueue(PlannerPolicy policy) throws InterruptedException {
        Process nxt;
        while (!processQueue.isEmpty() && fits(nxt = policy.getNext(processQueue))) {
            load(nxt);
            processQueue.remove(nxt);
            Thread.sleep(SLEEPTIME);
        }
    }
}
