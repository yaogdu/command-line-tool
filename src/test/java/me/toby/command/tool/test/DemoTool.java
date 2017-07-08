
package me.toby.command.tool.test;

import me.toby.command.tool.core.Job;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

import java.util.ArrayList;
import java.util.List;

/**
 * 类PushMain.java的实现描述：demo
 *
 * @author yaoguang.du 2017年7月4日 下午5:33:43
 */
public class DemoTool extends Job {


    static List<String> args = new ArrayList<String>();

    static {

        //options this tool support
        Options options = new Options();
        options.addOption("a", "appId", true, "demo app id");
        options.addOption("d", "date", true, "demo date");

        //register options
        registerOption(options);
    }


    //run
    @Override
    public void run(String[] args) throws Exception {
        try {

            String appId;
            String date;
            try {

                CommandLine cmdLine = parse(args, true);

                if (cmdLine.hasOption("help")) {
                    HelpFormatter formatter = new HelpFormatter();
                    formatter.printHelp("demo", getOptions(), true);
                    return;
                }

                appId = cmdLine.getOptionValue("appId");
                date = cmdLine.getOptionValue("date");

                System.out.println("appId is " + appId);
                System.out.println("date is " + date);

            } catch (Exception e) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("demo", getOptions(), true);
                return;
            }

        } catch (Exception e) {
            throw e;
        }
    }

}
