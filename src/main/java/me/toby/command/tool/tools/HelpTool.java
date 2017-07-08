
package me.toby.command.tool.tools;

import me.toby.command.tool.core.Job;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;


/**
 * 类HelpTool.java的实现描述：help 类
 *
 * @author yaoguang.du 2017年7月7日 下午4:21:40
 */
public class HelpTool extends Job {


    /*
     * (non-Javadoc)
     * @see com.duolabao.compass.push.core.Job#run(java.lang.String[])
     */
    @Override
    public void run(String[] args) throws Exception {
    }

    /*
     * (non-Javadoc)
     * @see com.duolabao.compass.push.core.Job#applyOptions(org.apache.commons.cli.Options)
     */
    @Override
    public void applyOptions(Options baseOptions, CommandLine cmdLine) throws Exception {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("help", baseOptions, true);
    }

}
