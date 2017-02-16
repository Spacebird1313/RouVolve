package be.uantwerpen.rouvolvo.configurations;

import be.uantwerpen.rouvolvo.services.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Thomas on 25/02/2016.
 */
@Configuration
public class SystemLoader implements ApplicationRunner
{
    @Autowired
    TerminalService terminalService;

    //Run after Spring context initialization
    public void run(ApplicationArguments args)
    {
        new Thread(new StartupProcess()).start();
    }

    private class StartupProcess implements Runnable
    {
        @Override
        public void run()
        {
            try
            {
                Thread.sleep(200);
            }
            catch(InterruptedException ex)
            {
                //Thread interrupted
            }

            terminalService.systemReady();
        }
    }
}
