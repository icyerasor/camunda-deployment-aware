# camunda-deployment-aware
Deployment Aware Example

#### Steps to reproduce

 * Make sure you have no existing h2-db at ~/test.mv.db
 * Run `mvn spring-boot:run` in **app-one**
 * It will start up, deploy its processes and hit an expected error after 5 seconds:  
   `no processes deployed with key 'app_two_proc' and tenant-id 'null': processDefinition is null`
 * Run `mvn spring-boot:run` in app-two
 * After about another minute (when the timer fires again) **app-one** will start a new process
 * You can see `Executing Task1 for proc with businessKey` in **app-one** and `Executing Task2 for proc with businessKey` in **app-two**.
 * Everything as expected so far
 * Now restart **app-one**
 * It will redeploy(?) the dummy.bpmn, figure out it wants to execute all processes of that deployment, too, excute **app-two-proc** and thus you'll end up with a  
     ` Unknown property used in expression: ${task2}. Cause: Cannot resolve identifier 'task2'` 
    (or classNotFound if you use FQN-Delegates).
